/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
public class login extends HttpServlet {
    Connection con;
    ResultSet rs;
    Statement st;
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
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            st = con.createStatement();
            
            String str1 = request.getParameter("id");
            String str2 = request.getParameter("pass");
            HttpSession session = request.getSession(true);
            session.setAttribute("id",str1 );
            rs = st.executeQuery("select * from students");
            boolean flag=false;
            if(str1.equals("library1") && str2.equals("library1")){
                        
                        session.setAttribute("name",str1);
                        session.setAttribute("pass",str2);
                        response.sendRedirect("title.html");
            }
            while (rs.next()) {
                if(rs.getString(1).equals(str1) && rs.getString(2).equals(str2) ){
                       
                        session.setAttribute("name",str1);
                        session.setAttribute("pass",str2);
                        
                        
                        response.sendRedirect("studentwelcome.html");
                }
                else{
                        flag=true;
                }
            }
            if(flag){
                RequestDispatcher rd=request.getRequestDispatcher("HOME.html");
                rd.include(request, response);
                out.println("<h2 align='center'><font color='red'>Please Enter Correct Username Or Password</font></h2>");
            }
            out.println("</table></body></html>");
            st.close();
            rs.close();
        }catch (Exception ex) {
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
