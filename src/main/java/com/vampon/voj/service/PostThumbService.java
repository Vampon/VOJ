package com.vampon.voj.service;

import com.vampon.voj.model.entity.PostThumb;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vampon.voj.model.entity.User;

/**
 * 帖子点赞服务
 *
 */
public interface PostThumbService extends IService<PostThumb> {

    /**
     * 题目提交信息
     *
     * @param postId
     * @param loginUser
     * @return
     */
    int doPostThumb(long postId, User loginUser);

    /**
     * 题目提交信息（内部服务）
     *
     * @param userId
     * @param postId
     * @return
     */
    int doPostThumbInner(long userId, long postId);
}
