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
    	<h3 class="text-white">Fill Feedback Form</h3>
    	
    	<form class="mt-3 text-white" action="<%= application.getContextPath() %>/feedback" method="post">
    	<!-- email field -->
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" placeholder="Enter your email" name ="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text text-white">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Contact</label>
    <input type="number" name="phone" placeholder="Enter your number" class="form-control" id="exampleInputPassword1">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Your Feedback</label>
    <textArea name="feedback_message" placeholder="Enter Message" rows="10" cols ="" class="form-control"></textArea>
  </div>
  <div class="container text-center">
  	<button type="submit" class="btn btn-warning">Submit</button>
  	<button type="reset" class="btn btn-light">Reset</button>
  </div>
</form>
    </div>
    <%@include file="comp/scripts.jsp" %>
  </body>
</html>