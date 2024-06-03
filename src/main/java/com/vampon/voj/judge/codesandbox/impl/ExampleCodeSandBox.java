package com.vampon.voj.judge.codesandbox.impl;

import com.vampon.voj.judge.codesandbox.CodeSandBox;
import com.vampon.voj.judge.codesandbox.model.ExecuteCodeRequest;
import com.vampon.voj.judge.codesandbox.model.ExecuteCodeResponse;
import com.vampon.voj.model.dto.questionsubmit.JudgeInfo;
import com.vampon.voj.model.enums.JudgeInfoMessageEnum;
import com.vampon.voj.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * 示例代码沙箱
 */
public class ExampleCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setTime(100L);
        judgeInfo.setMemory(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
