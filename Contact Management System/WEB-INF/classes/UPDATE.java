import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class UPDATE extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/db";
			Connection con = DriverManager.getConnection(url,"root","root");
			Statement st = con.createStatement();

			String sql = "UPDATE contact SET name=?, phone=?, email=? WHERE phone="+phone+";   ";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, phone);
			statement.setString(3, email);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated ==0 ) {
				response.sendRedirect("UpdateError.html");
			}
            else{
                response.sendRedirect("UpdateSuccess.html");
            }
			st.close();
			con.close();
		}
		catch(Exception e){
			out.println(e);
            e.printStackTrace();

		}
	}
}