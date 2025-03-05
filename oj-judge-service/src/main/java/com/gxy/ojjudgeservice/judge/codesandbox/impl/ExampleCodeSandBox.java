package com.gxy.ojjudgeservice.judge.codesandbox.impl;



import com.gxy.ojjudgeservice.judge.codesandbox.CodeSandBox;
import com.gxy.ojmodel.model.codesandbox.ExecuteCodeRequest;
import com.gxy.ojmodel.model.codesandbox.ExecuteCodeResponse;
import com.gxy.ojmodel.model.dto.questionsubmit.JudgeInfo;

import java.util.ArrayList;
import java.util.List;

public class ExampleCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> op = new ArrayList<>();
        op.add("111");
        System.out.println("这是模板沙箱");
        return new ExecuteCodeResponse(
                op,
                0,
                "编译成功",
                new JudgeInfo(10L, 10L, "")
        );
    }
}
