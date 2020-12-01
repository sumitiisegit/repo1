<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Add Syntax Data</title>
</head>
<body>

<br>
<br>

<em><strong>Add Language Version:</strong></em>


<h1>Form</h1>
<form action="addLangVer" method="get">
    <p>Select Language: </p>
    <select name="languageIdSelect">
      <c:if test="${not empty languageList}">
        			<c:forEach var="listValue" items="${languageList}">
        			<td><option id=${listValue.id} value=${listValue.id}>${listValue.languageName}</option> </td>
        			</c:forEach>
       </c:if>
       </select>
    <p>Language Version: <input type="text" name="version" /></p>
    <p><input type="submit" value="Submit" />
        <input type="reset" value="Reset" /></p>
</form>

<br>


<br>
<hr>
<a href="/index.html">Home</a><br/>
</body>
</html>