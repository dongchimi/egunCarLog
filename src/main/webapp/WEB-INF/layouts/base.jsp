<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html>
<html lang="en">
<head>
    <layout:block name="header" >        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap -->
        <link href="${ctx}/style/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="${ctx}/style/js/bootstrap.min.js"></script>
        <script src="${ctx}/style/js/respond.min.js"></script> 
    </layout:block>
</head>    
<layout:block name="body">
    <body />
</layout:block>
</html>