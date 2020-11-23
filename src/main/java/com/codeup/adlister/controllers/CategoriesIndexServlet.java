package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoriesIndexServlet", urlPatterns = "/categories")
public class CategoriesIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory.getCategoriesDao().seedCategoriesDb();
        request.setAttribute("categories", DaoFactory.getCategoriesDao().all());
        request.getSession().setAttribute("categoriesDao", DaoFactory.getCategoriesDao());
        request.getRequestDispatcher("/WEB-INF/ads/showCategories.jsp").forward(request, response);
    }
}
