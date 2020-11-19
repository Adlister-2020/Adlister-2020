package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLAdsDao;
import com.codeup.adlister.models.Ad;

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
        long addId = Long.parseLong(request.getParameter("addId"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        System.out.println(addId);
        Ad ad = new Ad(addId, title, description);
        System.out.println(ad.getId());
        System.out.println(ad.getTitle());
        System.out.println(ad.getDescription());
        DaoFactory.getAdsDao().updateAd(ad);
        response.sendRedirect("/ads/ad?adId=" + addId);

    }
}
