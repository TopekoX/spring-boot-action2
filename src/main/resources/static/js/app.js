/* global angular, gagal, sukses */

var myapp = angular.module("phoneapp", []);

myapp.controller('phonecontroller', function($scope) {
    $scope.phones = [
        "ucup@xx.com",
        "cmcmcm@kkdkdk.co",
        "kdkndkn@ddkkd.co"
    ];
    
    $scope.tambahphone = function() {
        if ($scope.email !== ""){
            $scope.phones.push($scope.email);
            $scope.email="";
        }        
    };
    
    $scope.hapusphone = function(x) {
        var lokasi = $scope.phones.indexOf(x);
        if (lokasi > -1){
            $scope.phones.splice(lokasi, 1);
        }
    };
});

myapp.controller('phonectl', function ($http, $scope) {
   $scope.dataphone = {};
   $scope.updatedataphone = function(){
       
       $http.get('/api/phone').then(sukses, gagal);
       
       function sukses(response){
           $scope.dataphone = response.data;
           console.log($scope.dataphone);
       }
       
       function gagal(response){
           console.log("error : " + response);
       }
   };
   $scope.updatedataphone();
   
   $scope.hapusdataphone = function (x) {
      $http.delete("/api/phone/" + x.id).then(sukses, gagal);
      function sukses(response) {
            console.log(response);  
            $scope.updatedataphone();
      };
      function gagal(response) {
          alert("error " + response);
          console.log(response);
      };
    };
    
    
    $scope.simpanphone = function () {
      $scope.datapersons = {
          "id" : 1, 
          "firstName" : "Ucup", 
          "lastName" : "Timposu", 
          "address" : "Jalan Kedondong Palu"};
      $scope.dataphones = {
          "phoneNumber" : $scope.phonenumbers,
          "modifiedDate" : $scope.dates,
          "persons" : $scope.datapersons
      };
      
      $http.post("/api/phone", $scope.dataphones).then(sukses, gagal);
      function sukses(response) {
            console.log(response);  
            $scope.updatedataphone();
            $scope.phonenumbers="";
            $scope.dates="";
      };
      function gagal(response) {
          alert("error " + response);
          console.log(response);
      };
    };
});