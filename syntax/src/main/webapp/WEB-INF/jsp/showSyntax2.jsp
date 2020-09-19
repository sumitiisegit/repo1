<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Syntax List</title>
</head>
<body>

<em><strong>Syntax List</strong></em>

<p>
    Message: ${message} <br>
    Message1: ${message1}
</p>

<table>
    <tr>
        <th>Id</th>
        <th>versionId</th>
        <th>mappingId</th>
        <th>data</th>
    </tr>
    <br>
    <c:if test="${not empty syntaxDtoList}">

    			<c:forEach var="listValue" items="${syntaxDtoList}">
    			<tr>
    				<td>${listValue.id}</td>
    				<td>${listValue.langVersionId}</td>
    				<td>${listValue.langConstructMappingId}</td>
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