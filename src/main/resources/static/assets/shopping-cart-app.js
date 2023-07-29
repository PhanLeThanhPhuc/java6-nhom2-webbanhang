const app = angular.module("shopping-cart-app",[]);

app.controller("shopping-cart-ctrl",function($scope,$http){
	
	
	
	$scope.cart={
		
		product:[],
		
		add(id){
			var productDetail = this.product.find(productDetail => productDetail.id == id);
			if(productDetail){
				productDetail.qty++;
				this.saveToLocalStorage();
				console.log('product da co sp',this.product);
			}else{
				$http.get(`/rest/products/${id}`).then(resp => {
					resp.data.qty = 1;
					this.product.push(resp.data);
					this.saveToLocalStorage();
					console.log('product chua co sp',this.product);
				})
			}
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
			.map(productd => productd.qty * productd.price)
			.reduce((total,qty) => total += qty,0)
		},
		
		saveToLocalStorage(){
			var json = JSON.stringify(angular.copy(this.product));
			localStorage.setItem("cart",json);
		},
		
		loadFromLocalStorage(){
			var json = localStorage.getItem("cart");
			this.product = json ? JSON.parse(json): [];
			console.log('load',this.product);
		}
	}
	
	
	
	$scope.cart.loadFromLocalStorage();
	
	$scope.order = {
			//get account(){
			//	return {username: $auth.user.username}
			//},
			date: new Date(),
			province: "",
			district: "",
			ward: "",
			status: 'X',
			total: $scope.cart.amount,
			get orderDetails(){
				return $scope.cart.product.map(productDetail => {
					return {
						product:{id: productDetail.id},
						price: productDetail.price,
						quantity: productDetail.qty,
						total: productDetail.price * productDetail.qty
					}
				});
			},
			
			
			purchase(){
				console.log('KKKKK');
				var order = angular.copy(this);
				console.log(order);
				// Thực hiện đặt hàng
				$http.post("/rest/orders", order).then(resp => {
					alert("Đặt hàng thành công!");
					$cart.clear();
					location.href = "/order/detail/" + resp.data.id;
				}).catch(error => {
					alert("Đặt hàng lỗi!")
					console.log(error)
				})
			}
	}
	

	
})