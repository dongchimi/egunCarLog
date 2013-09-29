<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" uri="http://kwonnam.pe.kr/jsp/template-inheritance" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" /> 
<layout:extends name="base">
<layout:put block="header" type="APPEND">
<title>회원가입</title>
<script type="text/javascript">
</script>
</layout:put>
<layout:put block="body">
<table class="table">
    <thead>
        <tr>
            <th></th>
            <th>날짜</th>
            <th>내용</th>
            <th>가격</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>2013.10.10</td>
            <td>용문주유소</td>
            <td>100000</td>
        </tr>
    </tbody>
</table>
</layout:put>
</layout:extends>