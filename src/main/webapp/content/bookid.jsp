<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/menu_dashboard.css">
</head>
<body>
<ul style="width: 500px;">
<pre>
<form action="${pageContext.request.contextPath}/AddBook" method="post" style="text-align: center;">
<h1 style="text-align: center; color: white;">A D D    B O O K</h1>
<input type="text" placeholder="Book ID" name="bookid" size="50">


<input type="submit" value="Submit" >


</form>
</pre>
</ul>
</body>
</html>