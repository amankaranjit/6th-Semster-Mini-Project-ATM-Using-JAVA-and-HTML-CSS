<%-- 
    Document   : userList
    Created on : Feb 9, 2022, 7:11:45 AM
    Author     : yubaraj
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sajan" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
        <style>
            .odd{
                background-color: #99ccff;
            }
            .even{
                background-color: #ffcccc;
            }
        </style>
    </head>
    <body>
        <h1>User List</h1>
        <table>
            <tr>
                <th>SN</th>
                <th>Full Name</th>
                <th>Address</th>
                <th>Action</th>
            </tr>
            <sajan:forEach var="user" items="${userList}" varStatus="loop">
                <tr class="${loop.index % 2 == 0 ? 'even' : 'odd'}">
                    <td><sajan:out value="${loop.index+1}"/></td>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.address}</td>
                <td>
                    <a href="
                       
                       <sajan:url value="editUser.jsp">
                           <sajan:param name="id" value="${user.id}"/>
                       </sajan:url>
                       
                       ">Edit</a>
                    <a href="
                       <sajan:url value="deleteUser">
                           <sajan:param name="id" value="${user.id}"/>
                       </sajan:url>
                       ">Delete</a>
                </td>
            </tr>
            </sajan:forEach>
            
        </table>
    </body>
</html>