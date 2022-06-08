import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{        
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
	        
        try{
            // fatch credentials from request
            String uname=request.getParameter("username");
            String password=request.getParameter("password");

            // create userdao object
            UserDao dao = new UserDao(ConnectionProvider.getConnection());

            User u = dao.getLogin(uname, password);
            HttpSession s = request.getSession();

            String Cnic ;
    	    String Password;

            if(u==null )
            {   
                s.setAttribute("InvalidMsg","Invalid Username and Password");
                response.sendRedirect("LoginError.html");
            }
            else{
                // login success
                s.setAttribute("currentUser",u);
                //s.setMaxInactiveInterval(2*24*60*60);

                response.sendRedirect("LoginSuccess.html");
            }
        }   
        catch(Exception e)
        {
            e.printStackTrace();
            out.println(e);
        }
    }
}