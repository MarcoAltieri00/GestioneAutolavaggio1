<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.ArrayList" %>
<%@ page import="it.rf.autolavaggio.model.Veicolo" %>
<%@ page import="it.rf.autolavaggio.model.Eseguita" %>
<%@ page import="it.rf.autolavaggio.model.Cliente" %>


<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/stile.css">
    <meta charset="ISO-8859-1">
    <title>Storico Clienti</title>
    <style>
        table, th, td {
            border: 1px solid black;
            text-align: center;
        }
    </style>
</head>
<body>

<table align="center">
    <th colspan="4"><a href="/index">HOME</a></th>
    <% Cliente c= (Cliente) session.getAttribute("cliente");%>
    <tr><th colspan="4">VEICOLI DI <%=c.getNome()%> <%=c.getCognome() %> :</th></tr>
    <tr><td>TARGA</td> <td>N. TELAIO</td></tr>
    
    
    <% ArrayList<Veicolo> lista = (ArrayList<Veicolo>) session.getAttribute("listaVeicoli");
    if (lista != null) {
        for (Veicolo v : lista) {
    %>
            <tr>
                <td><%= v.getTarga() %> </td>
                <td><%= v.getnTelaio() %> </td>
            </tr>
    <% } } %>
</table>
<br>
<form action="/visualizzaStorico" method="post">
 
</form>
<br>
<center>
    <table>
        <tr><th colspan="6">LAVORAZIONI ORDINATE:</th></tr>
        <tr>
            <td>DATA</td>
            <td>TARGA</td>
            <td>CODICE SQUADRA</td>
            <td>NOME LAVORAZIONE</td>
            <td>COSTO</td>
        </tr>

        <% ArrayList<Eseguita> lista2 = (ArrayList<Eseguita>) session.getAttribute("listaOrdini");
        if (lista2 != null && !lista2.isEmpty()) {
            for (Eseguita e : lista2) {
        %>
                <tr>
                    <td><%= e.getDataLavorazione() %> </td>
                    <td><%= e.getVeicolo().getTarga() %> </td>
                    <td><%= e.getSquadra().getCodiceSquadra() %> </td>
                    <td><%= e.getLavorazione().getNome() %> </td>
                    <td><%= e.getLavorazione().getCosto() %> </td>
                </tr>
        <% }
        } else {
        %>
            <tr>
                <td colspan="6">Il cliente non ha ancora eseguito una lavorazione</td>
            </tr>
        <% } %>
    

<%Float costo = (Float) session.getAttribute("listaSpese"); %>
<%if(costo!= null) %>
<tr> <td colspan=5>
IL CLIENTE HA SPESO IN TOTALE: <%=costo %> EURO
</td></tr>
 
</table>



<div id="background-image"></div>
</body>
</html>
