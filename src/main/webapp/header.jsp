<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    HttpSession userSession = request.getSession(false);
    String loggedUser = (userSession != null) ? (String) userSession.getAttribute("user") : null;
%>

<nav class="navbar bg-dark navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Feedback Application</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" aria-disabled="true">Services</a>
        </li>
      </ul>

      <!-- Right side: search + user info -->
      <div class="d-flex align-items-center gap-3">
        <form class="d-flex" role="search">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
          <button class="btn btn-outline-light" type="submit">Search</button>
        </form>

        <% if (loggedUser != null) { %>
          <span class="text-white">👤 <%= loggedUser %></span>
          <a href="<%= application.getContextPath() %>/logout" class="btn btn-outline-danger btn-sm">
            Logout
          </a>
        <% } %>
      </div>

    </div>
  </div>
</nav>