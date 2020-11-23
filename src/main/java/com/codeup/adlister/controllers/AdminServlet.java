package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String table = request.getParameter("table");
//        if (table != null && !table.equals("")) {
//            
//        }

        User currentUser  = (User) request.getSession().getAttribute("user");
        // redirect unregistered and unauthorized users to login
        if (request.getSession().getAttribute("user") == null || currentUser.getRole().equals("member")) {
            response.sendRedirect("/login");
            return;
        }

        request.setAttribute("users", DaoFactory.getUsersDao().all());
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.setAttribute("categories", DaoFactory.getCategoriesDao().all());
        request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
    }
}
