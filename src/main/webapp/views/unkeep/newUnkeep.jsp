<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" uri="http://kwonnam.pe.kr/jsp/template-inheritance" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="signinUser" value="${signinUser}" scope="session"/>
<layout:extends name="base">
    <layout:put block="header" type="APPEND">
        <title>새로작성</title>
        <script type="text/javascript">
        $(document).ready(function() {
            $("#unkeep-form").on('submit', function() {
              var unkeepItem = {
                'unkeepType' : $("[name=unkeepType]:checked").val(),
                'useDate' : $("#useDate").val(),
                'itemName' : $("#itemName").val(),
                'currentOdometer' : $("#currentOdometer").val(),
                'unkeepPrice' : $("#unkeepPrice").val()
              };
              var priceOfLiter = $("#priceOfLiter").val();
              if ( $.trim(priceOfLiter).length > 0 ) {
                unkeepItem.gas = {
                  'priceOfLiter' : priceOfLiter
                };
              }
              
              EgunUtility.doPost('${ctx}/api/unkeep/new', unkeepItem, function() {
                EgunUtility.goPage('${ctx}/${signinUser.name}/car/${signinUser.currentCarId}/unkeeps/month');
              });
              return false;
            });
            
          $("#unkeepTypeDiv").on('click', function(event) {
            if ( $(event.target).find('input').val() == 'gas' ) {
              $("#priceOfLiterDiv").show();
            } else {
              $("#priceOfLiterDiv").hide();
            }
          });
        });
        </script>
    </layout:put>
    <layout:put block="body">
        <body>
          <h1></h1>
          <form id="unkeep-form" role="form" method="post">
            <div class="btn-group" data-toggle="buttons" id="unkeepTypeDiv">
              <label class="btn btn-primary"><input type="radio" name="unkeepType" id="gas" value="gas"> 주유</label>
              <label class="btn btn-primary"><input type="radio" name="unkeepType" id="repare" value="repare"> 정비</label>
              <label class="btn btn-primary"><input type="radio" name="unkeepType" id="expendable" value="expendable"> 소모품</label>
            </div>
            <div class="form-group">
              <label for="password">현재까지주행거리</label>
              <input type="text" class="form-control" id="currentOdometer" name="currentOdometer" placeholder="">
            </div>
            <div class="form-group">
              <label for="name">날짜</label>
              <input type="text" class="form-control" id="useDate" name="useDate" placeholder="20131231">
            </div>
            <div class="form-group">
              <label for="password">내용</label>
              <input type="text" class="form-control" id="itemName" name="itemName" placeholder="내용을입력하세요.">
            </div>
            <div class="form-group">
              <label for="password">비용</label>
              <input type="number" class="form-control" id="unkeepPrice" name="unkeepPrice" placeholder="30000">
            </div>
            <div class="form-group" id="priceOfLiterDiv">
              <label for="password">리터당비용</label>
              <input type="number" class="form-control" id="priceOfLiter" name="priceOfLiter" placeholder="1950">
            </div>
             <div class="form-group">
              <label for="password">메모</label>
              <input type="text" class="form-control" id="description" name="description" placeholder="">
            </div>
            
            <button id="button-signup" class="btn btn-lg btn-primary">저장</button>
            <a href="${ctx}/" class="btn btn-lg btn-default">취소</a>
          </form>
          </body>        
    </layout:put>
</layout:extends>
