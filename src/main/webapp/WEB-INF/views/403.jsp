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
  height: 280px;
  margin: auto;
}
.outer {
  display: table;
  position: absolute;
  top: 0;
  left: 0;
  height: 100%;
  width: 100%;
}
.middle {
  display: table-cell;
  vertical-align: middle;
}

</style>
<html>
	<head>
		<meta charset="utf-8">
		<title>403 - Access forbidden</title>
	</head>
	<body>
    <div class="outer">
        <div class="middle">
            <div id="rcorners1">
                <div style="text-align:center" >
                    <img src="img/403.png">
                </div>
            </div>
        </div>
    </div>
	</body>
</html>