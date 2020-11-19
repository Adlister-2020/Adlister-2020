package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLAdsDao;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateAdServlet", urlPatterns = "/ad-update")
public class UpdateAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        }
//        Checking if User id and ad user's id matches for editing
        int adId = Integer.parseInt(request.getParameter("addId"));
        Ad adCheckUser = DaoFactory.getAdsDao().getAdById((long) adId);
        User userCheck = (User) request.getSession().getAttribute("user");
        if (adCheckUser.getUserId() != userCheck.getId()) {
            response.sendRedirect("/profile");
        }
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        DaoFactory.getAdsDao().updateAd(adId, title, description);
        response.sendRedirect("/ads/ad?adId=" + adId);

    }
}
