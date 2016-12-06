<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tabela Aleatórios</title>
</head>
<body>
<%@ page import="usj.lp2.pessoas.NumerosAleatorios"%>
<%
	NumerosAleatorios numAleatorio = new NumerosAleatorios();
	int[] num = numAleatorio.getNum();
	 
	for(int i=0; i<num.length; i++){
	         System.out.print(num[i]+"  ");
	}
%>
<table>
<% for (int i=0; i < num.length; i++){
%>
<tr>
<td><%out.print(num[i][0]); %></td>
<td><%out.print(num[i][1]); %></td>
</tr>
<%}
</table>
</body>
</html>