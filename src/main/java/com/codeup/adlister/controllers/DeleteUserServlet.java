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

@WebServlet(name = "DeleteUserServlet",urlPatterns = "/profile/settings")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User current_user = (User) request.getSession().getAttribute("user");
        String endService = request.getParameter("end_service");
        String password = request.getParameter("password");
        // validate input
        boolean inputHasErrors = endService == null
                || password.isEmpty()
                || !Password.check(password, current_user.getPassword());
        if (inputHasErrors) {
            response.sendRedirect("/profile/settings");
            return;
        }

        // update and save info
        DaoFactory.getUsersDao().deleteUser(current_user);
        request.getSession().removeAttribute("user");
        request.getRequestDispatcher("/WEB-INF/users/goodbye.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/users/settings.jsp").forward(request, response);

    }
}
