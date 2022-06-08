<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error</title>
</head>
<body style="background-color: black;">
    <h1 style="color: wheat;">Sorry! Something went Wrong ... </h1>
    <h2 style="color: wheat;">You are Not Registered</h2>  
    <br>
    <br>
    <%= exception %>


    <br>


    <form action="SignUp.html" >
        <h2 style="color: wheat;">
            Go To SignUp Page
            <input class="buttons"  type="submit" value='SignUp' >
        </h2>
        
    </form>
</body>
</html>