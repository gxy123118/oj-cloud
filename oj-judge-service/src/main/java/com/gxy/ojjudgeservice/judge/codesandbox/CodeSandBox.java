package com.gxy.oj.judge.codesandbox;

import com.gxy.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.gxy.oj.judge.codesandbox.model.ExecuteCodeResponse;

public interface CodeSandBox {


    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
