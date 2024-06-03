package com.vampon.voj.judge.codesandbox.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExecuteCodeRequest {
    /**
     * 输入用例
     */
    private List<String> inputList;

    /**
     * 用户提交代码
     */
    private String code;

    /**
     * 用户代码编程语言类型
     */
    private String language;
}
