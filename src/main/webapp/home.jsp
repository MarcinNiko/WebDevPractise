<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="test/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
I love Java
<form action="addAlien">
    <input type="text" name="aid"><br>
    <input type="text" name="aname"><br>
    <input type="text" name="tech"><br>
    <input type="submit"><br>
</form>
${alien.aid}<br>
${alien.aname}<br>

<form action="getAlien">
    <input type="text" name="aid"><br>
    <input type="submit"><br>
</form>

</body>
</html>