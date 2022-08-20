<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<br>The east coast weather is ${regional_weather.eastCoast["noonWeather"]}
<br>The west coast weather is ${regional_weather.westCoast.eveningWeather}
<br>The real coast weather is ${regional_weather.realCoast.morningWeather}
</body>
</html>