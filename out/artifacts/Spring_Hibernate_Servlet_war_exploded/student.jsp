<%@ page import="com.HibernateSpringServlet.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Students</title>
</head>
<body>

<% final List<Student> students = (List<Student>) request.getAttribute("students"); %>

<h1>All Students</h1>

<table>
    <% for (Student s : students) {%>
    <tr>
        <td><%= s.getId() %>
        </td>
        <td><%= s.getName() %>
        </td>
        <td><%= s.getDateOfBirth() %>
        </td>
    </tr>
    <% } %>
</table>

<h3>Add new student</h3>
<form method="post">
    <label>
        First name:
        <input type="text" name="firstName"/>
    </label>
    <label>
        Last Name:
        <input type="text" name="lastName"/>
    </label>
    <input type="submit"/>
</form>

</body>
</html>