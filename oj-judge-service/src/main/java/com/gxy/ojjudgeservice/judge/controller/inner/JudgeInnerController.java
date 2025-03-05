package com.gxy.ojjudgeservice.judge.controller.inner;

import com.gxy.ojjudgeservice.judge.JudgeService;
import com.gxy.ojmodel.model.entity.QuestionSubmit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/judge/inner")
public class JudgeInnerController {
    @Resource
    private JudgeService judgeService;

    @GetMapping("/do")
    public QuestionSubmit doJudge(Long id) {
        return judgeService.doJudge(id);
    }
}
