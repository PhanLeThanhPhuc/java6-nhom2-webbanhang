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

			console.log(id);
			$.toast({
			text : "Thêm vào giỏ hàng thành công.", // Text that is to be shown in the toast
			heading : 'Thông báo!', // Optional heading to be shown on the toast
			icon : 'success', // Type of toast icon
			showHideTransition : 'fade', // fade, slide or plain
			allowToastClose : true, // Boolean value true or false
			hideAfter : 3000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
			stack : false, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
			position : 'top-right', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values
			textAlign : 'left', // Text alignment i.e. left, right or center
			loader : true, // Whether to show loader or not. True by default
			loaderBg : '#9EC600', // Background color of the toast loader
			beforeShow : function() {
			}, // will be triggered before the toast is shown
			afterShown : function() {
			}, // will be triggered after the toat has been shown
			beforeHide : function() {
			}, // will be triggered before the toast gets hidden
			afterHidden : function() {
			} // will be triggered after the toast has been hidden
		});

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
			payment: "1",
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
					console.log(resp.data);
					//$cart.clear();
					//location.href = resp.data.url;
					location.href = "/payment?payment="+resp.data.data.payment+"&total="+resp.data.data.total+"&id="+resp.data.data.id;
					//console.log(resp.data.data.payment);
					console.log(resp.data.data.id);
				}).catch(error => {
					alert("Đặt hàng lỗi!")
					console.log(error)
				})
			}
	}
	

	
})