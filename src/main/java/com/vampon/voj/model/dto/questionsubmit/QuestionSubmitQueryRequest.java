package com.vampon.voj.model.dto.questionsubmit;

import com.vampon.voj.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询请求
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {


    /**
     * 题目 id
     */
    private Long questionId;

    /**
     * 编程语言
     */
    private String codeLanguage;

    /**
     * 提交状态
     */
    private Integer status;

    /**
     * 用户id
     */
    private Integer userId;


    private static final long serialVersionUID = 1L;
}