<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HTTP API测试</title>
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="width=device-width, initial-scale=1" name="viewport">
</head>
<body>
<spring:hasBindErrors name="account">
	<c:if test="${errors.fieldErrorCount > 0}">  
            字段错误：<br />
		<c:forEach items="${errors.fieldErrors}" var="error">
			<spring:message var="message" code="${error.code}"
				arguments="${error.arguments}" text="${error.defaultMessage}" />  
                ${error.field}------${message}<br />
		</c:forEach>
	</c:if>

	<c:if test="${errors.globalErrorCount > 0}">  
            全局错误：<br />
		<c:forEach items="${errors.globalErrors}" var="error">
			<spring:message var="message" code="${error.code}"
				arguments="${error.arguments}" text="${error.defaultMessage}" />
			<c:if test="${not empty message}">  
                    ${message}<br />
			</c:if>
		</c:forEach>
	</c:if>
</spring:hasBindErrors>
</body>
</html>

