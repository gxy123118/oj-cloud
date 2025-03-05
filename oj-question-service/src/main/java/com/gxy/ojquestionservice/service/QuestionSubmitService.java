package com.gxy.ojquestionservice.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gxy.ojmodel.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.gxy.ojmodel.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.gxy.ojmodel.model.entity.QuestionSubmit;
import com.gxy.ojmodel.model.entity.User;
import com.gxy.ojmodel.model.vo.QuestionSubmitVO;

/**
* @author Baaadman
* @description 针对表【question_submit(题目提交表)】的数据库操作Service
* @createDate 2025-01-26 00:05:54
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    Long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    Page<QuestionSubmitVO> getQuestionVOPage(Page<QuestionSubmit> page, User loginUser);
}
