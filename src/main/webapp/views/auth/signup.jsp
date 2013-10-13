<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" uri="http://kwonnam.pe.kr/jsp/template-inheritance" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<layout:extends name="base">
    <layout:put block="header" type="APPEND">
        <title>회원가입</title>
        <script type="text/javascript">
        $(document).ready(function() {
            $("#signup-form").on("submit", function() {
                var password1 = $("#password").val();
                var password2 = $("#egunUserPassword2").val();
                if (password1 != password2) {
                    $("#error-message").text("입력한 비밀번호가 다릅니다.").show().fadeOut(2000);
                    return false;
                }
                
                var emailAddress = $("#emailAddress").val();
                var name = $("#name").val();
                var user = {
                    'emailAddress' : emailAddress,
                    'name' : name,
                    'password' : password1
                };
                $.post('${ctx}/api/auth/signup', user, function(result) {
                        if (result.status = 'success') {
                            EgunUtility.goPage('${ctx}/' + name + "/car/1/unkeeps/month");
                        }
                });
                
                return false;
            });
        });
        </script>
    </layout:put>
    <layout:put block="body">
        <body>
          <h1>회원가입</h1>
          <form id="signup-form" role="form" method="post">
            <div class="form-group">
              <label for="emailAddress">이메일</label>
              <input type="email" class="form-control" id="emailAddress" name="emailAddress" placeholder="example@egun.org" />
            </div>
            <div class="form-group">
              <label for="name">이름</label>
              <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요.">
            </div>
            <div class="form-group">
              <label for="password">비밀번호 <span id="error-message" class="form-group"></span></label>
              <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력해주세요.">
              <label for="egunUserPassword2">비밀번호 확인</label>
              <input type="password" class="form-control" id="egunUserPassword2" placeholder="비밀번호를 다시한번 입력해주세요.">
            </div>
            
            <button id="button-signup" class="btn btn-lg btn-primary">회원가입</button>
            <a href="${ctx}/" class="btn btn-lg btn-default">취소</a>
          </form>
          </body>        
    </layout:put>
</layout:extends>
