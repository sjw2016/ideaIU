package com.example.solrdemo.service;

public interface ProductService {

    /**
     * 添加一个document文档
     * @return
     */
    String add();

    /**
     * 按关键字查询decument
     * @param text 要查询的关键字
     * @param index 页码
     * @param rows 每页显示几条数据
     * @return
     */
    String selDocumentList(String text, Integer index, Integer rows);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    String delete(String id);

    /**
     * 定是全量数据导入
     * @return
     */
    //String dataImport();

}
