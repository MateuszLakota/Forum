<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Forum</title>
    <link type="text/css" rel="stylesheet" href="bootstrap.min.css"/>
</head>
<body>
<div id="container" class="mx-auto" style="height:750px; width: 750px;">
    <p><h1 class="text-center">Welcome!</h1></p>
    <p><h2 class="text-center">Enter your nickname and prove you are a human before entering forum</h2></p>
    <form:form action="proceedToForum" modelAttribute="user" method="post">
        <div class="form-group">
            <label for="nickname">Nickname</label>
            <form:input path="nickname" id="nickname" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="resultOfCaptcha">${user.getCaptcha()}</label>
            <form:input path="resultOfCaptcha" id="resultOfCaptcha" class="form-control" type="number"/>
        </div>
        <form:input path="captcha" id="captcha" class="form-control" type="hidden"/>
        <input type="submit" value="Proceed to forum" class="btn btn-primary btn-block"/>
    </form:form>
</div>
</body>
</html>