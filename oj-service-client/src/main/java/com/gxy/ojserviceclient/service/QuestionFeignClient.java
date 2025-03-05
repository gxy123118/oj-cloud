package com.gxy.ojserviceclient.service;




import com.gxy.ojmodel.model.entity.Question;
import com.gxy.ojmodel.model.entity.QuestionSubmit;
import com.gxy.ojmodel.model.vo.QuestionVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
* @author Baaadman
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2025-01-26 00:04:04
*/
@FeignClient(name = "oj-question-service",path = "/api/question/inner")
public interface QuestionFeignClient  {

    @GetMapping("/get")
    Question getById(@RequestParam("id") Long questionId);


    @PostMapping("/update")
   boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmitUpdate);

    @GetMapping("/question_submit/get")
    QuestionSubmit getQuestionSubmitById(@RequestParam("id") Long id);
}
