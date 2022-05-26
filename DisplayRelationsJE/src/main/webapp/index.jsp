<%-- Document : index Created on : May 20, 2022, 10:49:41 PM Author : marian --%>


<%@page import="static el.db.Db.getCountriesJSObjectWithEclipseLink" %>
<%@page import="static jdbc.db.Db.getCountriesJSObjectWithJdbc" %>



<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/styles.css">
        <script>
            let dataEl =<%=getCountriesJSObjectWithEclipseLink() %>;
            let dataJdbc =<%=getCountriesJSObjectWithJdbc() %>;
            let dataHib;
        </script>
        <script src="js/main.js" type="module"></script>
    </head>
    <body>
        <div id="rootDiv"></div>
    </body>
</html>