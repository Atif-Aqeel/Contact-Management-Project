import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class BLOCK extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		String phone = request.getParameter("phone");


		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/project";
			Connection con = DriverManager.getConnection(url,"root","root");
			Statement st = con.createStatement();

			String q = "SELECT * FROM persons where phone = "+phone+" ";
 			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery(q);


			//int rowsUpdated= ps.executeUpdate(q);
			//if (rowsUpdated > 0) {
			//	response.sendRedirect("SuccessBLOCK.html");
			//}
            //else
            //{
            //    out.println(" Not Block ");
            //}


			/*int count = 0;
			while ( rs.next() ) 
            {
                String name = rs.getString(1);
				String uphone = rs.getString(2);
				String email = rs.getString(3);

				int rowsUpdated= ps.executeUpdate(q);
			if (rowsUpdated > 0) {
				response.sendRedirect("SuccessBLOCK.html");
			}
            else
            {
                out.println(" Not Block ");
            }

				//out.println("After Block a number");
				//String output = "User #%d: %s - %s - %s";
				//out.println(String.format(output,++count, name, uphone, email));

            }*/


			st.close();
			con.close();
		}
		catch(Exception e){
			out.println(e);
			e.printStackTrace();
		}
	}
}