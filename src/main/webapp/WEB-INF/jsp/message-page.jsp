<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Forum</title>
    <link type="text/css" rel="stylesheet" href="bootstrap.min.css"/>
</head>
<body>
<div id="container" class="mx-auto" style="height:750px; width:750px;">
    <p><h1 class="text-center">Message page</h1></p>
    <form:form action="sendMessage" modelAttribute="post" method="post">
        <div class="form-group">
            <p><form:textarea path="message" id="message" class="form-control"/></p>
            <p><input type="submit" class="btn btn-primary btn-block" value="Send"></p>
        </div>
        <form:input path="nickname" id="nickname" class="form-control" type="hidden"/>
    </form:form>
</div>
</body>
</html>