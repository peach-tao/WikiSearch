<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<title>Spring MVC Hello World</title>
</head>

<body>
<h2>All Employees in System</h2>

<form:form action="searchEmployees" method="post">
	<table>
		<tr>
			<td>search word:</td><td><form:input type="text" path="word"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="提交"/></td>
		</tr>
	</table>
</form:form>

<table border="1">
	<tr>
		<th>Employee Id</th>
		<th>First Name</th>
		<th>Last Name</th>
	</tr>
	<c:forEach items="${employees}" var="employee">
		<tr>
			<td>${employee.id}</td>
			<td>${employee.firstName}</td>
			<td>${employee.lastName}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>