app.controller("product-ctrl", function ($scope, $http) {
	
    $scope.products = [];
    $scope.form = {};
	$scope.category = [];

    $scope.initialize = () => {
	
        $http.get("http://localhost:9998/rest/products").then(response => {
            $scope.products = response.data;
            
        });
		
		$http.get("http://localhost:9998/rest/category").then(response =>{
			$scope.category = response.data;
			console.log($scope.category);
		});
    }

    $scope.initialize();

    $scope.edit = (item) => {
       	$scope.form = item;
    }

	$scope.create = () => {
		var item = angular.copy($scope.form);
		console.log(item);
		$http.put("/rest/update", item).then(resp =>{
			
		});
	}
	
	
	
});