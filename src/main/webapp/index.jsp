<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<html>
<body>
<h2>Login</h2>
<c:choose>
    <c:when test="${empty userName}">
        <a href = "logIn">Log in</a>
    </c:when>
    <c:otherwise>
        <h3>Welcome ${userName}</h3>
    </c:otherwise>
</c:choose>

<h2>User Display Exercise</h2>
<p>
<form method="GET" action="searchUser" >
    <label for="searchTerm">Search for employee:</label><br>
    <input type="text" id="searchTerm" name="searchParam"><br><br><!--
    <input type="radio" id="searchType" name="typeParam" value="ID">
    <label for="searchType">ID</label><br>
    <input type="radio" id="searchType" name="typeParam" value="firstName">
    <label for="searchType">First Name</label><br>
    <input type="radio" id="searchType" name="typeParam" value="lastName">
    <label for="searchType">Last Name</label><br><br> -->
    <button type="submit" name="submit" value="search">Search</button>
    <button type="submit" name="submit" value="searchAll">Search All</button>
</form></p>
</body>
</html>