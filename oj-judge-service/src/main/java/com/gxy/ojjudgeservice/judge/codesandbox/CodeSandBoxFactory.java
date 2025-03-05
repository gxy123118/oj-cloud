package com.gxy.ojjudgeservice.judge.codesandbox;

import com.gxy.ojjudgeservice.judge.codesandbox.impl.ExampleCodeSandBox;
import com.gxy.ojjudgeservice.judge.codesandbox.impl.RemoteCodeSandBox;
import com.gxy.ojjudgeservice.judge.codesandbox.impl.ThirdPartyCodeSandBox;


/**
 * 沙箱工厂
 */
public class CodeSandBoxFactory {
    public static CodeSandBox getCodeSandBox(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandBox();
            case "remote":
                return new RemoteCodeSandBox();
            case "thirdParty":
                return new ThirdPartyCodeSandBox();
            default:
                return new ExampleCodeSandBox();
        }
    }
}
