package com.gxy.oj.judge.codesandbox.proxy;

import com.gxy.oj.judge.codesandbox.CodeSandBox;
import com.gxy.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.gxy.oj.judge.codesandbox.model.ExecuteCodeResponse;
import com.gxy.oj.utils.SandboxResponseHandle;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

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
