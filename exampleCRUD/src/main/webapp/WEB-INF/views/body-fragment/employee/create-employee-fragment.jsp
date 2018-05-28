<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<span><a href="${pageContext.request.contextPath}/employee/list">> Employee list</a></span><br><br>
<form:form
	action="${pageContext.request.contextPath}/employee/create-employee"
	method="post" modelAttribute="employeeForm"
	class="contact2-form validate-form">

	<form:hidden path="employeeId" />

	<span class="contact2-form-title"> Create new employee </span>

	<div class="wrap-input2 validate-input"
		data-validate="Name is required">
		<span>Name</span>
		<form:input cssClass="input2" path="name" placeholder="NAME" />
	</div>

	<div class="wrap-input2 validate-input">
		<span>Age</span>
		<form:input cssClass="input2" path="age" placeholder="AGE" />
	</div>

	<div class="wrap-input2 validate-input"
		data-validate="Message is required">
		<span>Company</span>
		<form:select cssClass="input2" path="companyId" placeholder="COMPANY">
			<form:option value="1">FPT</form:option>
			<form:option value="2">Framgia</form:option>
		</form:select>
	</div>

	<div class="container-contact2-form-btn">
		<div class="wrap-contact2-form-btn">
			<div class="contact2-form-bgbtn"></div>
			<button type="submit" class="contact2-form-btn">Create</button>
		</div>
	</div>
</form:form>