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


<th colspan=6><a href="/index">HOME</a></th>
<tr ><th colspan=6>LAVORAZIONI ATTIVE :</th> </tr>
<tr><td>CODICE ORDINE</td> <td>TARGA</td><td>LAVORAZIONE</td><td>DATA</td><td>STATUS</td></tr>

   <% ArrayList<RecuperoSegretariaDTO> lista2=(ArrayList<RecuperoSegretariaDTO>)session.getAttribute("tabella2");
   if(lista2!=null){
   for(RecuperoSegretariaDTO info : lista2){
%>
<tr>
<td><%= info.getCodiceOrdine() %> </td>
    <td><%= info.getTarga() %> </td>
    <td><%= info.getNomeLavorazione() %> </td>
    <td><%= info.getDataLavorazione() %> </td>
    <form action="/evadi" method="post">
    <td><input type="hidden" name="numLavoro" value="<%=info.getNumLavoro() %>" >
    <input type="submit"  value="EVADI" name="evaso"  ></td>
    </form>
</tr>

<% } }%>





</table>
<div id="background-image"></div>
</body>
</html>