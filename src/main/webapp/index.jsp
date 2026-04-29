<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <%@include file="comp/links.jsp" %>
</head>
<body>

<%@include file="header.jsp" %>

<div class="content_container py-4 d-flex flex-column justify-content-center align-items-center">
    <a href="${pageContext.request.contextPath}/feedback.jsp" class="btn btn-light">
        Give us feedback
    </a>
</div>

<%@include file="comp/scripts.jsp" %>

</body>
</html>