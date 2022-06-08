
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class VIEW extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try{
		/*ContactDao cdao = new ContactDao(ConnectionProvider.getConnection());
		String name = cdao.getAllContact(c);
		String phone = cdao.getAllContact(c);
		String email = cdao.getAllContact(c);
		Contact c=new Contact(name, phone, email);
		//cdao.getAllContact(c); */

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/db";
			Connection con = DriverManager.getConnection(url,"root","root");
			Statement st = con.createStatement();

			String q = "SELECT * FROM contact ";

			out.println("<h3>Currently existing data :</h3>");
			out.println("<h4>User Id : Name - Phone - Email</h4>");

 			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
            
			int count = 0;
            while(rs.next())
            {
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				
				String output = "User #%d: %s - %s - %s  <br> ";
				out.println(String.format(output,++count, name, phone, email));
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