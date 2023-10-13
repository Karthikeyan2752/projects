<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
</head>
<body>
    <h1>Error</h1>
    <p>An error occurred during the registration process:</p>
    <p><s:property value="actionErrors" /></p>
    
    <p><a href="<s:url action='register' />">Back to Registration</a></p>
</body>
</html>
