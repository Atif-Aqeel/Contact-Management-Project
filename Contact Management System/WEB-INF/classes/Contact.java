import java.io.*; 
import java.sql.*; 
import java.util.*; 

public class Contact{
    private int id;
    private String name;
    private String phone;
    private String email;
    private int userId;

    public Contact(){
        super();
    }

    public Contact(String name, String phone, String email /*, int userId*/ ){
        super();
        this.name=name;
        this.phone=phone;
        this.email=email;
        //this.userId=userId;
    }

	public Contact(String name, String phone, String email, int id ){
        super();
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.id=id;
    }

    // setters
	public void setId(int i)
	{
		id = i;
	}
	public void setName(String n)
	{
		name=n;		
	}
    public void setPhone(String ph)
	{
		phone=ph;
	}
    public void setEmail(String e)
	{
		email=e;
	}
    public void setUserId(int uid)
	{
		userId=uid;
	}

  // getters
	public int getId( )
	{
		return id;
    }
	public String getName()
	{
		return name;
	}
    public String getPhone()
	{
		return phone;
	}
    public String getEmail()
	{
		return email;
	}
    public int getUserId()
	{
		return userId;
	}
	
    


}