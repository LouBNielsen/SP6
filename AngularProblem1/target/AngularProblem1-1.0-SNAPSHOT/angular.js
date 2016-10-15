var app = angular.module('myApp', ['ngRoute']);

app.config(function ($routeProvider) {
    $routeProvider
            .when("/#", {
                templateUrl: "index.html"
            });
    $routeProvider
            .when("/allPersons", {
                templateUrl: "template1.html"
            });
    $routeProvider
            .when("/newPerson", {
                templateUrl: "template2.html"
            });
    $routeProvider
            .when("/:id", {
                templateUrl: "details.html",
                controller: 'personController'
            });
});

var persons = [
    {id: 1, name: "Jens", age: 18}
    , {id: 2, name: "Peter", age: 23}
    , {id: 3, name: "Hanne", age: 23}
];

app.controller('personController', function () {
    var self = this;
    self.indexNumber = 0;
    self.persons = persons;

    self.person = {};
    self.addPerson = function () {
        self.persons.push(self.person);
        console.log("YAZ");
        self.addPerson = {};
    };


});

