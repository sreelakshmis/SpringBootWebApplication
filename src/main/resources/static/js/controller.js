/**
 * The controller file for front end
 */
var app = angular.module('app', []);
app.controller('postcontroller', function($scope, $http, $location) {
	  $scope.submitForm = function(){
	    var url = $location.absUrl() + "postMessage";
	    var config = {
	                headers : {
	                    'Accept': 'text/plain'
	                }
	        }
	    var data = {
	    		inputMessage: $scope.inputMessage
	        };
	    $http.post(url, data, config).then(function (response) {
	      $scope.postResultMessage = response.data;
	    }, function error(response) {
	      $scope.postResultMessage = "Error with status: " +  response.statusText;
	    });
	    $scope.inputMessage = "";
	  }
 });