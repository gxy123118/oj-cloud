package com.gxy.ojjudgeservice.judge;


import com.gxy.ojmodel.model.entity.QuestionSubmit;

public interface JudgeService {
    QuestionSubmit doJudge(Long id);
}
