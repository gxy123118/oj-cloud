package com.gxy.ojjudgeservice.judge.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.gxy.ojjudgeservice.judge.codesandbox.CodeSandBox;
import com.gxy.ojjudgeservice.judge.codesandbox.util.SandboxResponseHandle;
import com.gxy.ojmodel.model.codesandbox.ExecuteCodeRequest;
import com.gxy.ojmodel.model.codesandbox.ExecuteCodeResponse;


public class RemoteCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {

        String url = "http://codesandbox/exec";
        //拿到响应数据
        String body = HttpUtil.createPost(url)
                .body(JSONUtil.toJsonStr(executeCodeRequest))
                .timeout(10000)
                .execute()
                .body();
        ExecuteCodeResponse executeCodeResponse = JSONUtil.toBean(body, ExecuteCodeResponse.class);
        ExecuteCodeResponse response = SandboxResponseHandle.handle(executeCodeResponse);
        return response;

    }
}
