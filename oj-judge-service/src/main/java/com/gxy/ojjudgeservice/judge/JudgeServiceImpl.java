package com.gxy.oj.judge;

import java.util.Date;
import java.util.Objects;

import cn.hutool.json.JSONUtil;
import com.gxy.oj.common.ErrorCode;
import com.gxy.oj.exception.BusinessException;
import com.gxy.oj.judge.strategy.DefaultJudgeStrategy;
import com.gxy.oj.judge.strategy.JudgeContext;
import com.gxy.oj.judge.strategy.JudgeStrategy;
import com.gxy.oj.model.dto.questionsubmit.JudgeInfo;
import com.gxy.oj.model.entity.Question;
import com.gxy.oj.model.entity.QuestionSubmit;
import com.gxy.oj.model.enums.QuestionSubmitStatusEnum;
import com.gxy.oj.service.QuestionService;
import com.gxy.oj.service.QuestionSubmitService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JudgeServiceImpl implements JudgeService {
    @Resource
    private QuestionSubmitService questionSubmitService;
    @Resource
    private QuestionService questionService;
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
        QuestionSubmit questionSubmit = questionSubmitService.getById(id);
        if (questionSubmit == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "提交记录不存在");
        }
        QuestionSubmit questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmit.getId());
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());

        Question question = questionService.getById(questionSubmit.getQuestionId());
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
            throw new RuntimeException(e);
        }
        //更新提交题目信息
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.SUCCESS.getValue());
        questionSubmitUpdate.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        questionSubmitUpdate.setUpdateTime(new Date());
        boolean b = questionSubmitService.updateById(questionSubmitUpdate);
        if (!b) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "更新题目状态失败");
        }
        return questionSubmitService.getById(id);
    }
}
