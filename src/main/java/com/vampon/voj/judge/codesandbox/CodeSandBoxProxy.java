package com.vampon.voj.judge.codesandbox;

import com.vampon.voj.judge.codesandbox.model.ExecuteCodeRequest;
import com.vampon.voj.judge.codesandbox.model.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * 静态代理
 * 将日志功能抽象出来
 */
@Slf4j
public class CodeSandBoxProxy implements com.vampon.voj.judge.codesandbox.CodeSandBox {

    private final com.vampon.voj.judge.codesandbox.CodeSandBox codeSandBox;

    public CodeSandBoxProxy(com.vampon.voj.judge.codesandbox.CodeSandBox codeSandBox) {
        this.codeSandBox = codeSandBox;
    }

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代码沙箱请求信息：" + executeCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        log.info("代码沙箱响应信息：" + executeCodeResponse.toString());
        return executeCodeResponse;
    }
}
