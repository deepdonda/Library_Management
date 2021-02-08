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

/**
 *
 * @author Dell
 */
public class addbooks extends HttpServlet {
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
            out.println("<title>Servlet addbooks</title>");            
            out.println("</head>");
            out.println("<body>");
            
            RequestDispatcher rd=request.getRequestDispatcher("option.html");
                rd.include(request, response);
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            Statement st = con.createStatement();
            
            String str1 = request.getParameter("bn");
            String str2 = request.getParameter("bc");
            String str3 = request.getParameter("Aut");
            String str4 = request.getParameter("pr");
            String str5 = request.getParameter("rn");
            String str6 = request.getParameter("nob");
            
            out.println("<h1>");
            out.println("Name: "+str1+ "<br>");
            out.println("Code: "+str2+" <br>");
            out.println("Author: "+str3+ "<br>");
            out.println("Price: "+str4 +"<br>");
            out.println("Rack_N0: "+str5 +"<br>");
            out.println("No_Of_Book: "+str6 +"<br>");
            
            int k = st.executeUpdate("insert into book values('"+str1+"','"+str2+"','"+str3+"','"+str4+"','"+str5+"','"+str6+"')"); 
            if(k>0)
             out.println("books are added successfully");
            else
             out.println("books are not added");
            
            out.println("</h1>");
            out.println("</body>");
            out.println("</html>");
           }
           catch(Exception ex){ex.printStackTrace();}
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
