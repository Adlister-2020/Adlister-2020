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
        String categoryTitle = request.getParameter("category-title");
        Long categoryId = Long.parseLong(request.getParameter("category-id"));
        String newCategoryTitle = request.getParameter("new-category-title");
        System.out.println(categoryTitle);
        System.out.println(categoryId);
        if (newCategoryTitle == null) {
            DaoFactory.getCategoriesDao().updateCategory(categoryId, categoryTitle);
        }
        if (categoryId == null || categoryTitle == null) {
            DaoFactory.getCategoriesDao().insertIntoCategories(newCategoryTitle);
        }

        response.sendRedirect("/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute("user");
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
