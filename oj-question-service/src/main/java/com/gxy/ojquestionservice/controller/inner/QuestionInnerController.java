package com.gxy.ojquestionservice.controller.inner;

import com.gxy.ojmodel.model.entity.Question;
import com.gxy.ojmodel.model.entity.QuestionSubmit;
import com.gxy.ojquestionservice.service.QuestionService;
import com.gxy.ojquestionservice.service.QuestionSubmitService;
import com.gxy.ojserviceclient.service.UserFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@RestController
@RequestMapping("/api/question/inner")
public class QuestionInnerController {
    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;
    // region 增删改查

    @GetMapping("/get")
    public Question getById(Long id) {
        return questionService.getById(id);
    }

    @GetMapping("/question_submit/get")
    QuestionSubmit getQuestionSubmitById(Long id) {
        return questionSubmitService.getById(id);
    }
    @PostMapping("/update")
    boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmitUpdate){
        return questionSubmitService.updateById(questionSubmitUpdate);
    }
}
