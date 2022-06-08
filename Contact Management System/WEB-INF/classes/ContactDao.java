import java.io.*; 
import java.sql.*; 
import java.util.*; 


public class ContactDao{

    private Connection con;

    public ContactDao(Connection con){
        this.con=con;
    }


    //add contact
    public boolean saveContact(Contact c){
        boolean f=false;
        try { // user ---> database
            String query = "INSERT INTO contact(name,phone,email )VALUES(?,?,?) ";

            PreparedStatement ps = this.con.prepareStatement(query);

            ps.setString(1, c.getName() );
            ps.setString(2 , c.getPhone());
            ps.setString(3 , c.getEmail());
            
            ps.executeUpdate();
            f=true;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return  f;
    }


    //total contact
    public Contact getAllContact(Contact contact){
        Contact c = null;
        try {
            String sql = "select * from contact ";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                c=new Contact();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setPhone(rs.getString(3));
                c.setEmail(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }



    //Edit
    
}



