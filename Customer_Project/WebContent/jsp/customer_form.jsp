<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addCustomer">
Enter Id <input name='id'><br>
Enter Name <input name='name'><br>
Enter Location <input name='location'><br>

<input type="submit" value="AddCustomer" name="button"/>
<input type="submit" value="RemoveCustomer" name="button"/>
<input type="submit" value="UpdateCustomer" name="button"/>
</form>

<form action="showallCustomer">
<input type="submit" value="ShowAllCustomer" name="button"/>

</form>
</body>
</html>