package com.gxy.ojserviceclient.service;


import com.gxy.ojmodel.model.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "oj-judge-service",path = "/api/judge/inner")
public interface JudgeClient {
    @GetMapping("/do")
    QuestionSubmit doJudge(@RequestParam("id") Long id);
}
