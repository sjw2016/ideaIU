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

@WebServlet(name = "deServlet",urlPatterns = {"/deServlet"})
public class deServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("utf-8");
    PrintWriter out = response.getWriter();

        //删除
        String dname = request.getParameter("dname");
        dname = new String(dname.getBytes("ISO-8859-1"),"UTF-8");
        String sqld = "delete from peoinfo where username=?";
        Object[] objd = {dname};
        Daoimpl d = new Daoimpl();
        int countd = d.zsg(sqld,objd);
        if(countd != 0){
            String a = "{\"named\":\"删除成功\"}";
            Object aa = JSON.toJSON(a);
            out.print(aa);
        }else{
            String b = "{\"named\":\"删除失败\"}";
            Object bb = JSON.toJSON(b);
            out.print(bb);
        }
        out.flush();
        out.close();
    }
}
