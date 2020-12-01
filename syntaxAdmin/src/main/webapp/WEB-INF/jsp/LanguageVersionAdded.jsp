<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Language Version Added</title>
</head>
<body>


<p>

    <c:if test="${not empty addMessage}">
<em><strong>    ${addMessage} </strong></em> <br>
    </c:if>
</p>


<br>
<a href="/AddSyntax.html">Add More Language</a>
<br/>
<br>
<hr>
<a href="/index.html">Home</a><br/>
</body>
</html>