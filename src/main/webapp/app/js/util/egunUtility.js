'use strict';

var EgunUtility = {};

EgunUtility.doPost = function (url, paramObj, callback) {
  $.post(url, paramObj, function (response) {
    if (EgunUtility.isSuccessResponse(response)) {
      if (EgunUtility.hasResponseData(response)) {
        callback(response.data);
      }
      else {
        if (callback != undefined && callback != null) {
          callback();
        }
      }
    }
    return EgunUtility.showfailMessage(response);
  });
};
         
EgunUtility.doGet = function (url, paramObj, callback) {
  $.get(url, paramObj, function (response) {
    if (EgunUtility.isSuccessResponse(response)) {
      if (EgunUtility.hasResponseData(response)) {
        callback(response.data);
      }
    }
    return EgunUtility.showfailMessage(response);
  });
};
         
EgunUtility.isSuccessResponse = function (response) {
    return response.status === "success";
};

EgunUtility.hasResponseData = function(response) {
    return response.data != undefined && response.data != null;
}
EgunUtility.goPage = function (nextPageUrl) {
    document.location.href = nextPageUrl;
};

EgunUtility.showfailMessage = function(response) {
  if (response.status != "fail") return;
  
  alert(response.message);
}

//var EgunCar = {
//  var objectId = '';
//  var userEmailAddress = '';
//  var alias = '';
//  var modelName = '';
//  var automaker = '';
//  var makeYear = '';
//  var buyDate = '';
//  var carNumber = '';
//  var vin = '';
//  var memo = '';
//};
//

//var EgunCar = {};
//EgunCar.prototype.objectId = '';
//EgunCar.prototype.userEmailAddress = '';
//EgunCar.prototype.alias = '';
//EgunCar.prototype.modelName = '';
//EgunCar.prototype.automaker = '';
//EgunCar.prototype.makeYear = '';
//EgunCar.prototype.buyDate = '';
//EgunCar.prototype.carNumber = '';
//EgunCar.prototype.vin = '';
//EgunCar.prototype.memo = '';