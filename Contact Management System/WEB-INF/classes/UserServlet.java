import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{        
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
	        
        try{

            String uname=request.getParameter("username");
            String password=request.getParameter("password");
            String confirmPassword =request.getParameter("confirmPassword");
            String email =request.getParameter("email");
            String address=request.getParameter("address");
            String phone =request.getParameter("phone");

            //create user object and set all data to that object
            User usersave = new User(uname, password, confirmPassword, email, address, phone);


            // create userdao object
            UserDao dao = new UserDao(ConnectionProvider.getConnection());
            if(dao.saveUser(usersave) ){
                //save
                //out.println("done");
                response.sendRedirect("SignupSuccess.html");
            }
            else{
                out.println("SignupError.html");
            }
        
            
        }   
        catch(Exception e)
        {
            e.printStackTrace();
            out.println(e);
        }

    }
}