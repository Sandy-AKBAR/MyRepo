<%@page import="org.com.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>
${message}</h2>

<%  

List<Customer> clist= (List<Customer>) request.getAttribute("Cust");
if(clist!=null){
for(Customer s:clist){
	
	out.print("<br>"+s.getId()+"\t"+s.getName()+"\t"+s.getLocation());
}
}
%>
</center>
</body>
</html>