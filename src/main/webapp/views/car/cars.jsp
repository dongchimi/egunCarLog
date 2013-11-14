<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" uri="http://kwonnam.pe.kr/jsp/template-inheritance" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="signinUser" value="${signinUser}" scope="session"/>
<layout:extends name="base">
<layout:put block="header" type="APPEND">
  <title>내차목록</title>
  <script type="text/javascript">
    $(document).ready(function(){
      $("#newCar").click(function() {
        EgunUtility.goPage('${ctx}/${signinUser.name}/cars/new');
      });
      
      loadCars();
    });
    
    var loadCars = function() {
      $("#cars tr").remove();
      EgunUtility.doGet('${ctx}/api/car/list', '', function(responseData) {
        var cars = responseData.cars;
        if (cars.length < 1) return;
        
        var currentCarId = '${signinUser.currentCarId}';
        var $carTr = $('#cars');
        for(var idx = 0; idx < cars.length; idx++) {
          var car = cars[idx];
          var rowIndex = idx + 1;
          
          var selectedClassName = '';
          if (currentCarId == car.objectId) {
            selectedClassName = 'class="active"';
          }
          
          var tr = '<tr data-carid = ' + car.objectId + ' ' + selectedClassName+'>'
                + '<td>' + rowIndex + '</td>'
                + '<td>' + car.alias + '</td>'
                + '<td>' + car.automaker + '</td>'
                + '<td>' + car.modelName + '</td>'
                + '<td>' + car.makeYear + '</td>'
                + '<td>' + car.odometer + '</td>'
                + '<td>' + car.buyDate + '</td>'
                + '<td>' + car.carNumber + '</td>'
                + '<td>' + car.vin + '</td>'
                + '<td>' + car.memo + '</td>'
                + '<td><div class="btn-group"><button type="button" class="btn btn-default" name="modify-car" data-carid=' + car.objectId + '>수정</button><button type="button" class="btn btn-default" name="delete-car" data-carid=' + car.objectId + '>삭제</button></div>'
                + '</tr>';  
          $carTr.append(tr);
        }
        
        // 차 선택시 호출
        $("#cars tr").on('click', function(event) {
          var carObjectId = $(event.currentTarget).data('carid');
          selectCar(carObjectId);
        });
        
        // 수정 요청
        $("#cars tr [name=modify-car]").on('click', function(event) {
          event.stopPropagation();
          var carOid = $(event.target).data('carid');
          EgunUtility.goPage('${ctx}/${signinUser.name}/cars/modify/' + carOid);
        });
        
        // 삭제 요청
        $("#cars tr [name=delete-car]").on('click', function(event) {
          event.stopPropagation();
          var carId = $(event.target).data('carid');
          if (confirm('삭제하시겠습니까?') == true) {
            EgunUtility.doDelete('${ctx}/api/car/delete/' + carId, '', function(response) {
              alert('삭제를 완료하였습니다.');
              
              // 재조회
              loadCars();
            });
          }
        });
      });
      
      var selectCar = function(carId) {
        EgunUtility.doPost('${ctx}/api/car/selectcar/' + carId, '', function() {
          EgunUtility.goPage('${ctx}/${signinUser.name}/car/' + carId + '/unkeeps/month');
        });
      };
    };
  </script>
</layout:put>
<layout:put block="body">
  <div class="pull-right">
    <button type="button" class="btn btn-lg btn-primary" id="newCar">
      <span class="glyphicon glyphicon-edit"></span> New
    </button>  
  </div>
  <table class="table table-hover">
      <thead>
          <tr>
              <th>선택</th>
              <th>별칭</th>
              <th>제조사</th>
              <th>모델</th>
              <th>제조년도</th>
              <th>누적거리</th>
              <th>구입일</th>
              <th>자동차번호</th>
              <th>차대번호</th>
              <th>메모</th>
              <th></th>
          </tr>
      </thead>
      <tbody id='cars' />
  </table>
</layout:put>
</layout:extends>