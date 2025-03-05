package com.gxy.ojjudgeservice.judge;

import cn.hutool.json.JSONUtil;

import com.gxy.ojcommon.common.ErrorCode;
import com.gxy.ojcommon.exception.BusinessException;
import com.gxy.ojjudgeservice.judge.strategy.JudgeContext;
import com.gxy.ojmodel.model.dto.questionsubmit.JudgeInfo;
import com.gxy.ojmodel.model.entity.Question;
import com.gxy.ojmodel.model.entity.QuestionSubmit;
import com.gxy.ojmodel.model.enums.QuestionSubmitStatusEnum;

import com.gxy.ojserviceclient.service.QuestionFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

@Service
public class JudgeServiceImpl implements JudgeService {
    private static final Logger log = LoggerFactory.getLogger(JudgeServiceImpl.class);
    @Resource
    private QuestionFeignClient questionFeignClient;
    @Resource
    private JudgeManager judgeManager;

    /**
     * 根据id判断题目
     *
     * @param id
     * @return
     */
    @Override
    public QuestionSubmit doJudge(Long id) {
        QuestionSubmit questionSubmit = questionFeignClient.getQuestionSubmitById(id);
        if (questionSubmit == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "提交记录不存在");
        }
        QuestionSubmit questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmit.getId());
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());

        Question question = questionFeignClient.getById(questionSubmit.getQuestionId());
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "题目不存在");
        }
        if (!Objects.equals(questionSubmit.getStatus(), QuestionSubmitStatusEnum.WAITING.getValue())) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "题目正在判题中");
        }

        JudgeContext judgeContext = JudgeContext.builder()
                .question(question)
                .questionSubmit(questionSubmit)
                .build();
        JudgeInfo judgeInfo = null;
        //todo 失败逻辑有问题
        try {
            judgeInfo = judgeManager.doJudge(judgeContext);
        } catch (Exception e) {
            questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.FAILED.getValue());
            log.error("判题异常", e);
        }
        //更新提交题目信息
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.SUCCESS.getValue());
        questionSubmitUpdate.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        questionSubmitUpdate.setUpdateTime(new Date());
        boolean b = questionFeignClient.updateQuestionSubmitById(questionSubmitUpdate);
        if (!b) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "更新题目状态失败");
        }
        return questionFeignClient.getQuestionSubmitById(id);
    }
}
