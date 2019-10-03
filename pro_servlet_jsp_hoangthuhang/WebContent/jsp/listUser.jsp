<%@page import="model.UserBean"%>
<%@page import="common.Common"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="ShowError.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 60%;
}

table, th, td {
	border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body>
	<h3>Use Code Java in JSP</h3>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Birthday</th>
				<th>Birthplace</th>
			</tr>
		</thead>
		<tbody>
			<%
				ArrayList<UserBean> ls = (ArrayList<UserBean>) request.getAttribute("listUser");
			%>
			<%
				for (UserBean us : ls) {
			%>
			<tr>
				<td><%=us.getId()%></td>
				<td><%=Common.encodeHTML(us.getName()) %></td>
				<td><%=us.getBirthday()%></td>
				<td><%=Common.encodeHTML(us.getBirthplace()) %></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<br>
	<h3>Use JSLT</h3>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Birthday</th>
				<th>Birthplace</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listUser}" var="us">
				<tr>
					<td><c:out value="${us.id}"></c:out></td>
					<td><c:out value="${us.name}"></c:out></td>
					<td><c:out value="${us.birthday}"></c:out></td>
					<td><c:out value="${us.birthplace}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>