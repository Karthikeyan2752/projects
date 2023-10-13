<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>	
<!DOCTYPE html>
<html>
<head>
    <title>User Details</title>
</head>
<body>
    <h1>User Details</h1>
    <table>
        <tr>
        	<th>ID</th>
            <th>Username</th>
            <th>Email</th>
        </tr>
        <s:iterator value="users">
            <tr>
            	 <td><s:property value="id" /></td>
                <td><s:property value="username" /></td>
                <td><s:property value="email" /></td>             
            </tr>
        </s:iterator>
    </table>
</body>
</html>
