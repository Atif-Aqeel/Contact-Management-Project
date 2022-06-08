import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DELETE extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		String phone = request.getParameter("phone");

		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/db";
			Connection con = DriverManager.getConnection(url,"root","root");
			Statement st = con.createStatement();

			//String s=(String)request.getAttribute("phone");
			//DELETE FROM persons WHERE phone=123
			String q = "DELETE FROM contact WHERE phone= "+phone+";  ";

            //ps.setString(2,phone);

			int rowsDeleted = st.executeUpdate(q);

            if (rowsDeleted == 0) {
				response.sendRedirect("DeleteError.html");
			}
            else{
                response.sendRedirect("DeleteSuccess.html");
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