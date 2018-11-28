package com.example.demo.pojo;

/**
 * 文本信息类
 * @author Administrator
 *
 */
public class TextMessage extends BaseMessage{

    private String Content;
    private long MsgId;
    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        Content = content;
    }
    public long getMsgId() {
        return MsgId;
    }
    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}