<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" uri="http://kwonnam.pe.kr/jsp/template-inheritance" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="signinUser" value="${signinUser}" scope="session"/>

<layout:extends name="base">
    <layout:put block="header" type="APPEND">
        <title></title>
        <script type="text/javascript">
        $(document).ready(function() {
            
          var carObjectId = '${carOid}';
          // 수정 
          if (($.trim(carObjectId)) > 0) {
            EgunUtility.doGet('${ctx}/api/car/get/' + carObjectId, '', function (responseData) {
              var car = responseData.car;
              console.log(car);
              
              if (car != null) {
                $("#alias").val(car.alias);
                $("#modelName").val(car.modelName);
                $("#automaker").val(car.automaker);
                $("#odometer").val(car.odometer);
                $("#makeYear").val(car.makeYear);
                $("#buyDate").val(car.buyDate);
                $("#carNumber").val(car.carNumber);
                $("#vin").val(car.vin);
                $("#memo").val(car.memo);
              }
            });
          }
          // 신규
          else {
          }
          
          // 저장
          $("#car-form").on("submit", function() {
            var egunCar = {
              userEmailAddress : '${signinUser.emailAddress}',
              alias : $("#alias").val(),
              modelName : $("#modelName").val(),
              odometer : $("#odometer").val(),
              automaker : $("#automaker").val(),
              makeYear : $("#makeYear").val(),
              buyDate : $("#buyDate").val(),
              carNumber : $("#carNumber").val(),
              vin : $("#vin").val(),
              memo : $("#memo").val()
            };
            
            if (($.trim(carObjectId)) > 0) {
              egunCar.objectId = carObjectId;
              EgunUtility.doPost('${ctx}/api/car/modify', egunCar, function() {
                EgunUtility.goPage('${ctx}/${signinUser.name}/cars/list');
              });
            }
            else {
              EgunUtility.doPost('${ctx}/api/car/new', egunCar, function() {
                EgunUtility.goPage('${ctx}/${signinUser.name}/cars/list');
              });
            }
            
            return false;
          });
            
        });
        </script>
    </layout:put>
    <layout:put block="body">
        <body>
          <h1></h1>
          <form id="car-form" role="form" method="post">
            <div class="form-group">
              <label for="name">별칭</label>
              <input type="text" class="form-control" id="alias" name="alias" placeholder="">
            </div>
            <div class="form-group">
              <label for="name">제조사</label>
              <input type="text" class="form-control" id="automaker" name="automaker" placeholder="">
            </div>
            <div class="form-group">
              <label for="name">모델</label>
              <input type="text" class="form-control" id="modelName" name="modelName" placeholder="">
            </div>
            <div class="form-group">
              <label for="name">제조년도</label>
              <input type="text" class="form-control" id="makeYear" name="makeYear" placeholder="">
            </div>
            <div class="form-group">
              <label for="name">누적주행거리</label>
              <input type="text" class="form-control" id="odometer" name="odometer" placeholder="">
            </div>
            <div class="form-group">
              <label for="name">구입일</label>
              <input type="text" class="form-control" id="buyDate" name="buyDate" placeholder="">
            </div>
            <div class="form-group">
              <label for="name">자동차번호</label>
              <input type="text" class="form-control" id="carNumber" name="carNumber" placeholder="">
            </div>
            <div class="form-group">
              <label for="name">차대번호</label>
              <input type="text" class="form-control" id="vin" name="vin" placeholder="">
            </div>
            <div class="form-group">
              <label for="name">메모</label>
              <input type="text" class="form-control" id="memo" name="memo" placeholder="">
            </div>
            <button id="button-signup" class="btn btn-lg btn-primary">저장</button>
            <a href="${ctx}/${signinUser.name}/cars/list" class="btn btn-lg btn-default">취소</a>
          </form>
          </body>        
    </layout:put>
</layout:extends>
