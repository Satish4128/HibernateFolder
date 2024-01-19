package com.hibernate.servlets;

import com.hibernate.action.LoginAction;
import com.hibernate.beans.User;
import com.hibernate.util.HibernateUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.hibernate.Factory.LoginActionFactory;

import java.io.IOException;

@WebServlet(urlPatterns={"/login"},loadOnStartup =1)
public class LoginServlet extends HttpServlet {

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        String upwd=request.getParameter("upwd");
        User user=new User();
        user.setUname(uname);
        user.setUpwd(upwd);
        LoginAction loginAction=LoginActionFactory.getLoginAction();
        String status=loginAction.ckeckLogin(user);
        RequestDispatcher requestDispatcher=null;
        if(status.equals("success"))
        {
            requestDispatcher=request.getRequestDispatcher("success.html");
            requestDispatcher.forward(request,response);
        }
        else {
            requestDispatcher=request.getRequestDispatcher("failure.html");
            requestDispatcher.forward(request,response);
        }


    }
}
