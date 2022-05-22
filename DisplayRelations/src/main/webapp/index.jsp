<%-- Document : index Created on : May 20, 2022, 10:49:41 PM Author : marian --%>


    <%@page import="static query.db.Db.getAllCountries" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <link rel="stylesheet" href="css/styles.css">
                <script>let data =<%=getAllCountries() %>;
                    
                </script>
                <script src="js/main.js" type="module"></script>
            </head>

            <body>
                <div id="rootDiv"></div>
            </body>

            </html>