<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Syntax List</title>
</head>
<body>

<em><strong>Syntaxes Data</strong></em>

<p>
    Message: ${message} <br>
    Message1: ${message1}
</p>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Language Name</th>
        <th>Version Name</th>
        <th>Construct Name</th>
        <th>Syntax</th>

    </tr>
    <br>
    <c:if test="${not empty showDataDtoList}">
    			<c:forEach var="listValue" items="${showDataDtoList}">
    			<tr>
    				<td>${listValue.id}</td>
    				<td>${listValue.langName}</td>
    				<td>${listValue.versionName}</td>
    				<td>${listValue.constructName}</td>
     				<td>${listValue.syntaxData}</td>
    				</tr>
    			</c:forEach>
    			
    </c:if>

</table>
<p>
</p>

<br>
<br>
<hr>
<a href="/index.html">Home</a><br/>
</body>
</html>