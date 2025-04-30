/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author administration
 */
@WebServlet(urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
           try {
           
           
            String name=request.getParameter("name");
           
            String email=request.getParameter("email");
           
String mobile=request.getParameter("mob");
String pwd=request.getParameter("pwd");

//load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
           
            //make the connection object
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "JAYE2003");
       
            //make preparedstatement object
            PreparedStatement ps=cn.prepareStatement("insert into user(name,email,mobile,password) values(?,?,?,?)");
 
  ps.setString(1, name);
  ps.setString(2, email);
  ps.setString(3, mobile);
  ps.setString(4, pwd);

//execute the query
           
            boolean b=ps.execute();
            if(b==false)
        {
           
            out.println("<div align='left' ><h2>You have successfully registered</h2></div>");
          RequestDispatcher rd=request.getRequestDispatcher("index.html");
          rd.include(request,response);
        }
        cn.close();
        } catch (Exception ex) {
            out.println(ex.toString());
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