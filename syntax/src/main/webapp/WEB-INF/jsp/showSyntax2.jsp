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
        <th>Name</th>
    </tr>
    <br>
</table>
<p>
</p>

<br>
<c:if test="${not empty syntaxDtoList}">

		<ul>
			<c:forEach var="listValue" items="${syntaxDtoList}">
				<li>${listValue.name}</li>
			</c:forEach>
		</ul>
</c:if>
<br>
<hr>
<a href="/index.html">Home</a><br/>
</body>
</html>