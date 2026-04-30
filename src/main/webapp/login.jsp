<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <%@include file="comp/links.jsp" %>
</head>
<body>
<div class="d-flex justify-content-center align-items-center vh-100">
    <div class="card bg-dark text-white p-4" style="width: 380px;">
        <h4 class="mb-3 text-center">Login</h4>

        <% String error = (String) request.getAttribute("error");
           if (error != null) { %>
            <div class="alert alert-danger"><%= error %></div>
        <% } %>

        <form action="<%= application.getContextPath() %>/login" method="post">
            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" name="email" class="form-control" required />
            </div>
            <div class="mb-3">
                <label class="form-label">Password</label>
                <input type="password" name="password" class="form-control" required />
            </div>
            <button type="submit" class="btn btn-warning w-100">Login</button>
        </form>
    </div>
</div>
<%@include file="comp/scripts.jsp" %>
</body>
</html>