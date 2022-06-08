<%@page import="java.util.*" %> 
<%@page errorPage="ErrorPage.jsp" %>

<html>
<body >

<%

HttpSession s=request.getSession();  
User u = (User)s.getAttribute("currentUser");
if(u==null)
{
    response.sendRedirect("LoginError.html");
}

%>


    <h1>You Are Successfully Login</h1>
    <br>
    <br>

    <%= u.getName()  %>
    <br>
    <%= u.getPassword()  %>
    <br>
    <%= u.getConfirmPassword()  %>
    <br>
    <%= u.getEmail()  %>
    <br>
    <%= u.getAddress()  %>
    <br>
    <%= u.getPhone()  %>
    <br>
    <br>

    <form action="Dashboard.html" >
        <h2 style="color: rgb(180, 127, 27);">
            Go To Dashboard
        <input class="buttons"  type="submit" value='Dashboard' >
        </h2>
        
    </form>
    
</body>
</html>