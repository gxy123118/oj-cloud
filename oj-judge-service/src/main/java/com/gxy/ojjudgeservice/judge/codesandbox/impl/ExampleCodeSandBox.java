package com.gxy.oj.judge.codesandbox.impl;

import com.gxy.oj.judge.codesandbox.CodeSandBox;
import com.gxy.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.gxy.oj.judge.codesandbox.model.ExecuteCodeResponse;
import com.gxy.oj.model.dto.questionsubmit.JudgeInfo;

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
