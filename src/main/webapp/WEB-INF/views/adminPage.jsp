<!DOCTYPE html>
<html>
<head>
<style>
body {
  padding: 0;
  margin: 0;
  background: #585858;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #212934;
}

li {
  float: left;
}

li a, .dropbtn{
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-family: "Courier New", Courier, monospace;
}

li a:hover:not(.active) , .dropdown:hover {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}

li.dropdown {
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #212934;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
  color: white;
}

.dropdown-content a:hover {background-color: #f1f1f1;}

.dropdown:hover .dropdown-content {
  display: block;
}

#rcorners1 {
  border-radius: 25px;
  background: #212934;
  padding: 20px;
  width: 1000px;
  height: 400px;
  margin: auto;
  font-family: "Courier New", Courier, monospace;
  color: white;
}

</style>
</head>
<body>

<ul>
  <li><a href="/homePage">Home</a></li>
  <li><a href="/adminPage">Admin Page</a></li>
  <li><a href="/userPage">User Page</a></li>
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">User Details</a>
    <div class="dropdown-content">
      <a href="#">${userName}</a>
      <a href="#">${userLogin}</a>
      <hr>
		<c:url value="/logout" var="logoutUrl" />
        <form id="logout" action="/logout" method="POST" >
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
		    <a href="javascript:document.getElementById('logout').submit()">Logout</a>
		</c:if>
    </div>
  </li>
</ul>
   <br>
<br>
<div id="rcorners1">
    <center>Admin Page!</center>
    <center>-----------</center>
<br>
<br>
<h2>${message}</h2>
<br>
<br>
 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi facilisis eu arcu at dapibus. Nulla facilisi. Mauris sed quam non sapien congue sodales. Quisque sodales turpis vitae ex sagittis, vitae congue odio porta. Praesent bibendum venenatis tellus eget tincidunt. Vivamus ut libero mi. Maecenas vel porttitor lectus. Aliquam sed lobortis felis. Morbi nec arcu nulla. Sed interdum viverra massa, non imperdiet dolor laoreet quis.
<br>
<br>
Nulla facilisi. Suspendisse non est risus. Vivamus auctor gravida porttitor. Morbi scelerisque nulla in metus suscipit, nec volutpat metus commodo. In augue arcu, cursus sit amet placerat at, tincidunt varius lectus. Sed nunc lectus, varius quis pellentesque non, rhoncus vitae risus. Curabitur sollicitudin, sem sit amet pulvinar congue, magna lorem hendrerit elit, eget faucibus leo massa eget urna. Donec scelerisque arcu magna, placerat pretium ex tempus a. Nullam rutrum lorem lacus, nec dapibus felis gravida ut. Fusce velit quam, maximus eu nunc eget, vestibulum aliquet dui.
</div>
</body>
</html>
