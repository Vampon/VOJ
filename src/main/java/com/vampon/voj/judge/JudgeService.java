package com.vampon.voj.judge;


import com.vampon.voj.model.entity.QuestionSubmit;
import com.vampon.voj.model.vo.QuestionSubmitVO;

/**
 * 判题服务
 */
public interface JudgeService {
    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(Long questionSubmitId);

}
