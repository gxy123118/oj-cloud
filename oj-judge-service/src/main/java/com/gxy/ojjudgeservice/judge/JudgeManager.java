package com.gxy.oj.judge;

import com.gxy.oj.judge.strategy.DefaultJudgeStrategy;
import com.gxy.oj.judge.strategy.JavaJudgeStrategy;
import com.gxy.oj.judge.strategy.JudgeContext;
import com.gxy.oj.model.dto.questionsubmit.JudgeInfo;
import com.gxy.oj.model.entity.QuestionSubmit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JudgeManager {
    @Autowired
    private DefaultJudgeStrategy defaultJudgeStrategy;
    @Autowired
    private JavaJudgeStrategy javaJudgeStrategy;


    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        if (language.equals("java")) {
            return javaJudgeStrategy.doJudge(judgeContext);
        }
        return defaultJudgeStrategy.doJudge(judgeContext);
    }

}
