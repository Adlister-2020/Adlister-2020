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


        boolean hasErrors = username.isEmpty() ||
                email.isEmpty() ||
                password.isEmpty() ||
                !passwordConfirmation.equals(password);



        boolean emptyUser = username.isEmpty();
        if(emptyUser || username == null){
            request.getSession().setAttribute("usernameError", "The username field is empty" ); //error register
        }

        boolean emptyEmail = email.isEmpty();
        if(emptyEmail || email == null){
            request.getSession().setAttribute("emailError", "The email field is empty or invalid" ); //error register
        }

        boolean emptyPass = password.isEmpty();
        if(emptyPass ||password == null){
            request.getSession().setAttribute("passError", "The password field is empty" ); //error register
        }

        if(!password.equals(passwordConfirmation)){
            request.getSession().setAttribute("matchError","Passwords do not match");
        }

        if(hasErrors){
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
