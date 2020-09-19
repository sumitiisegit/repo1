<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Syntax List</title>
</head>
<body>

<em><strong>Syntax List</strong></em>

<p>
    Message: ${message}
    Message1: ${message1}
</p>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>
    <br>
</table>

        <ul>
            <c:forEach var="syntax" items="${syntaxList}">
                    <li>${syntax.name}</li>
            </c:forEach>
        </ul>




<br>
<hr>
<a href="/index.html">Home</a><br/>
</body>
</html>