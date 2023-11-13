<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="java.util.ArrayList"
    %>
     <%@ page import="it.rf.autolavaggio.model.Operaio" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Registrazione Operaio</title>
</head>
<body>



<th colspan=4><a href="/index">HOME</a></th>
<h1><tr ><th colspan=4>OPERAI REGISTRATI:</th></tr></h1>

   <% ArrayList<Operaio> lista=(ArrayList<Operaio>)session.getAttribute("lista");
   if(lista!=null){
   for(Operaio o: lista){
%>
<br>
<tr>
	<td><%= o.getNome() %> </td>
	<td><%= o.getCognome() %> </td>
	<td><%= o.getCf() %> </td>
</tr>
	<br>
<% } }%>



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
</body>
</html>