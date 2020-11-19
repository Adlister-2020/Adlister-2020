package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteAdsServlet", urlPatterns = "/ad-delete")
public class DeleteAdsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null){
            response.sendRedirect("/login");
            return;
        }

        int adId = Integer.parseInt(request.getParameter("delete"));
        Ad adCheckUser = DaoFactory.getAdsDao().getAdById((long) adId);
        User userCheck = (User) request.getSession().getAttribute("user");
        if (adCheckUser.getUserId() != userCheck.getId()) {
            response.sendRedirect("/profile");
            return;
        }
        DaoFactory.getAdsDao().destroyAd(adId);
        response.sendRedirect("/ads");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
