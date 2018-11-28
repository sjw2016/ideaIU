package com.example.demo.url;

import com.example.demo.json.LordJson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ITPK {

    public static String api_key = "api_key";
    public static String api_secret = "api_secret";

    public static String itpk(String path){
        try {
            path = URLEncoder.encode(path, "utf-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String url = "http://i.itpk.cn/api.php?question="+path+"&api_key="+api_key+"&api_secret="+api_secret;
        return LordJson.loadJSON(url);
    }
}
