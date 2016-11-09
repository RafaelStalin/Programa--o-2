<%@page import="java.util.*,usj.lp2.pessoas.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pessoas</title>
</head>
<body>
<%
	ListaPessoas listaPessoas = new ListaPessoas();
	List<Pessoa> turma = listaPessoas.getListaPessoas();
	
	for (Pessoa p : turma){
		out.print(p.getName() +" - "+  p.getEmail()+ "<br/>");
	}

	Pessoa p = new Pessoa();
	p.setName("Rafael");
	p.setEmail("rafaelstalin@hotmail.com");
	out.print(p.getName() +" - "+  p.getEmail());
%>
</body>
</html>