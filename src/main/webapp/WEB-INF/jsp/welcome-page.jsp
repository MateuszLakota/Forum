<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Forum</title>
    <link type="text/css" rel="stylesheet" href="bootstrap.min.css"/>
</head>
<body>
<div id="container" class="mx-auto" style="height:750px; width: 750px;">
    <p><h2 class="text-center">Forum</h2></p>
    <p><h4 class="text-center">Welcome page</h4></p>
    <form:form action="proceedToVerification" modelAttribute="user" method="post">
        <div class="form-group">
            <label for="nickname">Nickname</label>
            <form:input path="nickname" id="nickname" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="dateOfBirth">Birthday</label>
            <form:input path="dateOfBirth" id="dateOfBirth" class="form-control" type="date"/>
        </div>
        <input type="submit" value="Proceed to verification" class="btn btn-primary btn-block"/>
    </form:form>
</div>
</body>
</html>