package com.example.demoWebflux.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @author bo.yang
 */
@TableName("courier_message")
public class Message {
    private static final long serialVersionUID = 1L;

    /**
     * 主题
     */
    private String topic;

    /**
     * 事件类型
     */
    private String event;

    /**
     * 服务ID
     */
    private String serviceId;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createdAt;
}
