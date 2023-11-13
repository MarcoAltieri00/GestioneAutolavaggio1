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
<form action="/insertOrdine" method="post">

<tr ><th colspan=4>CREA ORDINE <%= a+1 %> :</th> </tr>
<tr><td>LAVORAZIONE</td> <td>COSTO</td><td>CODICE</td><td>SELEZIONA</td></tr>

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


</table>
<center>
TARGA:<input type="text" name="targa" required>
<input type="submit" value="CREA ORDINE" >
</form>
</center>


<center>
<table>

<tr ><th colspan=6>LAVORAZIONI ATTIVE <%= a %> :</th> </tr>
<tr><td>CODICE ORDINE</td> <td>TARGA</td><td>LAVORAZIONE</td><td>PREZZO</td><td>CODICE SQUADRA</td><td>DATA</td></tr>

   <% ArrayList<RecuperoSegretariaDTO> lista2=(ArrayList<RecuperoSegretariaDTO>)session.getAttribute("tabella2");
   if(lista2!=null){
   for(RecuperoSegretariaDTO info : lista2){
%>
<tr>
<td><%= info.getCodiceOrdine() %> </td>
	<td><%= info.getTarga() %> </td>
	<td><%= info.getNomeLavorazione() %> </td>
	<td><%= info.getPrezzo() %> </td>
	<td><%= info.getCodiceSquadra() %> </td>
	<td><%= info.getDataLavorazione() %> </td>	
</tr>
	
<% } }%>





</table>
</center>


<center>

   <% Integer c=(Integer)session.getAttribute("verifica");
   
   if ( c != null) {
       if (c == 1) {
%>
    <h2> <%="Errore nella scelta, seleziona una lavorazione!"%><h2>
<%
 } else if (c == 0) {
%>
    <h2> <%="Lavorazione inserita con successo!"%><h2>
      </center>
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
<div id="background-image"></div>
</body>
</html>