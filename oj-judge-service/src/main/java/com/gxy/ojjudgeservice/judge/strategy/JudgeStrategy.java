package com.gxy.oj.judge.strategy;

import com.gxy.oj.model.dto.questionsubmit.JudgeInfo;

public interface JudgeStrategy {

    JudgeInfo doJudge(JudgeContext judgeContext);
}
