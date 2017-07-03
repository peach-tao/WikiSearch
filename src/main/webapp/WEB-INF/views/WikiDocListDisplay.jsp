<%--
  Created by IntelliJ IDEA.
  User: 啦啦二胡
  Date: 2017/7/2
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Spring MVC Hello World</title>
</head>

<body>
<h2>All WikiDoc in System</h2>

<form:form action="searchWikiDocs" method="get">
    <table>
        <tr>
            <td>search word:</td><td><form:input type="text" path="word"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>

<table border="1">
    <tr>
        <th>WikiDoc Id</th>
        <th>WikiDoc Title</th>
        <th>WikiDoc Abstract</th>
        <th>WikiDoc Url</th>

    </tr>
    <c:forEach items="${WikiDocs}" var="WikiDocS">
        <tr>
            <td>${WikiDocS.id}</td>
            <td>${WikiDocS.title}</td>
            <td>${WikiDocS.url}</td>
            <td>${WikiDocS.a_abstract}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>