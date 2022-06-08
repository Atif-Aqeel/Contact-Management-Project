//package mypack;
import java.io.*;
import java.util.*;
import java.sql.*;

public class User {

  private int id;
  private String username;
  private String password;
  private String confirmPassword;
  private String email;
  private String address;
  private String phone;

  public User()
  {

  }

  public User(int id, String username,String password,String confirmPassword, String email,String address, String phone)
  {
    this.id = id;
    this.username = username;
    this.password = password;
    this.confirmPassword = confirmPassword;
    this.email = email;
    this.address = address;
    this.phone = phone;
  }
 
  public User( String username,String password,String confirmPassword, String email,String address, String phone)
  {
    //this.id = id;
    this.username = username;
    this.password = password;
    this.confirmPassword = confirmPassword;
    this.email = email;
    this.address = address;
    this.phone = phone;
  }

  
  // setters
	public void setId(int i)
	{
		id = i;
	}

	public void setName(String n)
	{
		username=n;		
	}
  public void setPassword(String p)
	{
		password=p;		
	}
  public void setConfirmPassword(String cp)
	{
		confirmPassword=cp;		
	}
  public void setEmail(String e)
	{
		email=e;
	}
	public void setAddress(String a)
	{
		address=a;
	}
	public void setPhone(String ph)
	{
		phone=ph;
	}
	

  // getters
	public int getId( )
	{
		return id;
  }

	public String getName()
	{
		return username;
	}
  public String getPassword()
	{
		return password;
	}
  public String getConfirmPassword()
	{
		return confirmPassword;
	}
	public String getAddress()
	{
		return address;
	}
  public String getEmail()
	{
		return email;
	}
	public String getPhone()
	{
		return phone;
	}


} 