package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }

        System.out.println("page has loaded");
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username2 = request.getParameter("username2");
        String password2 = request.getParameter("password2");

//
//
//        if (user == null){
//            response.sendRedirect("/login");
//            return;
//        }


        //testing for errors
        boolean hasErrors = username2.isEmpty() ||
                DaoFactory.getUsersDao().findByUsername(username2) == null;


        //tests for specific errors
        User user = DaoFactory.getUsersDao().findByUsername(username2);
        if(DaoFactory.getUsersDao().findByUsername(username2) == null){
            request.setAttribute("loginError", "username is false");
            System.out.println("username did not match");
        }


        if(user != null){
             hasErrors = !Password.check(password2, user.getPassword());
            if(!Password.check(password2, user.getPassword())){
                request.setAttribute("loginError", "password is does not match");
                System.out.println("password did not match");
            }
        }


//page direction for if errors are found
        System.out.println(hasErrors);
        if (hasErrors) {
            try{
                System.out.println("There was an error");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
            }catch (ServletException e){
                e.printStackTrace();
            }
        }else {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        }


    }
}

//  ****** ad to code after tc has pushed *******
//        request.getSession().setAttribute("user", user);
//        if(request.getSession().getAttribute("callbackUrl")!=null){
//        response.sendRedirect((String) request.getSession().getAttribute("callbackUrl"));
//        }
//        response.sendRedirect("/profile");
