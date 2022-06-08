//package MyPack;
import java.io.*; 
import java.sql.*; 
import java.util.*; 

class ConnectionProvider{
    private static Connection con;

    public static Connection getConnection(){
        try {
            
            if(con==null){
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://127.0.0.1/db";
                con=DriverManager.getConnection(url,"root", "root");
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}

public class UserDao{

    private Connection con;

    public UserDao(Connection con){
        this.con=con;
    }

    public boolean saveUser(User user){
        boolean f=false;
        try {
            // user ---> database
            String query = "INSERT INTO user(username,password,confirmPassword,email,address,phone)VALUES(?,?,?,?,?,?) ";

            PreparedStatement ps = this.con.prepareStatement(query);

            ps.setString(1, user.getName() );
            ps.setString(2, user.getPassword() );
            ps.setString(3, user.getConfirmPassword() );
            ps.setString(4 , user.getAddress());
            ps.setString(5 , user.getEmail());
            ps.setString(6 , user.getPhone());

            ps.executeUpdate();
            f=true;

        } 
        catch (Exception e) {
            e.printStackTrace();
            //out.println(e);
        }
        return  f;
    }


    // get username and password for login
    public User getLogin(String username, String password){
        User user =null;

        try {
            String query="Select * from user where username=? and password=? ";
            PreparedStatement ps=con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                // data from db
                user = new User();
                //set to user db 
                String uname = rs.getString("username");
                user.setName(uname);

                user.setId(rs.getInt("id"));
                user.setPassword(rs.getString("password"));
                user.setConfirmPassword(rs.getString("confirmPassword"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
            }
            else{
                System.out.println("Invalid Username and Password (DAO)");
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    // ADD 


}
