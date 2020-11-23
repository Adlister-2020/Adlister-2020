package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.IdTokenVerifierAndParser;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "OauthServlet",urlPatterns = "/oauth")
public class OauthServlet extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        try {
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payload = IdTokenVerifierAndParser.getPayload(idToken);
            String email = payload.getEmail();
            boolean emailVerified = payload.getEmailVerified();
            String name = (String) payload.get("name");
            String pictureUrl = (String) payload.get("picture");
            String locale = (String) payload.get("locale");
            String familyName = (String) payload.get("family_name");
            String givenName = (String) payload.get("given_name");
            // Use or store profile information
            User newUser = new User(name,email,"password");
            newUser.setAvatar(pictureUrl);
            User dbUser = DaoFactory.getUsersDao().findByUsername(name);
//           if user not id db register the user
            if(dbUser == null){
                DaoFactory.getUsersDao().insert(newUser);
            }
            req.getSession().setAttribute("user",DaoFactory.getUsersDao().findByUsername(name));
            HttpSession session = req.getSession(true);
            resp.sendRedirect("/profile");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
