/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.ComentarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oscar
 */
public class ServletContacto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        ComentarioDao dao = new ComentarioDao();
        
        
        String name = request.getParameter("InputName");
        String mail = request.getParameter("InputEmail");
        String message = request.getParameter("InputMessage");
        
        
        dao.addComentario(name, mail, message);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Gracias!</title>");

            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Gracias por contactarnos, "+name+ "</h1>");
            out.println("<br/><br/>");
            out.println("<a href=\"contactanos.html\">Regresar</a>");
            out.println("<br/><br/>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
