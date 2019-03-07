package com.pjb.springbootpublicremark.dao;

import java.util.List;

import com.pjb.springbootpublicremark.bean.Comment;
import org.springframework.stereotype.Component;

@Component
public interface CommentDao {
	/**
     *  根据查询条件分页查询评论列表
     * @param comment 查询条件
     * @return 评论列表
     */
    List<Comment> selectByPage(Comment comment);
    
    /**
     * 新增
     * @param comment 评论对象
     * @return 影响行数
     */
    int insert(Comment comment);

    /**
     *  根据查询条件分页查询评论列表
     * @param comment 查询条件
     * @return 评论列表
     */
    List<Comment> selectByAdminPage(Comment comment);
}