/**
 * The controller file for front end
 */
var app = angular.module('app', []);
app.controller('postListcontroller', function($scope, $http, $location) {
	  $scope.submitListForm = function(){
	    var url = $location.absUrl() + "postListMessageForUser";
	    
	    var config = {
	                headers : {
	                    'Accept': 'text/plain'
	                }
	        }
	    var data = {
	    		inputMessageList: $scope.messages,
	    		firstName:$scope.firstname,
	    		lastName:$scope.lastname
	        };
	    
	    $http.post(url, data, config).then(function (response) {
	      $scope.postResultMessage = response.data;
	    }, function error(response) {
	      $scope.postResultMessage = "Error with status: " +  response.statusText;
	    });
	    
	    $scope.inputMessageList = [];
	  }
	});
app.controller('getcontroller', function($scope, $http, $location) {
	  $scope.getfunction = function(){
	    var url = $location.absUrl() + "getAllMessages";
	    
	    $http.get(url).then(function (response) {
	      $scope.response = response.data
	    }, function error(response) {
	      $scope.postResultMessage = "Error with status: " +  response.statusText;
	    });
	  }
	});
app.controller('postCommentController', function($scope, $attrs, $http, $location) {
	  $scope.postComment = function(){
	    var postId = $attrs.post;
	    var config = {
	                headers : {
	                    'Accept': 'text/plain'
	                }
	        }
	    var data = {
	    		commentString: $scope.comment,
	    		postId: postId
	        };

	    var url = $location.absUrl() + "postComment";
	     $http.post(url, data, config).then(function (response) {
	     
	      $scope.postResultMessage = response.data;
	    }, function error(response) {
	      $scope.postResultMessage = "Error with status: " +  response.statusText;
	    });
	    
	    $scope.commentString = "";
	  }
	});
