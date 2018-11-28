package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.url.ITPK;
import com.example.demo.util.MessageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class doPost {
    @SuppressWarnings("rawtypes")
    //@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        try {
            Map<String, String> map = MessageUtil.xmlToMap(req);
            String toUserName = map.get("ToUserName");
            String fromUserName = map.get("FromUserName");
            String msgType = map.get("MsgType");
            String content = map.get("Content");
            System.out.println(toUserName+fromUserName+msgType+content);
            String text = null;
            if ("text".equals(msgType)) {
                switch (content) {
                    case "笑话":
                        Map maps1 = (Map) JSON.parse(ITPK.itpk("笑话"));
                        StringBuffer sb1 = new StringBuffer();
                        sb1.append("标题："+maps1.get("title")+"\n");
                        sb1.append("内容："+maps1.get("content"));
                        text = MessageUtil.replyByKeyWord(toUserName, fromUserName, MessageUtil.Message_Text, sb1.toString());
                        break;
                    case "观音灵签":
                        Map maps2 = (Map)JSON.parse(ITPK.itpk("观音灵签"));
                        StringBuffer sb2 = new StringBuffer();
                        sb2.append("您抽取的是第"+maps2.get("number2")+"签\n");
                        sb2.append("签位："+maps2.get("haohua")+"\n");
                        sb2.append("签语："+maps2.get("qianyu")+"\n");
                        sb2.append("诗意："+maps2.get("shiyi")+"\n");
                        sb2.append("解签："+maps2.get("jieqian"));
                        text = MessageUtil.replyByKeyWord(toUserName, fromUserName, MessageUtil.Message_Text, sb2.toString());
                        break;
                    case "月老灵签":
                        Map maps3 = (Map)JSON.parse(ITPK.itpk("月老灵签"));
                        StringBuffer sb3 = new StringBuffer();
                        sb3.append("您抽取的是第"+maps3.get("number2")+"签\n");
                        sb3.append("签位："+maps3.get("haohua")+"\n");
                        sb3.append("签语："+maps3.get("shiyi")+"\n");
                        sb3.append("解签："+maps3.get("jieqian"));
                        text = MessageUtil.replyByKeyWord(toUserName, fromUserName, MessageUtil.Message_Text, sb3.toString());
                        break;
                    case "财神爷灵签":
                        Map maps4 = (Map)JSON.parse(ITPK.itpk("财神爷灵签"));
                        StringBuffer sb4 = new StringBuffer();

                        sb4.append("您抽取的是第"+maps4.get("number2")+"签\n");
                        sb4.append("签语："+maps4.get("qianyu")+"\n");
                        sb4.append("注释："+maps4.get("zhushi")+"\n");
                        sb4.append("解签："+maps4.get("jieqian")+"\n");
                        sb4.append("解说："+maps4.get("jieshuo")+"\n");
                        sb4.append("婚姻："+maps4.get("hunyin")+"\n");
                        sb4.append("事业："+maps4.get("shiye")+"\n");
                        sb4.append("求财："+maps4.get("qiucai"));
                        text = MessageUtil.replyByKeyWord(toUserName, fromUserName, MessageUtil.Message_Text, sb4.toString());
                        break;
                    case "指令":
                        text = MessageUtil.replyByKeyWord(toUserName, fromUserName, MessageUtil.Message_Text, MessageUtil.mainMenu());
                        break;
                    default:
                        text = MessageUtil.replyByKeyWord(toUserName, fromUserName, MessageUtil.Message_Text, ITPK.itpk(content));
                        break;
                }
            }else if (MessageUtil.Message_Event.equals(msgType)) {
                if ("subscribe".equals(map.get("Event"))) {
                    text = MessageUtil.replyByKeyWord(toUserName, fromUserName, MessageUtil.Message_Text, MessageUtil.mainMenu());
                }
            }
            System.out.println(text);
            writer.print(text);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

}
