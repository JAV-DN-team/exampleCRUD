<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<tiles:insertAttribute name="header" />
<div class="container">
  <h2>Login form</h2>
  <c:if test="${not empty errorMsg}">
  	<h3 style="color:red"><c:out value="${errorMsg}" /></h3>
  </c:if>
  <form action="${pageContext.request.contextPath}/login" method="post">
    <div class="form-group">
      <label for="Username">Username:</label>
      <input type="text" name="username" class="form-control" placeholder="Enter username" required/>
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" name="password" class="form-control" placeholder="Enter password" required/>
    </div>
    <div class="checkbox">
      <label><input type="checkbox" name="remember-me"> Remember me</label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

</body>
</html>
