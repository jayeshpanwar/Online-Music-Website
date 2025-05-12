<%-- 
    Document   : edit
    Created on : 01-May-2025, 7:28:50 pm
    Author     : administration
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Student!</h1>
       
        <%!
          String id,name,email;  
            %>
        
        
        <%
       
         
            
            try {
        
             id=request.getParameter("idd"); 
//out.println(roll); 

                        //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
           
            //make the connection object
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "JAYE2003");
       
            //make preparedstatement object
            PreparedStatement ps=cn.prepareStatement("select * from user where id=?");
 ps.setString(1,id);
//execute the query
           
            ResultSet rs=ps.executeQuery();
   

         while(rs.next())
            {
            
             name=rs.getString(2);
             email=rs.getString(3);
            
            //out.println(roll+":"+name+":"+per);
           
            }
            
        cn.close();
        } catch (Exception ex) {
            out.println(ex.toString());
        }

%>


  
        <form action="update.jsp">
            <pre>
<input type="text" name="roll" value='<%=id%>' readonly>                
<input type="text" name="name" value="<%=name%>">
<input type="text" name="per" value="<%=email%>">
           <input type="submit" value="Update">
            </pre>
        </form>





    </body>
</html>
