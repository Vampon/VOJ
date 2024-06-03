package com.vampon.voj.judge.codesandbox;

import com.vampon.voj.judge.codesandbox.model.ExecuteCodeRequest;
import com.vampon.voj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 * 如果日后想要换成别的代码沙箱，只需重新实现该接口即可
 */
public interface CodeSandBox {
    /**
     * 执行代码
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
