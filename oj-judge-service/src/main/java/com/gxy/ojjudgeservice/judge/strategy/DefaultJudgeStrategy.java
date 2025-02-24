package com.gxy.oj.judge.strategy;

import cn.hutool.json.JSONUtil;
import com.gxy.oj.judge.codesandbox.CodeSandBox;
import com.gxy.oj.judge.codesandbox.CodeSandBoxFactory;
import com.gxy.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.gxy.oj.judge.codesandbox.model.ExecuteCodeResponse;
import com.gxy.oj.model.dto.question.JudgeCase;
import com.gxy.oj.model.dto.question.JudgeConfig;
import com.gxy.oj.model.dto.questionsubmit.JudgeInfo;
import com.gxy.oj.model.entity.Question;
import com.gxy.oj.model.entity.QuestionSubmit;
import com.gxy.oj.model.enums.JudgeInfoMessageEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 默认判题策略
 */
@Service
public class DefaultJudgeStrategy implements JudgeStrategy {
    @Value("${codesandbox.type}")
    private String type;

    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        Question question = judgeContext.getQuestion();
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();

        //获取输入输出
        String judgeCase = question.getJudgeCase();
        List<JudgeCase> judgeCaseList = JSONUtil.toList(judgeCase, JudgeCase.class);
        List<String> judgeInputList = judgeCaseList.stream().map(JudgeCase::getInput).collect(Collectors.toList());
        List<String> judgeOutputList = judgeCaseList.stream().map(JudgeCase::getOutput).collect(Collectors.toList());
        String judgeConfigStr = judgeContext.getQuestion().getJudgeConfig();
        //根据提交内容获取代码和编程语言
        String code = questionSubmit.getCode();
        String language = questionSubmit.getLanguage();
        //调用代码沙箱
        ExecuteCodeRequest executeCodeRequest = new ExecuteCodeRequest(code, judgeInputList, language);
        CodeSandBox codeSandBox = CodeSandBoxFactory.getCodeSandBox(type);
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        List<String> outputList = executeCodeResponse.getOutput();
        //获取代码沙箱返回的信息
        JudgeInfo judgeInfo = executeCodeResponse.getJudgeInfo();
        Integer status = executeCodeResponse.getStatus();

        //判题信息默认为正确
        JudgeInfoMessageEnum judgeInfoMessageEnum = JudgeInfoMessageEnum.ACCEPTED;
        //根据判题配置判断
        //要求配置
        JudgeConfig judgeConfig = JSONUtil.toBean(judgeConfigStr, JudgeConfig.class);
        Long memoryLimit = judgeConfig.getMemoryLimit();
        Long timeLimit = judgeConfig.getTimeLimit();
        //实际判题配置
        Long memory = executeCodeResponse.getJudgeInfo().getMemory();
        Long time = executeCodeResponse.getJudgeInfo().getTime();
        if (memory > memoryLimit) {
            // 内存超出限制
            judgeInfoMessageEnum = JudgeInfoMessageEnum.TIME_LIMIT_EXCEEDED;
            judgeInfo.setMessage(judgeInfoMessageEnum.toString());
        }
        if (time > timeLimit) {
            // 时间超出限制
            judgeInfoMessageEnum = JudgeInfoMessageEnum.TIME_LIMIT_EXCEEDED;
            judgeInfo.setMessage(judgeInfoMessageEnum.toString());
        }
        //根据输出和预期输出进行判题
        if (outputList.size() != judgeOutputList.size()) {
            // 输出数量不匹配
            judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
            judgeInfo.setMessage(judgeInfoMessageEnum.toString());
        }
        for (int i = 0; i < judgeOutputList.size(); i++) {
            if (!judgeOutputList.get(i).equals(outputList.get(i))) {
                // 输出不匹配直接返回
                judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
                judgeInfo.setMessage(judgeInfoMessageEnum.toString());
                return null;
            }

        }
        //输出结果和预期输出匹配，则通过
        judgeInfo.setMessage(judgeInfoMessageEnum.toString());
        return judgeInfo;
    }
}
