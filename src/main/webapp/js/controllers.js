function ClientListCtrl($scope, $http,$location) {
	$scope.query = '';
	$http.get('services/client/all').success(function(data) {
		$scope.clients = data;//.splice(0, 5);
	});
	
	$scope.ajouter = function () {
		$location.url('/client/edit/undefined');
	};
};

function ClientDetailCtrl($scope, $routeParams, $http,$location) {
	  $http.get('services/client/id/' + $routeParams.clientId).success(function(data) {
		    $scope.client = data;
	  });
	  
	  $scope.edit = function () {
		  $location.url('/client/edit/'+$scope.client.id);
	  };
};

function ClientEditCtrl($scope, $routeParams, $http,$location) {
	if($routeParams.clientId!='undefined') {
		$http.get('services/client/id/' + $routeParams.clientId).success(function(data) {
			$scope.client = data;
		});
	}
	
	$scope.save = function () {
		$http.post('services/client',$scope.client).success(function(data) {
			$scope.client = data;
			$location.url('/client/'+$scope.client.id);
		});	
	};
	
	$scope.efface = function () {
		$http.delete('services/client/'+$scope.client.id).success(function() {
			$scope.client = null;
			$location.url('/client');
		});	
	};
};
