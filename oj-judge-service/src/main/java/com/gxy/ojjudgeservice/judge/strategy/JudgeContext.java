package com.gxy.ojjudgeservice.judge.strategy;


import com.gxy.ojmodel.model.entity.Question;
import com.gxy.ojmodel.model.entity.QuestionSubmit;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JudgeContext {
    private Question question;
    private QuestionSubmit questionSubmit;

}
