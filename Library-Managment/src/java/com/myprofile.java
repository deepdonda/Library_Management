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
public class myprofile extends HttpServlet {
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
            out.println("<title>Servlet myprofile</title>");            
            out.println("</head>");
            out.println("<body bgcolor='#1ea5a8'>");
            
            
            HttpSession session = request.getSession(false);
            if (session != null) {
            
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
                st = con.createStatement();
                
                RequestDispatcher rd=request.getRequestDispatcher("studentoption.html");
                rd.include(request, response);
                
                rs = st.executeQuery("select * from students");
                
                Object str1= session.getAttribute("name");
                Object str2 = session.getAttribute("pass");
                
                out.println("<font color='#D1E8E2'>Welcome!......</font>"); 
                
                while (rs.next()) {
                    if(rs.getString(1).equals(str1) && rs.getString(2).equals(str2)) {
                        out.println("<h2>");
                        out.println("Id: "+rs.getString(1)+"<br>");
                        out.println("Name: "+rs.getString(3)+"<br>");
                        out.println("Address: "+rs.getString(4)+"<br>");
                        out.println("Mobile: "+rs.getString(5)+"<br>");
                        out.println("<h2>");
                    }
                }
                out.println("</table></body></html>");
                st.close();
                rs.close();
        
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
