<%@page import="static hib.db.Db.getCountriesJSObjectWithHibernate" %>
<%@page import="static jdbc.db.Db.getCountriesJSObjectWithJdbc" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/styles.css">
        <script>
            let dataEl;
            let dataHib =<%=getCountriesJSObjectWithHibernate() %>;
            let dataJdbc =<%=getCountriesJSObjectWithJdbc() %>; 
        </script>
        <script src="js/main.js" type="module"></script>
    </head>
    <body>
        <div id="rootDiv"></div>
    </body>
</html>