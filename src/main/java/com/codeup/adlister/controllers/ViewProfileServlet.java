package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.ListAdsDao;
import com.codeup.adlister.dao.MySQLAdsDao;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser  = (User) request.getSession().getAttribute("user");
        User profileOwner = null;
        // redirect unregistered users to login
        if (request.getSession().getAttribute("user") == null) {
//            String callbackUrl = request.getRequestURI();
//            if(!request.getQueryString().isEmpty() || request.getQueryString()!=null){
//                callbackUrl += "?"+request.getQueryString();
//            }
//            request.getSession().setAttribute("callbackUrl",callbackUrl);
            response.sendRedirect("/login");
            return;
        }
        // if ad userId parameter set profile owner to author else profile owner is the logged in user
        if (request.getParameter("author") != null ){
           profileOwner = DaoFactory.getUsersDao().findByUserId(Long.parseLong(request.getParameter("author")));
           if(profileOwner == null ){
               response.sendRedirect("/profile");
               return;
           }
        }
        if(profileOwner == null){
            profileOwner = currentUser;
        }
        
        request.setAttribute("profileOwner",profileOwner);
        request.setAttribute("ads", DaoFactory.getAdsDao().userAds( profileOwner.getId()));
        request.getRequestDispatcher("/WEB-INF/users/profile.jsp").forward(request, response);
    }

}
