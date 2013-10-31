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
      $.get('${ctx}/api/car/list', '', function(result) {
        if (result.status = 'success') {
            console.log(result);
          for(var idx = 0; idx < result.data.length; idx++) {
            var car = result.data[idx];
            var tr = '<tr>'
                  + '<td>' + idx + '</td>'
                  + '<td>' + car.alias + '</td>'
                  + '<td>' + car.automaker + '</td>'
                  + '<td>' + car.modelName + '</td>'
                  + '<td>' + car.makeYear + '</td>'
                  + '<td>' + car.buyDate + '</td>'
                  + '<td>' + car.carNumber + '</td>'
                  + '<td>' + car.vin + '</td>'
                  + '<td>' + car.memo + '</td>'
                  + '</tr>';
            $('#cars').append(tr);
          }
        }
      });
    };
  </script>
</layout:put>
<layout:put block="body">
  <div class="pull-right">
    <button type="button" class="btn btn-lg btn-primary" id="newCar">
      <span class="glyphicon glyphicon-edit"></span> New
    </button>  
  </div>
  <table class="table">
      <thead>
          <tr>
              <th>번호</th>
              <th>별칭</th>
              <th>제조사</th>
              <th>모델</th>
              <th>제조년도</th>
              <th>구입일</th>
              <th>자동차번호</th>
              <th>차대번호</th>
              <th>메모</th>
          </tr>
      </thead>
      <tbody id = 'cars' />
  </table>
</layout:put>
</layout:extends>