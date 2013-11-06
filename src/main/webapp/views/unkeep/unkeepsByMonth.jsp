<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" uri="http://kwonnam.pe.kr/jsp/template-inheritance" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="signinUser" value="${signinUser}" scope="session"/>
<layout:extends name="base">
<layout:put block="header" type="APPEND">
  <title>회원가입</title>
  <script type="text/javascript">
    $(document).ready(function(){
      $("#newUnkeep").click(function() {
        EgunUtility.goPage('${ctx}/${signinUser.name}/car/1/unkeeps/new');
      });
      $("#cars").click(function() {
        EgunUtility.goPage('${ctx}/${signinUser.name}/cars/list');
      });
      
      loadUnkeeps();
    });
    
    var loadUnkeeps = function() {
      EgunUtility.doGet('${ctx}/api/unkeep/list', '', function(responseData) {
        var unkeepItems = responseData.unkeepItems;
        if (unkeepItems.length < 1) return;
        
        var $unkeepItemsTr = $('#unkeepItems');
        for(var idx = 0; idx < unkeepItems.length; idx++) {
          var unkeepItem = unkeepItems[idx];
          var rowIndex = idx + 1;
          
          var tr = '<tr>'
                + '<td>' + rowIndex + '</td>'
                + '<td>' + unkeepItem.useDate + '</td>'
                + '<td>' + unkeepItem.itemName + '</td>'
                + '<td>' + unkeepItem.unkeepPrice + '</td>'
                + '<td><div class="btn-group"><button type="button" class="btn btn-default">수정</button><button type="button" class="btn btn-default">삭제</button></div>'          
                + '</tr>';
          $unkeepItemsTr.append(tr);
        }
      });
    };
  </script>
</layout:put>
<layout:put block="body">
  <div class="pull-left">
    <button type="button" class="btn btn-default btn-lg" id="cars">
        <span class="glyphicon glyphicon-wrench"></span> Cars
    </button>  
  </div>
  <div class="pull-right">
    <button type="button" class="btn btn-lg btn-primary" id="newUnkeep">
      <span class="glyphicon glyphicon-edit"></span> New
    </button>  
  </div>
  <table class="table">
      <thead>
          <tr>
              <th></th>
              <th>날짜</th>
              <th>내용</th>
              <th>가격</th>
              <th></th>
          </tr>
      </thead>
      <tbody id='unkeepItems' />
  </table>
</layout:put>
</layout:extends>