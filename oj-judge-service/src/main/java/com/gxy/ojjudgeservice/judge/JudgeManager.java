package com.gxy.ojjudgeservice.judge;


import com.gxy.ojjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.gxy.ojjudgeservice.judge.strategy.JavaJudgeStrategy;
import com.gxy.ojjudgeservice.judge.strategy.JudgeContext;
import com.gxy.ojmodel.model.dto.questionsubmit.JudgeInfo;
import com.gxy.ojmodel.model.entity.QuestionSubmit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
