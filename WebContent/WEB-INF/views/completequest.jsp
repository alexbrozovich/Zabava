<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
		<tr align="center">
			<th>Correct Answers</th>
			<th>Your Answers</th>
		</tr>
		<tr>
		<tr align="center">
			<td>
				<table>
					<c:forEach var="adminAnswers" items="${aAnswers}">
						<tr>
							<td>${adminAnswers}</td>
						</tr>
					</c:forEach>
				</table>
			</td>
			<td>
				<table>
					<c:forEach var="inputAnswers" items="${uAnswers}">
						<tr>
							<td>${inputAnswers}</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>