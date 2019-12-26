<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<style>
body {
  padding: 0;
  margin: 0;
  background: #585858;
}
#rcorners1 {
  border-radius: 25px;
  background: #212934;
  padding: 20px;
  width: 1000px;
  height: 350px;
  margin: auto;
}

</style>
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome Page - Spring Authentication with DB</title>
	</head>
	<body>
        <div id="rcorners1">
            <div style="text-align:center" >
                <img src="img/welcome.png">
            </div>
            <div style="text-align:center" >
                <a href="/loginPage" var="messageUrl"> <img src="img/login.png"></a>
            </div>
        </div>
	</body>
</html>