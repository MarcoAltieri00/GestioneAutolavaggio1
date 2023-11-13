<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="java.util.ArrayList"
    %>
     <%@ page import="it.rf.autolavaggio.model.Operaio" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stile.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
  table, tr,td{
  border:1px solid black;
  
  text-align: center;
  }
</style>

<table align=center>
<th colspan=4><a href="/index">HOME</a></th>
<% Integer a=(Integer)session.getAttribute("numero");%>

<tr ><th colspan=4>CREA LA SQUADRA <%= a+1 %> :</th> </tr>
<tr><td>NOME</td> <td>COGNOME</td><td>CODICE FISCALE</td><td>CHECK</td></tr>
<form action="/insertSquadra" method="post">
   <% ArrayList<Operaio> lista=(ArrayList<Operaio>)session.getAttribute("tabella1");
   if(lista!=null){
   for(Operaio o: lista){
%>
<tr>
<td><%= o.getNome() %> </td>
	<td><%= o.getCognome() %> </td>
	<td><%= o.getCf() %> </td>
	<td><input type="checkbox" name="operaio" value="<%= o.getCf() %>"></td>
</tr>
	
<% } }%>


</table>
<center>
<input type="submit" value="CREA LA SQUADRA" >

</form>
</center>

<center>
<table>


<tr ><th colspan=4>SQUADRA ATTIVA <%= a %> :</th> </tr>
<tr><td>NOME</td> <td>COGNOME</td><td>CODICE FISCALE</td></tr>

   <% ArrayList<Operaio> lista2=(ArrayList<Operaio>)session.getAttribute("tabella2");
   if(lista2!=null){
   for(Operaio oo: lista2){
%>
<tr>
	<td><%= oo.getNome() %> </td>
	<td><%= oo.getCognome() %> </td>
	<td><%= oo.getCf() %> </td>
	
</tr>
	
<% } }%>

   <% Integer c=(Integer)session.getAttribute("verifica");

   if ( c != null) {
       if (c == 1) {
%>
     <%="Operatori Non Inseriti,Seleziona Almeno Un Operatore! "%>
<%
 } else if (c == 0) {
%>
     <%="Operatori inseriti con successo!"%>
<%
 }
}
request.getSession(false);

// Verifica se la sessione esiste prima di invalidarla
if (session != null) {
// Invalida la sessione
session.invalidate();
}
   
   %>



</table>

</center>
<div id="background-image"></div>
</body>
</html>  