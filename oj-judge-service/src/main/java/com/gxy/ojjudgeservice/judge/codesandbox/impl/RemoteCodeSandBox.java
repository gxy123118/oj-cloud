package com.gxy.oj.judge.codesandbox.impl;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.gxy.oj.judge.codesandbox.CodeSandBox;
import com.gxy.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.gxy.oj.judge.codesandbox.model.ExecuteCodeResponse;
import com.gxy.oj.model.dto.questionsubmit.JudgeInfo;
import com.gxy.oj.utils.SandboxResponseHandle;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.util.List;
import java.util.ArrayList;

public class RemoteCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {

        String url = "http://192.168.146.128:8090/exec";
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
