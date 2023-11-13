<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="java.util.ArrayList"
    %>
     <%@ page import="it.rf.autolavaggio.model.Cliente" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stile.css">
<meta charset="ISO-8859-1">
<title>Registrazione Cliente</title>
</head>
<body>
<div id="container">
<style>
  table,tr,td{
  
  text-align: center;
  }
</style>



<table align=center>

<th colspan=4><a href="/index">HOME</a></th>
<h1><tr><th colspan=3> ELENCO CLIENTI REGISTRATI :</th></tr></h1>

<tr><td>NOME</td> <td>COGNOME</td><td>CODICE FISCALE</td></tr>
   <% ArrayList<Cliente> lista=(ArrayList<Cliente>)session.getAttribute("lista");
   if(lista!=null){
   for(Cliente c: lista){
%>
<tr>
	<td><%= c.getNome() %> </td>
	<td><%= c.getCognome() %> </td>
	<td><%= c.getCf() %> </td>
</tr>
	
<% } }%>

<tr><td colspan=4>INSERISCI UN NUOVO CLIENTE:</td></tr>
<tr>
<td colspan=4>
<form action="/insertCliente" method="post">
 	  NOME:<br><input type=text name="nome" placeholder="inserisci il nome" required /> <br>  
      COGNOME:<br><input type=text name="cognome" placeholder="inserisci il cognome" required /> <br>      
     CODICE FISCALE:<br><input type=text name="cf" placeholder="inserisci il codice fiscale" required /> <br>
     <input type=submit value=REGISTRA ><br>

</form>
    
     <tr>        
       <th colspan="4">
   
   <% Integer a=(Integer)session.getAttribute("verifica");
   
   if ( a != null) {
       if (a == 1) {
%>
     <%="Cliente inserito"%>
<%
 } else if (a == 0) {
%>
     <%="Il cliente è già stato registrato"%>
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
   
   </th>
  </tr>
    
   
   
   
   
   
</table>
   
    </div>
    <div id="background-image"></div>
</body>
</html>