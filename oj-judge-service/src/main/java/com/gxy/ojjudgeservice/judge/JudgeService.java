package com.gxy.oj.judge;

import com.gxy.oj.model.dto.questionsubmit.JudgeInfo;
import com.gxy.oj.model.entity.QuestionSubmit;
import com.gxy.oj.model.vo.QuestionSubmitVO;

public interface JudgeService {
    QuestionSubmit doJudge(Long id);
}
