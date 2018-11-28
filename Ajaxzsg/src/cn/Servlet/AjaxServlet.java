package cn.Servlet;

import cn.dao.impl.Daoimpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AjaxServlet",urlPatterns = {"/AjaxServlet"})
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //增加
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
        password = new String(password.getBytes("ISO-8859-1"),"UTF-8");
        Object[] obj = {name,password};
        String sql = "insert into peoinfo VALUES(0,?,?)";
        Daoimpl d = new Daoimpl();
        int count = d.zsg(sql,obj);
        if(count != 0){
            String aa = "{\"name\":\"新增成功\"}";
          //out.print("新增成功");
            Object aaa = JSON.toJSON(aa);
            out.print(aaa);
        }else {
            Map<String,String> m = new HashMap<String,String>();
            m.put("name","新增失败");
            //out.print("新增失败");
            Object mm = JSON.toJSON(m);
            out.print(mm);
        }

        out.flush();
        out.close();
    }
}
