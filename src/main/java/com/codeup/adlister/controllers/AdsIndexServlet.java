package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        String cat = request.getParameter("category");
        request.getSession().setAttribute("categoriesDao", DaoFactory.getCategoriesDao());
        request.setAttribute("categoriesDao", DaoFactory.getCategoriesDao());

        boolean hasCategory = cat != null && !cat.equals("");
        boolean hasSearchTerm = search != null && !search.equals("");

        if(!hasCategory && !hasSearchTerm) {
            request.setAttribute("ads", DaoFactory.getAdsDao().all());
            request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
        }
        if (hasSearchTerm) {
            request.setAttribute("ads", DaoFactory.getAdsDao().getAdsBySearch(search));
            request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
        }

        if (hasCategory) {
            Category category = DaoFactory.getCategoriesDao().getCategoryByTitle(cat);
            request.setAttribute("category", category);
            request.setAttribute("ads", DaoFactory.getAdsDao().allAdsByCategory(category));
            request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
        }
        if (hasSearchTerm && hasCategory) {
            Category category = DaoFactory.getCategoriesDao().getCategoryByTitle(cat);
            request.setAttribute("category", category);
            request.setAttribute("ads", DaoFactory.getAdsDao().getAdsBySearchAndCategory(search, category));
            request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
        }

    }

}
