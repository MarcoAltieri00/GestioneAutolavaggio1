<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="java.util.ArrayList"
    %>
     <%@ page import="it.rf.autolavaggio.model.Operaio" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Inserimento squadra</title>
</head>
<body>


<th colspan=4><a href="/index">HOME</a></th>
<% Integer a=(Integer)session.getAttribute("numero");%>

<br>
<tr ><th colspan=4>CREA LA SQUADRA <%= a+1 %> :</th> </tr>
<br>
<form action="/insertSquadra" method="post">
   <% ArrayList<Operaio> lista=(ArrayList<Operaio>)session.getAttribute("tabella1");
   if(lista!=null){
   for(Operaio o: lista){
%>
<br>
<tr>
	<td><%= o.getNome() %> </td>
	<td><%= o.getCognome() %> </td>
	<td><%= o.getCf() %> </td>
	<td><input type="checkbox" name="operaio" value="<%= o.getCf() %>"></td>
</tr>
	<br>
<% } }%>



<input type="submit" value="CREA LA SQUADRA" >

</form>




<tr ><th colspan=4>SQUADRA ATTIVA <%= a %> :</th> </tr>


   <% ArrayList<Operaio> lista2=(ArrayList<Operaio>)session.getAttribute("tabella2");
   if(lista2!=null){
   for(Operaio oo: lista2){
%>
<br>
<tr>
	<td><%= oo.getNome() %> </td>
	<td><%= oo.getCognome() %> </td>
	<td><%= oo.getCf() %> </td>
	
</tr>
	<br>
<% } }%>

   <% Integer c=(Integer)session.getAttribute("verifica");
   
   if ( c != null) {
       if (c == 1) {
%>
     <%="Squadra Inserita correttamente"%>
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



</body>
</html>  