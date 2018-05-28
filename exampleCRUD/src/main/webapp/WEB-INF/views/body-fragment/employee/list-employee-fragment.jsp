<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<span class="contact2-form-title"> Employee list </span>

<span><a href="${pageContext.request.contextPath}/employee/create-employee">Add new employee</a></span><br><br>
<table style="border: solid 1px black; border-radius: 5px;">
	<tr style="border: solid 1px black;">
		<td style="width: 150px; padding:5px; text-align: center;">Employee Id</td>
		<td style="width: 200px; padding:5px; text-align: center;">Name</td>
		<td style="width: 150px; padding:5px; text-align: center;">Age</td>
		<td style="width: 150px; padding:5px; text-align: center;">Company</td>
		<td style="width: 150px; padding:5px; text-align: center;"></td>
	</tr>
	<c:forEach var="employee" items="${employeeListForm.employeeList}">
		<tr>
			<td style="width: 150px; padding:5px; text-align: center;">${employee.employeeId}</td>
			<td style="width: 200px; padding:5px; text-align: center;">${employee.name}</td>
			<td style="width: 150px; padding:5px; text-align: center;">${employee.age}</td>
			<td style="width: 150px; padding:5px; text-align: center;">
				<c:if test="${employee.companyId eq 1}">FPT</c:if>
				<c:if test="${employee.companyId eq 2}">Framgia</c:if>
			</td>
			<td style="width: 150px; padding:5px; text-align: center; color: red">
				<a href="${pageContext.request.contextPath}/employee/delete?employeeId=${employee.employeeId}">
					Delete
				</a>
			</td>
		</tr>
	</c:forEach>
</table>