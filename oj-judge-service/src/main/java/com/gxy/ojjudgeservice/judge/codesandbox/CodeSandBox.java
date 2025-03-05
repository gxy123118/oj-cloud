package com.gxy.ojjudgeservice.judge.codesandbox;

import com.gxy.ojmodel.model.codesandbox.ExecuteCodeRequest;
import com.gxy.ojmodel.model.codesandbox.ExecuteCodeResponse;

public interface CodeSandBox {


    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
