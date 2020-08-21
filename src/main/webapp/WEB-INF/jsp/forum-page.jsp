<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Forum</title>
    <link type="text/css" rel="stylesheet" href="bootstrap.min.css"/>
</head>
<body>
<div id="container" class="mx-auto" style="height:750px; width:750px;">
    <p><h1 class="text-center">Forum page</h1></p>
    <form:form action="displayMessages" modelAttribute="post" method="post">
        <div class="form-group">
            <p><form:textarea path="message" id="message" class="form-control"/></p>
        </div>
    </form:form>
</div>
</body>
</html>