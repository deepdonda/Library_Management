/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
public class issuing extends HttpServlet {

    Connection con;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet issuing</title>");
            out.println("</head>");
            out.println("<body>");
               
          HttpSession session = request.getSession(false);
          if (session != null) {
              
            RequestDispatcher rd=request.getRequestDispatcher("option.html");
                rd.include(request, response);
                
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            Statement st = con.createStatement();

            String st1 = request.getParameter("id");
            String st2 = request.getParameter("code");
            String st3 = request.getParameter("doi");
            String st4 = request.getParameter("doe");
            
            out.println("<h1>");
            out.println("id: "+st1+ "<br>");
            out.println("Code: "+st2+" <br>");
            out.println("Date Of Issue: "+st3+ "<br>");
            out.println("Date Of Expiry: "+st4 +"<br>");
            
            int j = st.executeUpdate("insert into issue values('" + st1 + "','" + st2 + "','" + st3 + "','" + st4 + "')");
            if (j > 0) {
                out.println("<html><body bgcolor = pink><h1>The data is added successfully</h1></body></html>");
            } else {
                out.println("<html><body bgcolor = pink><h1><font color='red'>Somthing Went Wrong......</font></h1></body></html>");
            }
            out.println("</h1>");
            out.println("</body>");
            out.println("</html>");
          }
          else {
                
                out.println("<font color='red'><h2 align='center'>You Need To First Login</h2></font>");
                RequestDispatcher rd = request.getRequestDispatcher("HOME.html");
                rd.include(request, response); 
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
