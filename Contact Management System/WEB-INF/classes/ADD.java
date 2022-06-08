import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ADD extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();

		//int userId = Integer.parseInt(request.getParameter("userId"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		Contact c=new Contact(name, phone, email /*,userId*/);
		ContactDao cdao = new ContactDao(ConnectionProvider.getConnection());

		HttpSession s = request.getSession();

		boolean f = cdao.saveContact(c);
		if(f ){
			//save
			s.setAttribute("succMsg","New Number Is Saved");
			response.sendRedirect("AddSuccess.html");
		}
		else{
			s.setAttribute("errorMsg","Something went wrong...");
			response.sendRedirect("AddError.html");
		}
	
		
	


/*
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/db";
			Connection con = DriverManager.getConnection(url,"root","root");
			Statement st = con.createStatement();

			String q = "INSERT INTO persons(name, phone, email) VALUES('"+name+"', '"+ phone+ "', '"+email+"')";
			//String q = "INSERT INTO persons(name, phone, email) VALUES(?,?,?)";

 			PreparedStatement ps = con.prepareStatement(q);

			//ps.setString(1 , name);
			//ps.setString(2 , phone);
			//ps.setString(3 , email);

			// execute statement
			int rowsUpdated= ps.executeUpdate(q);
			if (rowsUpdated > 0) {
				response.sendRedirect("SuccessADD.html");
			}
		 	else
			{	
			  response.sendRedirect("Error.html");  		
			}

            st.close();
			con.close();
		}
		catch(Exception e){
			out.println(e);
			e.printStackTrace();
		}*/
	}
}