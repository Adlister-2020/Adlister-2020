package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("categoriesDao", DaoFactory.getCategoriesDao());
        request.getRequestDispatcher("/WEB-INF/users/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
//        String passRecover = request.getParameter("passRecover");
        String passwordConfirmation = request.getParameter("confirm_password");

        //sets the values that I want to take place in each part of the email
        String regEmail = "^[A-Z0-9._-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        //compiles the regex into a pattern that can be used to compare
        Pattern emailPat = Pattern.compile(regEmail, Pattern.CASE_INSENSITIVE);
        //Matcher class matches passed in email with regex pattern
        Matcher matcher = emailPat.matcher(email);
        //boolean that determines if passed in email matches the pattern
        boolean emailMatch = matcher.find();

        //testing for errors
        boolean hasErrors = username.isEmpty() ||
                email.isEmpty() ||
                !emailMatch||
                password.isEmpty() ||
                !passwordConfirmation.equals(password)||
                DaoFactory.getUsersDao().findByUsername(username) != null;

        //handling specific errors
        boolean emptyUser = username.isEmpty();
        if(emptyUser || username == null){
            request.setAttribute("usernameError", "The username field is empty" ); //error register
        }

        boolean emptyEmail = email.isEmpty();
        if(emptyEmail || !emailMatch){
            request.setAttribute("emailError", "The email field is empty or invalid" ); //error register
        }

        boolean emptyPass = password.isEmpty();
        if(emptyPass ||password == null){
            request.setAttribute("passError", "The password field is empty" ); //error register
        }

        if(!password.equals(passwordConfirmation)){
            request.setAttribute("matchError","Passwords do not match");
        }


        if(hasErrors){
            try{
                request.getRequestDispatcher("/WEB-INF/users/register.jsp").forward(request,response);
            }catch (ServletException e){
                e.printStackTrace();
            }
            return;
        }

        // create and save a new user
        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        User dbUser = DaoFactory.getUsersDao().findByUsername(user.getUsername());
        request.getSession().setAttribute("user", dbUser);
        response.sendRedirect("/login");
    }
}
