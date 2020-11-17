package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");


        boolean emptyUser = username.isEmpty();
        if(emptyUser){
            request.getSession().setAttribute("registerError", "The username field is empty" ); //error register
            response.sendRedirect("/register");
            return;
        }

        boolean emptyEmail = email.isEmpty();
        if(emptyEmail){
            request.getSession().setAttribute("registerError", "The email field is empty or invalid" ); //error register
            response.sendRedirect("/register");
            return;
        }

        boolean emptyPass = password.isEmpty();
        if(emptyPass){
            request.getSession().setAttribute("registerError", "The password field is empty" ); //error register
            response.sendRedirect("/register");
            return;
        }

        // create and save a new user
        User user = new User(username, email, password);
        request.getSession().setAttribute("user", user);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
