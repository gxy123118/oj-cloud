package com.gxy.ojserviceclient.service;




import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gxy.ojmodel.model.dto.question.QuestionQueryRequest;
import com.gxy.ojmodel.model.entity.Question;
import com.gxy.ojmodel.model.vo.QuestionVO;
import org.springframework.cloud.openfeign.FeignClient;

import javax.servlet.http.HttpServletRequest;

/**
* @author Baaadman
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2025-01-26 00:04:04
*/
@FeignClient(name = "question-service")
public interface QuestionFeignClient  {

    /**
     * 校验
     *
     * @param question
     * @param add
     */
    void validQuestion(Question question, boolean add);

    /**
     * 获取查询条件
     *
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);


    /**
     * 获取帖子封装
     *
     * @param question
     * @param request
     * @return
     */
    QuestionVO getQuestionVO(Question question, HttpServletRequest request);

    /**
     * 分页获取帖子封装
     *
     * @param questionPage
     * @param request
     * @return
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage, HttpServletRequest request);
}
