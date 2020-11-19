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

        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("password");
        request.getSession().removeAttribute("confirm_password");
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password2 = request.getParameter("password2");
        User user = DaoFactory.getUsersDao().findByUsername(username);



        if (user == null){
            response.sendRedirect("/login");
            return;
        }

        boolean hasErrors =
                username.isEmpty() ||
                DaoFactory.getUsersDao().findByUsername(username) == null ||
                !Password.check(password2, user.getPassword());

        //tests for specific errors
        if(username.isEmpty()){
            request.getSession().setAttribute("userError", "username is blank");
        }

        if(DaoFactory.getUsersDao().findByUsername(username) == null){
            request.getSession().setAttribute("matchError", "username is false");
        }

        if(!Password.check(password2, user.getPassword()) || password2 == null){
            request.getSession().setAttribute("passError", "password is does not match");
        }


        if (!hasErrors) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
