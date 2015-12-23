/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgr.security;

import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.*;
import javax.faces.event.ActionEvent;
import javax.faces.application.FacesMessage;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.ServletContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped
public class AuthenticationController {
    public String login() {
        log( "AuthenticationController.login: logging - in." );
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        HttpSession session = request.getSession(false);
        java.net.URI referer = java.net.URI.create(request.getHeader("referer"));
        String urlPath = referer.getPath();
        urlPath = urlPath.replaceFirst(context.getExternalContext().getRequestContextPath(), "");
        
        try {
            
            String username = getParameter(request, "j_username");
            String password = getParameter(request, "j_password");
            request.login(username, password);
            
            if( session != null )
                log( "AuthenticationController.login: After request.login " + session.getId() );
       // }catch(IOException ex){ 
            // Handle unknown username/password in request.login().   
         //   context.addMessage(null, new FacesMessage("Unknown Path"));     
        } catch (ServletException ex) {
            // Handle unknown username/password in request.login().   
            context.addMessage(null, new FacesMessage("Unknown login"));
        }
        
        if( request.getUserPrincipal() != null ){
            urlPath =  "secure/index?faces-redirect=true&";
        }else{    
            urlPath = urlPath + "?faces-redirect=true&";
        }
        log( "AuthenticationController.login:  " + urlPath);
        return urlPath;
    }

    private String getParameter(HttpServletRequest request, String s) {
        Map parameterMap = request.getParameterMap();
        if (parameterMap != null && parameterMap.containsKey(s)) {
            String[] values = (String[]) parameterMap.get(s);

            if (values.length > 0) {
                return values[0];
            }

        }
        return "";
    }
    
    public String logout() throws IOException{
        log( "AuthenticationController.logout: logging - out." );
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        request.getSession().invalidate();
        context.getExternalContext().redirect("../index.html");
        return  "../index.html?faces-redirect=true&";
    }
    
    private void log(String message){
        
        FacesContext.getCurrentInstance().getExternalContext().log(message);
    }
}
