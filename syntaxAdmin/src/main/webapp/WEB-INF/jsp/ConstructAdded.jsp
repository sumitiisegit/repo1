<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Construct Added</title>
</head>
<body>


<p>

    <c:if test="${not empty addMessage}">
<em><strong>    ${addMessage} </strong></em> <br>
    </c:if>
</p>


<br>
<a href="/AddConstruct.html">Add More Construct</a>
<br/>
<br>
<hr>

4
-
<a href="/index.html">Home</a><br/>
</body>
</html>