package com.example.solrdemo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.example.solrdemo.dao.ProductDao;
import com.example.solrdemo.pojo.Userinfo;
import com.example.solrdemo.service.ProductService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static HttpSolrClient httpSolrClient;
    @Autowired
    private ProductDao productDao;

    private static String baseUrl = "http://localhost:8983/solr/collection";

    static{
        httpSolrClient = new HttpSolrClient.Builder(baseUrl)
                .withConnectionTimeout(3000)
                .withSocketTimeout(5000)
                .build();
    }

    public String add(){
        //创建一个文档对象
        SolrInputDocument document = new SolrInputDocument();
        document.addField("username","红米note7");
        document.addField("password","骁龙710 4000毫安大电池");
        document.addField("address","红米");
        document.addField("wage","1499");
        document.addField("state",1000);
        document.addField("createTime",System.currentTimeMillis());
        try {
            httpSolrClient.add(document);
            httpSolrClient.commit();
            return "success";
        } catch (SolrServerException e) {
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }


    public String selDocumentList(String text, Integer index, Integer rows) {
        //按关键字查询
        SolrQuery solrQuery = new SolrQuery("keyword:"+text);
        //查询结果分页
        solrQuery.setStart((index-1)*rows);
        solrQuery.setRows(rows);
        //按价格从高到低
        solrQuery.setSort("price", SolrQuery.ORDER.asc);
        // 设置高亮
        solrQuery.setHighlight(true); // 开启高亮组件
        solrQuery.addHighlightField("keyword");// 高亮字段
        solrQuery.setHighlightSimplePre("<font color='red'>");// 标记，高亮关键字前缀
        solrQuery.setHighlightSimplePost("</font>");// 后缀

        QueryResponse response = null;
        SolrDocumentList results = null;
        try {
            //获得从solr服务器返回的响应
            response = httpSolrClient.query(solrQuery);
            //从响应中拿出结果集
            results = response.getResults();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(results);
    }


    public String delete(String id) {
        try {
            httpSolrClient.deleteById(id);
            httpSolrClient.commit();
            return "success";
        } catch (SolrServerException e) {
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }

    @Scheduled(cron = "${task.cron.tradeData}")
    public void dataImport() {
        System.out.println("123456。。。");
        List<Userinfo> productList = productDao.selAll();
        for (Userinfo p: productList) {
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id",p.getId());
            document.addField("username",p.getUsername());
            document.addField("password",p.getPassword());
            document.addField("address",p.getAddress());
            document.addField("wage",p.getWage());
            document.addField("state",p.getState());
            document.addField("createTime",System.currentTimeMillis());
            try {
                httpSolrClient.add(document);
            } catch (SolrServerException e) {
                e.printStackTrace();
                //return "failed";
            } catch (IOException e) {
                e.printStackTrace();
                //return "failed";
            }
        }
        try {
            httpSolrClient.commit();
            //return "success";
        } catch (SolrServerException e) {
            e.printStackTrace();
            //return "failed";
        } catch (IOException e) {
            e.printStackTrace();
            //return "failed";
        }
    }
}
