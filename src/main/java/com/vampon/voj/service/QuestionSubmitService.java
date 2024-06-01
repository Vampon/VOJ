package com.vampon.voj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vampon.voj.model.dto.question.QuestionQueryRequest;
import com.vampon.voj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.vampon.voj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.vampon.voj.model.entity.Question;
import com.vampon.voj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vampon.voj.model.entity.User;
import com.vampon.voj.model.vo.QuestionSubmitVO;
import com.vampon.voj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author Fang Hao
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-05-22 15:11:05
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 题目提交（内部服务）
     *
     * @param userId
     * @param questionId
     * @return
     */
    int doQuestionSubmitInner(long userId, long questionId);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);


    /**
     * 获取题目提交封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目提交封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}
