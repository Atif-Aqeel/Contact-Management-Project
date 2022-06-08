import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class SELECT extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		String phone = request.getParameter("phone");

		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/db";
			Connection con = DriverManager.getConnection(url,"root","root");
			Statement st = con.createStatement();

			String q = "SELECT * FROM contact where phone = "+phone+" ";

 			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery(q);

			int count = 0;
			while ( rs.next() ) 
            {
                String name = rs.getString(2);
				String uphone = rs.getString(3);
				String email = rs.getString(4);
				
				String output = "User : %s - %s - %s";
				out.println(String.format(output, name, uphone, email));
				
				//out.println(name);
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