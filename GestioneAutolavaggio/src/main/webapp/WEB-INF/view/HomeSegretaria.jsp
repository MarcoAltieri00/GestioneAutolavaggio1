<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="java.util.ArrayList"
    %>
    <%@ page import="it.rf.autolavaggio.model.Lavorazione" %>
     <%@ page import="it.rf.autolavaggio.model.Eseguita" %>
	<%@ page import="it.rf.autolavaggio.model.dto.RecuperoSegretariaDTO" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Home Segretaria</title>
</head>
<body>



<th colspan=4><a href="/index">HOME</a></th>
<% Integer a=(Integer)session.getAttribute("numero");%>
<form action="/insertOrdine" method="post">
<br>
<tr ><th colspan=4>CREA ORDINE <%= a+1 %> :</th> </tr>
<br>
   <% ArrayList<Lavorazione> lista=(ArrayList<Lavorazione>)session.getAttribute("tabella1");
   if(lista!=null){
   for(Lavorazione l: lista){
%>
<tr>
	<td><%= l.getNome() %> </td>
	<td><%= l.getCosto() %> </td>
	<td><%= l.getCodice() %> </td>
	<td><input type="checkbox" name="ordine" value="<%= l.getCodice() %>"></td>
</tr>
	
<% } }%>

<br>
<br>
TARGA:<input type="text" name="targa" required>
<input type="submit" value="CREA ORDINE" >
<br>
<br>
</form>


<tr ><th colspan=6>LAVORAZIONI ATTIVE <%= a %> :</th> </tr>
<br>

   <% ArrayList<RecuperoSegretariaDTO> lista2=(ArrayList<RecuperoSegretariaDTO>)session.getAttribute("tabella2");
   if(lista2!=null){
   for(RecuperoSegretariaDTO info : lista2){
%>
<br>
<tr>
	<td><%= info.getCodiceOrdine() %> </td>
	<td><%= info.getTarga() %> </td>
	<td><%= info.getNomeLavorazione() %> </td>
	<td><%= info.getPrezzo() %> </td>
	<td><%= info.getCodiceSquadra() %> </td>
	<td><%= info.getDataLavorazione() %> </td>	
</tr>
	<br>
<% } }%>










   <% Integer c=(Integer)session.getAttribute("verifica");
   
   if ( c != null) {
       if (c == 1) {
%>
     <%="Ordine inserito"%>
<%
 } else if (c == 0) {
%>
     <%="Ordine inserito con successo!"%>

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