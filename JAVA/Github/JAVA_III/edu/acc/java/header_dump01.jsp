<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- Show me the money --> ${money} --%>
<br>SHow me x[0] key --> ${x[0].key}
<br>SHow me x[0] value --> ${x[0].value}
<br>SHow me x[1] key --> ${x[1].key}
<br>SHow me x[1] value --> ${x[1].value}

<p>the painful way...find and print just the cookie header with &lt;c:if&gt; 

<c:if test="${x[0].key == 'cookie'}">
  <h3>${x[0].key} = ${x[0].value}</h3>
</c:if>

<c:if test="${x[1].key == 'cookie'}">
  <h3>${x[1].key} = ${x[1].value}</h3>
</c:if>

<c:if test="${x[2].key == 'cookie'}">
  <h3>${x[2].key} = ${x[2].value}</h3>
</c:if>

<c:if test="${x[3].key == 'cookie'}">
  <h3>${x[3].key} = ${x[3].value}</h3>
</c:if>

<c:if test="${x[4].key == 'cookie'}">
  <h3>${x[4].key} = ${x[4].value}</h3>
</c:if>

<%-- are we there yet? --%>
<c:if test="${x[5].key == 'cookie'}">
  <h3>${x[5].key} = ${x[5].value}</h3>
</c:if>

</body>
</html>