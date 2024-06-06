package com.vampon.voj.judge;

import com.vampon.voj.judge.strategy.DefaultJudgeStrategy;
import com.vampon.voj.judge.strategy.JavaLanguageJudgeStrategy;
import com.vampon.voj.judge.strategy.JudgeContext;
import com.vampon.voj.judge.strategy.JudgeStrategy;
import com.vampon.voj.model.dto.questionsubmit.JudgeInfo;
import com.vampon.voj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {
    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String codeLanguage = questionSubmit.getCodeLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(codeLanguage)){
           judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
