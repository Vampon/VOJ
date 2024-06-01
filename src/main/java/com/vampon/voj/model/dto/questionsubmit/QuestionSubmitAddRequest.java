package com.vampon.voj.model.dto.questionsubmit;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创建请求
 *
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {


    /**
     * 题目 id
     */
    private Long questionId;


    /**
     * 编程语言
     */
    private String codeLanguage;

    /**
     * 用户代码
     */
    private String code;


    private static final long serialVersionUID = 1L;
}