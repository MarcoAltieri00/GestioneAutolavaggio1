<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="java.util.ArrayList"
    %>
     <%@ page import="it.rf.autolavaggio.model.Lavorazione" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Inserimento Lavorazione</title>
</head>
<body>



<th colspan=4><a href="/index">HOME</a></th>
<br>
<br>
<tr ><th colspan=4>LAVORAZIONI :</th> </tr>

<br>
   <% ArrayList<Lavorazione> lista=(ArrayList<Lavorazione>)session.getAttribute("lista");
   if(lista!=null){
   for(Lavorazione l: lista){
%>
<tr>
	<td><%= l.getCodice() %> </td>
	<td><%= l.getNome() %> </td>
	<td><%= l.getCosto() %> </td>
</tr>
	
<% } }%>


<tr>
<td colspan=4>
<form action="/insertLavorazione" method="post">
<br>
 	  NOME:<br><input type=text name="nome" placeholder="inserisci il nome" required /> <br>  
      COSTO:<br><input type=number name="costo" placeholder="inserisci il costo" required /> <br>      
     <input type=submit value=REGISTRA ><br>
<br>
</form>
    
     <tr>        
       <th colspan="4">
   
   <% Integer a=(Integer)session.getAttribute("verifica");
   
   if ( a != null) {
       if (a == 1) {
%>
     <%="Lavorazione inserita con successo!"%>
<%
 } else if (a == 0) {
%>
     <%="La lavorazione  è già presente"%>
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