package com.gxy.ojjudgeservice.judge.codesandbox.proxy;


import com.gxy.ojjudgeservice.judge.codesandbox.CodeSandBox;
import com.gxy.ojjudgeservice.judge.codesandbox.util.SandboxResponseHandle;
import com.gxy.ojmodel.model.codesandbox.ExecuteCodeRequest;
import com.gxy.ojmodel.model.codesandbox.ExecuteCodeResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CodeSandBoxProxy implements CodeSandBox {

    private CodeSandBox codeSandBox;

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("代码沙箱代理");
        //对代码沙箱返回的数据进行代理
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        ExecuteCodeResponse response = SandboxResponseHandle.handle(executeCodeResponse);

        return response;
    }
}
