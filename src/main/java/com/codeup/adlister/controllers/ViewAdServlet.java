package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.util.Jsonify;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewAdServlet", urlPatterns = "/ads/ad")
public class ViewAdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id =  Long.parseLong(request.getParameter("adId"));
        request.setAttribute("ad", DaoFactory.getAdsDao().getAdById(id));
        String jsonStrArray = "[";
        jsonStrArray = jsonStrArray + Jsonify.jsonifyObj(DaoFactory.getAdsDao().getAdById(id)) + "]";
        System.out.println(jsonStrArray);
        request.getRequestDispatcher("/WEB-INF/ads/show_ad.jsp").forward(request, response);
    }
}

