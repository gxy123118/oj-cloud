package com.gxy.oj.judge.codesandbox.impl;

import com.gxy.oj.judge.codesandbox.CodeSandBox;
import com.gxy.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.gxy.oj.judge.codesandbox.model.ExecuteCodeResponse;
import com.gxy.oj.model.dto.questionsubmit.JudgeInfo;

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
