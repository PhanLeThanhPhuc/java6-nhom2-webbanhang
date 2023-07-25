const app = angular.module("shopping-cart-app",[]);

app.controller("shopping-cart-ctrl",function($scope,$http){
	
	
	$scope.cart={
		product:[],
		add(id){
			var productDetail = this.product.find(productDetail => productDetail.id == id);
			if(productDetail){
				productDetail.qty++;
				this.saveToLocalStorage();
			}else{
				$http.get(`/rest/products/${id}`).then(resp => {
					resp.data.qty = 1;
					this.product.push(resp.data);
					this.saveToLocalStorage();
					console.log(resp.data);
				})
			}
			console.log(id);
		},
		remove(id){
			var index = this.product.findIndex(productDetail => productDetail.id == id);
			this.product.splice(index,1);
			this.saveToLocalStorage();
		},
		clear(){
			this.product=[];
			this.saveToLocalStorage();
		},
		amt_of(){},
		get count(){
			return this.product
			.map(productDetail => productDetail.qty)
			.reduce((total,qty) => total += qty,0)
		},
		get amount(){
			return this.product
			.map(productDetail => productDetail.qty * productDetail.price)
			.reduce((total,qty) => total += qty,0)
		},
		saveToLocalStorage(){
			var json = JSON.stringify(angular.copy(this.product));
			localStorage.setItem("cart",json);
		},
		loadFromLocalStorage(){
			var json = localStorage.getItem("cart");
			this.product = json ? JSON.parse(json): [];
		}
	}
	
	$scope.cart.loadFromLocalStorage();
	
})