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
<title>Registrazione Operaio</title>
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
<tr ><th colspan=4>OPERAI :</th> </tr>
<tr><td>NOME</td> <td>COGNOME</td><td>CODICE FISCALE</td></tr>
   <% ArrayList<Operaio> lista=(ArrayList<Operaio>)session.getAttribute("lista");
   if(lista!=null){
   for(Operaio o: lista){
%>
<tr>
<td><%= o.getNome() %> </td>
	<td><%= o.getCognome() %> </td>
	<td><%= o.getCf() %> </td>
</tr>
	
<% } }%>

<tr><td colspan=4>INSERISCI UN NUOVO OPERAIO:</td></tr>
<tr>
<td colspan=4>
<form action="/insertOperaio" method="post">
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
     <%="Operaio inserito"%>
<%
 } else if (a == 0) {
%>
     <%="L'operaio è già registrato"%>
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
<div id="background-image"></div>
</body>
</html>