package com.example.demo.util;

import com.example.demo.pojo.TextMessage;

import javax.lang.model.element.Element;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.Document;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageUtil {
    public static String Message_Text = "text";
    public static String Message_News = "news";
    public static String Message_Image = "image";
    public static String Message_Voice = "voice";
    public static String Message_Video = "video";
    public static String Message_ShortVideo = "shortvideo";
    public static String Message_Location = "location";
    public static String Message_Link = "link";
    public static String Message_Event= "event";
    public static String Message_Event_Sub= "subscribe";

    /**
     * xml转map集合
     * @param request
     * @return
     * @throws IOException
     * @throws Exception
     */

    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, Exception{
        Map<String, String> map = new HashMap<String,String>();

        SAXReader reader = new SAXReader();

        InputStream is = request.getInputStream();

        Document document = reader.read(is);

        Element root = document.getRootElement();

        List<Element> list = root.elements();

        for (Element e:list) {
            map.put(e.getName(), e.getText());
        }
        is.close();
        return map;
    }

    /**
     * 将文本消息转换成xml
     * @param textMessage
     * @return
     */
    public static String textMessageToXml(TextMessage textMessage){
        XStream xStream = new XStream();
        xStream.alias("xml", textMessage.getClass());
        return xStream.toXML(textMessage);
    }

    /**
     * 将图片信息转换成xml
     * @param imageMessage
     * @return
     */
    public static String imageMessageToXml(ImageMessage imageMessage){
        XStream xStream = new XStream();
        xStream.alias("xml", imageMessage.getClass());
        return xStream.toXML(imageMessage);
    }

    /**
     *将图文消息转换成xml
     * @param newsMessage
     * @return
     */
    public static String newsMessageToXml(NewsMessage newsMessage){
        XStream xStream = new XStream();
        xStream.alias("xml", newsMessage.getClass());
        xStream.alias("item", new News().getClass());
        return xStream.toXML(newsMessage);
    }

    public static String repluByImage(String toUserName,String fromUserName,String msgType,String mediaId){
        ImageMessage imageMessage = new ImageMessage();
        imageMessage.setToUserName(fromUserName);
        imageMessage.setFromUserName(toUserName);
        imageMessage.setCreateTime(new Date().getTime());
        Image image = new Image();
        image.setMediaId(mediaId);
        imageMessage.setImage(image);
        return MessageUtil.imageMessageToXml(imageMessage);
    }

    /**
     * 文本回复
     * @param toUserName
     * @param fromUserName
     * @param msgType
     * @param content
     * @return
     */
    public static String replyByKeyWord(String toUserName,String fromUserName,String msgType,String content){
        TextMessage message = new TextMessage();
        message.setFromUserName(toUserName);
        message.setToUserName(fromUserName);
        message.setMsgType(msgType);
        message.setCreateTime(new Date().getTime());
        message.setContent(content);
        return MessageUtil.textMessageToXml(message);
    }
    public static String mainMenu(){
        StringBuffer sb = new StringBuffer();
        sb.append("指令:\n");
        sb.append("地区天气 \n");
        sb.append("天气\n");
        sb.append("@tq您的ip地址\n");
        sb.append("@ip您的ip地址\n");
        sb.append("ip\n");
        sb.append("@qq要查询的QQ号码\n");
        sb.append("@lol英雄联盟大区--角色名称\n");
        sb.append("@sfz身份证号码\n");
        sb.append("@sjh手机号码\n");
        sb.append("@cy四字成语\n");
        sb.append("笑话\n");
        sb.append("观音灵签\n");
        sb.append("月老灵签\n");
        sb.append("财神爷灵签");
        return sb.toString();
    }
}
