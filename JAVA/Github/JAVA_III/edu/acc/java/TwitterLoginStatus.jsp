<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twitter Login Status</title>
</head>
<body>
Your login status is:
<c:if test="${pswd_ok == 'ok'}">
 Your password is good
</c:if>

<c:if test="${pswd_ok != 'ok'}">
 Your password is not so good
</c:if>

</body>
</html>