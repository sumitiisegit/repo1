<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Syntax List</title>
</head>
<body>
<#import "spring.ftl" as spring />
<@spring.bind "model" />
<em><strong>Syntax List 11</strong></em>

<p>
            Message: ${model.message}
        </p>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>
    <br>
   </tr>
<fieldset>
  <#list model["syntaxes"] as c>
    <legend>${c.name}</legend>
  </#list>
</fieldset>
</table>

<br>
<hr>
<a href="/index.html">Home</a><br/>
</body>
</html>