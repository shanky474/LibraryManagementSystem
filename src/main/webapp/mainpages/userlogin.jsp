<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${sessionScope.user.name}(${sessionScope.user.role})</title>
<link rel="stylesheet" type="text/css" href="css/tables.css">
</head>
<body>
	<div class="TopBar">
		<c:import url="topbar/menu_user.jsp"></c:import>
	</div>

	<div class="Content">
		<c:import url="content/bookings.jsp"></c:import>
	</div>

	<a href="mainpages/addbook.jsp">&#43; Add</a> | <a href="#AddBook">&#45; Remove</a>

	<div class="Footer">
		<c:import url="footer/footer.jsp"></c:import>
	</div>
</body>
</html>