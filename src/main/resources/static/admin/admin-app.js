app = angular.module("admin-app", ["ngRoute"]);
    app.config(function ($routeProvider) {
        $routeProvider
            .when("/home", { templateUrl: "/admin/home-admin.html" })
            .when("/product", { templateUrl: "/admin/product/product.html" , controller: "product-ctrl"})
            .when("/subjectlist", { templateUrl: "subjectlist.html", controller: "subjectlist" })
            .when("/login", { templateUrl: "login.html", controller: "login" })
            .when("/register", { templateUrl: "register.html", controller: "register" })
            .when("/forgotpassword", { templateUrl: "forgotpassword.html" })
            .when("/changepassword", { templateUrl: "changepassword.html" })
            .when("/accountInformation", { templateUrl: "accountInformation.html" })
            .when("/tracnghiem/:idMH/:tenMH", { templateUrl: "tracnghiem.html", controller: "tracnghiem" })
            .when("/learnthesubject/:idMH/:tenMH", { templateUrl: "learnthesubject.html", controller: "tracnghiem" })
            .otherwise({ templateUrl: "home.html" })
    });