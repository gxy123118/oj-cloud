package com.gxy.ojserviceclient.service;


import com.gxy.ojmodel.model.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "judge-service")
public interface JudgeService {
    QuestionSubmit doJudge(Long id);
}
