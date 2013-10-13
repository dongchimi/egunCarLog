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
