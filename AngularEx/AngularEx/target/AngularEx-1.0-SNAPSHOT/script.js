var app = angular.module("usersApp", ["ngRoute"]);
app.config(function ($routeProvider) {
    $routeProvider
            .when("/:id", {
                templateUrl: "showDetails.html"
            });

});

var users = [];
app.controller("UserController", function ($http, $routeParams) {
    var self = this;
    if (users.length === 0) {
        $http.get("data.json").success(function (data) {
            users = data.users;
            self.users = users;
        });
    } else { //We used the cache property on the http request instead
        self.users = users;
    }
    if (users !== null) {
        console.log("Adding user: " + $routeParams.id);
        self.user = users[$routeParams.id];
    }
});
