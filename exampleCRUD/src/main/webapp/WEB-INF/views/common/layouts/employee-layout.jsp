<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<tiles:insertAttribute name="head-fragment" />
</head>

<body>
	<tiles:insertAttribute name="header" />
	<div class="bg-contact2"
		style="background-image: url('../resources/images/bg-01.jpg');">
		<div class="container-contact2">
			<div class="wrap-contact2">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>
	<tiles:insertAttribute name="footer" />
	<tiles:insertAttribute name="foot-fragment" />
</body>
</html>