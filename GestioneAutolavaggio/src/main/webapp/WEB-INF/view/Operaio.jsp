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
<title>Ordini Giornalieri</title>
</head>
<body>


<table>


<th colspan=6><a href="/index">HOME</a></th>
<tr ><th colspan=6>LAVORAZIONI ATTIVE :</th> </tr>

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

</body>
</html>