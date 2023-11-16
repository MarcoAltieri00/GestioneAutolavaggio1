<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.ArrayList" %>
<%@ page import="it.rf.autolavaggio.model.Veicolo" %>
<%@ page import="it.rf.autolavaggio.model.Possiede" %>
<%@ page import="it.rf.autolavaggio.model.dto.RecuperoInfoDTO" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/stile.css">
    <meta charset="ISO-8859-1">
    <title>Registrazione Veicolo</title>
    <style>
        table, tr, td {
            border: 1px solid black;
            text-align: center;
        }
    </style>
</head>
<body>
 
<table align="center">
    <tr>
        <th colspan="4"><a href="/index">HOME</a></th>
           <h1><tr>
        <th colspan="4">VEICOLI REGISTRATI :</th>
    </tr></h1>
    </tr>

    <tr>
        <td>TARGA</td>
        <td>TELAIO</td>
        <td>CODICE FISCALE</td>
    </tr>
    <% ArrayList<RecuperoInfoDTO> lista=(ArrayList<RecuperoInfoDTO>)session.getAttribute("listapos");
    if(lista!=null){
        for(RecuperoInfoDTO r : lista){ %>
            <tr>
                <td><%= r.getTarga() %></td>
                <td><%= r.getnTelaio() %></td>
                <td><%= r.getCfCliente() %></td>
            </tr>
        <% }
    } %>

    <tr>
        <td colspan="4">INSERISCI UN NUOVO VEICOLO:</td>
    </tr>
    <tr>
        <td colspan="4">
            <form action="/insertVeicolo" method="post">
                TARGA:<br><input type="text" name="targa" placeholder="inserisci la targa" required /> <br>
                NUMERO DI TELAIO:<br><input type="text" name="nTelaio" placeholder="inserisci il numero telaio" required /> <br>
                CODICE FISCALE:<br><input type="text" name="cf" placeholder="inserisci il codice fiscale" required /> <br>
                <input type="submit" value="REGISTRA" /><br>
            </form>
        </td>
    </tr>

    <tr>
        <th colspan="4">
            <% Integer a=(Integer)session.getAttribute("verifica");
            if (a != null) {
                if (a == 0) { %>
                    <%= "Hai cambiato proprietario" %>                 
                <% } else if (a == 2 && a==4) { %>
                    <%= "Il cliente non è presente" %> <a href="/nuovoCliente">Registralo ora</a>
                <% }else if (a==1){ %>
                	<%= "Veicolo registrato" %>
                <%} } 
            
            request.getSession(false);

            // Verifica se la sessione esiste prima di invalidarla
            if (session != null) {
                // Invalida la sessione
                session.invalidate();
            } %>
        </th>
    </tr>

</table>
<div id="background-image"></div>
</body>
</html>
