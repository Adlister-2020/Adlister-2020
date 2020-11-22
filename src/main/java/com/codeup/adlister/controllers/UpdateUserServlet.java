package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "UpdateUserServlet", urlPatterns = "/profile/update")
public class UpdateUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/users/update_user.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User current_user = (User) request.getSession().getAttribute("user");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String new_password = request.getParameter("new_password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // request from password reset
        if(request.getSession().getAttribute("recoveryUser") != null){
            if(!new_password.equals(passwordConfirmation)){
                request.getRequestDispatcher("/WEB-INF/sessions/reset_password.jsp").forward(request,response);
            }
            current_user = (User) request.getSession().getAttribute("recoveryUser");
            // update password on database
            current_user.setPassword(new_password);
            DaoFactory.getUsersDao().updateUser(current_user);
            // remove recovery user from session and set as logged in user
            request.getSession().removeAttribute("recoveryUser");
            request.getSession().setAttribute("user", current_user);
            response.sendRedirect("/profile");
            return;
        }

        // request from update user server
        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty()
                || (!new_password.equals(passwordConfirmation));
        if (inputHasErrors) {
            response.sendRedirect("/profile/update");
            return;
        }
        if (!username.equals(current_user.getUsername())){
            current_user.setUsername(username);
        }
        if (!email.equals(current_user.getEmail())){
            current_user.setEmail(email);
        }
        if (!password.isEmpty() && Password.check(password, current_user.getPassword())){
            current_user.setPassword(new_password);
        }else{
            response.sendRedirect("/profile/update");
            return;
        }
        // update and save info
        DaoFactory.getUsersDao().updateUser(current_user);
        request.getSession().setAttribute("user", current_user);
        response.sendRedirect("/profile");
    }
}
