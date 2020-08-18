<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Forum</title>
    <link type="text/css" rel="stylesheet" href="bootstrap.min.css"/>
</head>
<body>
<div id="container" class="mx-auto" style="height:750px; width:750px;">
    <p><h2 class="text-center">Forum</h2></p>
    <form:form action="proceedToVerification" modelAttribute="user" method="post">
        <div class="form-group">
            <p><textarea placeholder="Type a message.." class="form-control" name="message" required></textarea></p>
            <p><button type="send" class="form-control">Send</button></p>
            <p><button type="button" class="form-control" onclick="closeForm()">Exit</button></p>
        </div>
    </form:form>
</div>
</body>
</html>