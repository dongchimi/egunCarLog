<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" uri="http://kwonnam.pe.kr/jsp/template-inheritance" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<layout:extends name="base">
  <layout:put block="header" type="APPEND">
    <title>이건 차계부</title>
    <script type="text/javascript">
    $(document).ready(function() {
        $("#signin-form").on("submit", function() {
          var emailAddress = $.trim($("#emailAddress").val());
          var password = $.trim($("#password").val());
          
          if (emailAddress.length < 1) {
            alert("이메일 또는 이름을 입력하세요.");
            return $("#emailAddress").focus();s
          }
          if (password.length < 1) {
            alert("비밀번호를 입력하세요.");
            return $("#password").focus();
          }
          
          var user = {
            'emailAddress' : emailAddress,
            'password' : password
          };
          EgunUtility.doPost ('${ctx}/api/auth/signin', user, function(responseData) {
            var signinUserName = responseData.user.name;
            EgunUtility.goPage('${ctx}/' + signinUserName + "/car/1/unkeeps/month");
          });
            
          return false;
        });
    });
    </script>
  </layout:put>
  <layout:put block="body">
<div class="jumbotron">
  <div class="container">
    <h1>먼저, 로그인하세요.</h1>
    <form role="form" method="post" id="signin-form">
      <div class="form-group" >
        <label for="nameOrEmail">이메일</label>
        <input type="text" class="form-control" id="emailAddress" name="emailAddress" placeholder="이메일 또는 이름을 입력하세요.">
      </div>
      <div class="form-group">
        <label for="egunUserPassword">비밀번호</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호">
      </div>
      <div class="checkbox">
        <label><input type="checkbox">Remember me</label>
      </div>
      <button type="submit" class="btn btn-lg btn-primary">로그인</button>
      <a href="${ctx}/auth/signup" class="btn btn-default btn-lg">회원가입</a>
    </form>
  </div>
</div>

    
    
  </layout:put>
</layout:extends>
