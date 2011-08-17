/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgr.storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.entity.*;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sherwinp
 */
@WebServlet(name = "contentservice", urlPatterns = {"/secure/contentservice"})
public class contentservice extends HttpServlet {

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String User = "sherwinp";
            String Password = "gemget";
            URI uriSource = new URI(String.format("http://localhost:8000/U15/default.xqy", User, Password));
            DefaultHttpClient httpclient = new DefaultHttpClient();
            httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope(uriSource.getHost(), uriSource.getPort()),
                    new UsernamePasswordCredentials(User, Password));

            HttpGet httpget = new HttpGet(uriSource);

            HttpResponse internalresponse = httpclient.execute(httpget);
            int status = internalresponse.getStatusLine().getStatusCode();
            response.setStatus(status);
            if (status == 200) {
                response.setContentType("text/html; charset=UTF-8");
                internalresponse.getEntity().writeTo(response.getOutputStream());
            }
            response.flushBuffer();
            return;
        } catch (java.net.URISyntaxException e) {
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String User = "sherwinp";
            String Password = "gemget";
            URI uriSource = new URI(String.format("http://localhost:8000/U15/default.xqy", User, Password));
            DefaultHttpClient httpclient = new DefaultHttpClient();
            httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope(uriSource.getHost(), uriSource.getPort()),
                    new UsernamePasswordCredentials(User, Password));

            HttpPost httppost = new HttpPost(uriSource);

            httppost.setEntity(new InputStreamEntity(request.getInputStream(), request.getContentLength()));

            HttpResponse internalresponse = httpclient.execute(httppost);

            int status = internalresponse.getStatusLine().getStatusCode();
            response.setStatus(status);

            if (status == 200) {
                response.setContentType("text/html; charset=UTF-8");
                internalresponse.getEntity().writeTo(response.getOutputStream());
            }
            response.flushBuffer();
            return;
        } catch (java.net.URISyntaxException e) {
        }
    }

    /**
     * PUT is used to edit a known Resource.  It is not used for Resource
     *  creation.
     */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String User = "sherwinp";
            String Password = "gemget";
            URI uriSource = new URI(String.format("http://localhost:8000/U15/default.xqy", User, Password));
            DefaultHttpClient httpclient = new DefaultHttpClient();
            httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope(uriSource.getHost(), uriSource.getPort()),
                    new UsernamePasswordCredentials(User, Password));

            HttpPut httpput = new HttpPut(uriSource);

            httpput.setEntity(new InputStreamEntity(request.getInputStream(), request.getContentLength()));

            HttpResponse internalresponse = httpclient.execute(httpput);

            int status = internalresponse.getStatusLine().getStatusCode();
            response.setStatus(status);

            if (status == 200) {
                response.setContentType("text/html; charset=UTF-8");
                internalresponse.getEntity().writeTo(response.getOutputStream());
            }
            response.flushBuffer();
            return;
        } catch (java.net.URISyntaxException e) {
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    /*  from RFC5023 ATOM PUB
    GET is used to retrieve a representation of a known Resource.
    To list the Members of a Collection, the client sends a GET request
    to the URI of a Collection.  An Atom Feed Document is returned whose
    Entries contain the IRIs of Member Resources.
     * 
    POST is used to create a new, dynamically named, Resource.  When
    the client submits non-Atom-Entry representations to a Collection
    for creation, two Resources are always created -- a Media Entry
    for the requested Resource, and a Media Link Entry for metadata
    about the Resource that will appear in the Collection.
    
    
    
    DELETE is used to remove a known Resource.
     */
}
