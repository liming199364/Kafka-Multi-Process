package com.lm.kafka.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author:liming
 * @data:2018/11/23
 * @decription
 */
@Data
public class Message {
    private Long id;    //id
    private String msg; //消息
    private Date sendTime;  //时间戳
}
