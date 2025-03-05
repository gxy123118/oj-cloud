package com.gxy.ojjudgeservice.judge.strategy;

import com.gxy.ojmodel.model.dto.questionsubmit.JudgeInfo;

public interface JudgeStrategy {

    JudgeInfo doJudge(JudgeContext judgeContext);
}
