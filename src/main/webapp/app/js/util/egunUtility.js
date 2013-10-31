'use strict';

var EgunUtility = {};

EgunUtility.isSuccessResponse = function (response) {
    return response.status === "success";
};

EgunUtility.getResponseSingleData = function (response) {
    return response.data[0];
};

EgunUtility.goPage = function (nextPageUrl) {
    document.location.href = nextPageUrl;
};

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