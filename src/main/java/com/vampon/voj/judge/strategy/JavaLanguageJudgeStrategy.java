package com.vampon.voj.judge.strategy;

import cn.hutool.json.JSONUtil;
import com.vampon.voj.model.dto.question.JudgeCase;
import com.vampon.voj.model.dto.question.JudgeConfig;
import com.vampon.voj.model.dto.questionsubmit.JudgeInfo;
import com.vampon.voj.model.entity.Question;
import com.vampon.voj.model.enums.JudgeInfoMessageEnum;

import java.util.List;

/**
 * Java程序判题策略
 */
public class JavaLanguageJudgeStrategy implements JudgeStrategy {
    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        JudgeInfo judgeInfo = judgeContext.getJudgeInfo();
        List<String> inputList = judgeContext.getInputList();
        List<String> outputList = judgeContext.getOutputList();
        List<JudgeCase> judgeCaseList = judgeContext.getJudgeCaseList();
        Question question = judgeContext.getQuestion();
        Long time = judgeInfo.getTime();
        Long memory = judgeInfo.getMemory();

        // 根据执行结果，设置题目的判题状态和信息
        JudgeInfoMessageEnum judgeInfoMessageEnum = JudgeInfoMessageEnum.WAITING;
        JudgeInfo judgeInfoResponse = new JudgeInfo();
        judgeInfoResponse.setTime(memory);
        judgeInfoResponse.setMemory(time);
        if(outputList.size()!= inputList.size()){
            judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        for (int i = 0; i < judgeCaseList.size(); i++) {
            JudgeCase judgeCase = judgeCaseList.get(i);
            if(!judgeCase.getOutput().equals(outputList.get(i))){
                judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
                judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
                return judgeInfoResponse;
            }
        }
        String judgeConfigStr = question.getJudgeConfig();
        JudgeConfig judgeConfig = JSONUtil.toBean(judgeConfigStr, JudgeConfig.class);

        Long expectedTimeLimit = judgeConfig.getTimeLimit();
        Long expectedMemoryLimit = judgeConfig.getMemoryLimit();
        if (memory>expectedMemoryLimit){
            judgeInfoMessageEnum = JudgeInfoMessageEnum.MEMORY_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        // java程序本身需要额外执行10s
        long JAVA_PROGRAM_TIME_COST = 10000L;
        if ((time-JAVA_PROGRAM_TIME_COST)>expectedTimeLimit){
            judgeInfoMessageEnum = JudgeInfoMessageEnum.TIME_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        judgeInfoMessageEnum = JudgeInfoMessageEnum.ACCEPTED;
        judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
        return judgeInfoResponse;

    }
}
