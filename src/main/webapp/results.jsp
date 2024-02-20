<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />

<script type="text/javascript" class="init">
    $(document).ready( function () {
    $('#myTable').DataTable();
} );
</script>
<html><body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="myTable" class="display" cellspacing="0" width="100%">
        <thead>
            <th>Name</th>
            <th>Username</th>
            <th>Age</th>
            <th>Sessions</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.userName} </td>
                <td>${user.age}</td>
                <td><c:forEach var="session" items="${user.sessionList}">
                    ${session.sessionTitle}
                </c:forEach></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
