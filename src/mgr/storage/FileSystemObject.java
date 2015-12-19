package mgr.storage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sherwinp
 */
@WebServlet(name = "FileSystemObject", urlPatterns = {"/secure/FileSystemObject"})
public class FileSystemObject extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            File U15 = (java.io.File)request.getSession().getServletContext().getAttribute("javax.servlet.context.tempdir");
            String dir = request.getParameter("dir");
            if (dir == null) {
                return;
            }

            if (dir.charAt(dir.length() - 1) == '\\') {
                dir = dir.substring(0, dir.length() - 1) + "/";
            } else if (dir.charAt(dir.length() - 1) != '/') {
                dir += "/";
            }
            
            dir = java.net.URLDecoder.decode(dir, "UTF-8");
            
            if( dir.equalsIgnoreCase("/") )
                dir = U15.getCanonicalPath() + java.io.File.separator;
            
            if (new File(dir).exists()) {
                String[] files = new File(dir).list(new FilenameFilter() {

                    public boolean accept(File dir, String name) {
                        return name.charAt(0) != '.';
                    }
                });
                Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
                out.print("<ul class=\"jqueryFileTree\" style=\"display: none;\">");
                // All dirs
                for (String file : files) {
                    if (new File(dir, file).isDirectory()) {
                        out.print("<li class=\"directory collapsed\"><a href=\"#\" rel=\"" + dir + file + "/\">"
                                + file + "</a></li>");
                    }
                }
                // All files
                for (String file : files) {
                    if (!new File(dir, file).isDirectory()) {
                        int dotIndex = file.lastIndexOf('.');
                        String ext = dotIndex > 0 ? file.substring(dotIndex + 1) : "";
                        out.print("<li class=\"file ext_" + ext + "\"><a href=\"#\" rel=\"" + dir + file + "\">"
                                + file + "</a></li>");
                    }
                }
                out.print("</ul>");
            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet View Application FileSystem Storage";
    }// </editor-fold>
}
