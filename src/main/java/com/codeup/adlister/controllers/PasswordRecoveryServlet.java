package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Email;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PasswordRecoveryServlet",urlPatterns = "/user/recovery")
public class PasswordRecoveryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // assign post parameters
        String username = request.getParameter("recovery-user");
        String resetInput = request.getParameter("reset-password");
        boolean hasUsername = !username.isEmpty() && username != null;
        boolean wantsReset = resetInput != null && resetInput.equalsIgnoreCase("1");

        if(!hasUsername || !wantsReset){
            response.sendRedirect("/user/recovery");
            return;
        }
        // get the recovery user from db
        User recoveryUser = DaoFactory.getUsersDao().findByUsername(username);
        System.out.println();
        boolean userExists = recoveryUser != null;
        // if user in db try to email password recovery link
        if(userExists){
            long num = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
            String randomNum = ""+num;
            // create attribute to use in getrequest from user email
            request.getSession().setAttribute(randomNum,username);
            try {
                String email = recoveryUser.getEmail();
                Email.generateAndSendEmail(email,randomNum);
                response.sendRedirect("/login");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("user not found");
            response.sendRedirect("/user/recovery");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // assign params
        String recoveryId = request.getParameter("recoveryid");
        boolean hasRecoveryId = recoveryId != null;
        // if recovery id from email in sessions attributes is not null send user to password reset form
        if(hasRecoveryId && request.getSession().getAttribute(recoveryId) != null){
            User recoveryUser = DaoFactory.getUsersDao().findByUsername((String)request.getSession().getAttribute(recoveryId));
            // set recoveryUser in sessions
            request.getSession().setAttribute("recoveryUser",recoveryUser);
            request.getRequestDispatcher("/WEB-INF/sessions/reset_password.jsp").forward(request,response);
            return;
        }
        request.getRequestDispatcher("/WEB-INF/sessions/password_recover.jsp").forward(request,response);
    }
}