<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%--     first name: &lt; <c:out value="${param.first}"  --%>
<%--                             default="No first name given" --%>
<%--                      /> &gt; --%>
<%-- 	last name: <c:out value="${param.last}" /> --%>
    first name: ${param.first}
	last name: ${param.last}
</body>
</html>