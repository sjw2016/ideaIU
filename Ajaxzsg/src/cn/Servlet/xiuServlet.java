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

@WebServlet(name = "xiuServlet",urlPatterns = {"/xiuServlet"})
public class xiuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String oldname = request.getParameter("xoldname");
        String newname = request.getParameter("xnewname");
        oldname = new String(oldname.getBytes("iso-8859-1"),"utf-8");
        newname = new String(newname.getBytes("iso-8859-1"),"utf-8");
        String sql = "update peoinfo set username=?where username =?";
        String[] obj = {newname,oldname};
        Daoimpl d = new Daoimpl();
        int count = d.zsg(sql,obj);
        if(count != 0){
            String a = "{\"namex\":\"修改成功\"}";
            Object aa = JSON.toJSON(a);
            out.print(aa);
        }else{
            String a = "{\"namex\":\"修改失败\"}";
            Object aa = JSON.toJSON(a);
            out.print(aa);
        }
        out.flush();
        out.close();
    }
}
