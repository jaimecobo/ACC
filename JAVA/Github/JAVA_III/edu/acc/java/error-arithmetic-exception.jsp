<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Arithmetic Exception</title>
</head>
<body>
<div style="margin:5%; padding:10px; border: 1px solid red">
  <h3>Sorry, an application error has occurred. 
      <br><br>The system administrator has been emailed while on her well-deserved 
      vacation in Bali to review your mistake.
      <p>Have a nice day :)
  </h3>
</div>

</body>
</html>
<% // optional demo of scriptlet (embedded Java code)
   // no longer best practice but you may see it in the wild
   // see console to view debug info 
   Exception ex = pageContext.getException();
   String msg = "\n*** Arithmetic Exception ***"; 
   msg += "\nMESSAGE: " + ex.getMessage();
   msg += "\nTRACE FOLLOWS:";
   StackTraceElement[] trace = ex.getStackTrace();
   for (StackTraceElement el : trace) {
	   msg += "\n" + el.toString();
   }
   msg += "\n";
   this.log(msg); 
%>