<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style>
body {
  padding: 0;
  margin: 0;
  background: #585858;
}

*{ padding:0; margin:0;}

.login-card {

  width: 400px;
  background-color: #7E7E7E;
  margin: 0px auto ;
  border-radius: 9px;
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  min-height:440px;

}

.log_head{ background:#212934; width:400px; height:120px; border-radius:9px 9px 0 0px; }

.login-card h1 {
  text-align: center;
  font-family:open Sans;
  color:#FFFFFF;
  font-weight:700px;
  font-size:20px;
  line-height:27px;
  padding-top: 24px;

}

.lock{ padding-left:181px; width:30px; height:37px; padding-top:10px;}

.log_body{ padding:40px 20px 20px 20px;}

.log_user{ background:#FEFEFE; color:#999999; border-radius: 10px; width:349px; height:31px; padding:5px; font-family:open Sans; font-weight:700px; font-size:15px; border:none; }

.log_Pass{background:#FEFEFE; color:#999999; border-radius: 10px; width:349px; height:31px; padding:5px; font-family:open Sans; font-weight:700px; font-size:15px; border:none;}


.login-submit{ background:#212934; border:none; border-radius: 10px; width:359px; height:36px; cursor:pointer; font-family: "Courier New", Courier, monospace; font-weight:700px; font-size:20px; color:#FFFFFF; }

.log_body a{ text-decoration:none; color:#78EEB2; font-family:open Sans; font-weight:900px; font-size:15px; line-height:21px;}


.p_login {
  font-family: "Courier New", Courier, monospace;
  text-align: center;
  color:#FFFFFF;
  font-size:30px;
}
</style>
</head>

<body>
<br />
<br />

<div class="login-card">
<div class="log_head">
<p class="p_login">LOGIN</p>
<img src="/img/lock.png" alt="lock" class="lock" />
</div>

<div class="log_body">
<form name='f' action="loginPage" method='POST'>
 <table width="200" border="0" align="center">
  <tr>
    <td><input value="User Name" type="text" name="username" class="log_user" ></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><input value="Password" type="password" name="password" class="log_Pass"></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><input name="remember-me" type="checkbox" value="Remember Me"> Keep me logged in</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><input type="submit" name="login" class="login-submit" value="SIGN IN"></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <c:if test="${not empty loginMessage}">
      <div>
          <tr>
            <td>${loginMessage}</td>
          </tr>
      </div>
  </c:if>
  <tr>
    <td>&nbsp;</td>
  </tr>

</table>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</div>

</div>
</body>
</html>
