package com.gxy.ojjudgeservice.judge.codesandbox.impl;


import com.gxy.ojjudgeservice.judge.codesandbox.CodeSandBox;
import com.gxy.ojmodel.model.codesandbox.ExecuteCodeRequest;
import com.gxy.ojmodel.model.codesandbox.ExecuteCodeResponse;
import com.gxy.ojmodel.model.dto.questionsubmit.JudgeInfo;

import java.util.ArrayList;

public class ThirdPartyCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return new ExecuteCodeResponse(
                new ArrayList<>(),
                0,
                "编译成功",
                new JudgeInfo(10L, 10L, "")
        );
    }
}
