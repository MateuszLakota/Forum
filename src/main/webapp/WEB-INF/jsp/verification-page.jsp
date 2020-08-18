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
    <p><h4 class="text-center">Verify yourself</h4></p>
    <form:form action="proceedToForum" modelAttribute="user" method="post">
        <div class="form-group">
            <label for="verificationResult">${user.getRiddle()}</label>
            <form:input path="verificationResult" id="verificationResult" class="form-control" type="number"/>
        </div>
        <form:input path="nickname" id="nickname" class="form-control" type="hidden"/>
        <form:input path="dateOfBirth" id="dateOfBirth" class="form-control" type="hidden"/>
        <form:input path="riddle" id="riddle" class="form-control" type="hidden"/>
        <input type="submit" value="Proceed to forum" class="btn btn-primary btn-block"/>
    </form:form>
</div>
</body>
</html>