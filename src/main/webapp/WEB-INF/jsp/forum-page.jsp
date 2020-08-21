<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Forum</title>
    <link type="text/css" rel="stylesheet" href="bootstrap.min.css"/>
</head>
<body>
    <div id="container" class="mx-auto" style="height:750px; width:750px;">
        <p><h1 class="text-center">Forum page</h1></p>
            <c:forEach items="${postsContainer.posts}" varStatus="counter" var="postDTO">
                <label for="posts[${counter.index}].message">${postDTO.getLabel()}</label>
                <p><textarea id="posts[${counter.index}].message" name="posts[${counter.index}].message" class="form-control"
                style="height:100px" readonly>${postDTO.message}</textarea></p>
            </c:forEach>
        <form:form action="goToSendMessagePage" modelAttribute="post" method="post">
            <form:input path="nickname" id="nickname" class="form-control" type="hidden"/>
            <input type="submit" value="Post message" class="btn btn-primary btn-block"/>
        </form:form>
    </div>
</body>
</html>