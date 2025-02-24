package com.gxy.oj.judge.strategy;

import com.gxy.oj.model.entity.Question;
import com.gxy.oj.model.entity.QuestionSubmit;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class JudgeContext {
    private Question question;
    private QuestionSubmit questionSubmit;

}
