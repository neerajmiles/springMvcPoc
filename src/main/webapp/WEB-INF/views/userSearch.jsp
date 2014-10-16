<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="myApp">
<head>

<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Dashboard Search</title>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

 <!-- CSS  -->
 <link type="text/css" href="stylesheets/angular_css.css" />
 <link rel="stylesheet" type="text/css" href="http://angular-ui.github.com/ng-grid/css/ng-grid.css" />
 <link type="text/css" href="stylesheets/bootstrap.min.css" />
 
 <!-- Javascript  -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.2/angular.min.js"></script>
 <script type="text/javascript" src="http://angular-ui.github.com/ng-grid/lib/ng-grid.debug.js"></script>
        
<style lang="css">

.gridStyle {
	border: 1px solid rgb(212, 212, 212);
	width: 800px;
	height: 500px
}

</style>

<script language="javascript">
	 angular.module('myApp', [ 'ngGrid' ]);
	 function gridController($scope, $http,$location) {
         $scope.paramNm=getParameterByName("user");
         //alert(getParameterByName("user"));
         $http.get('/loginMvcApp/search?user='+getParameterByName("user")).
         success(function(data) {
           $scope.users = data;
         });
         $scope.gridOptions = {
                data: 'users',
                enableRowSelection: false,
                enableCellEditOnFocus: true,
                multiSelect: false,
               columnDefs: [
				{ field: 'username', displayName: 'User', enableCellEdit: false } ,
				{ field: 'id', displayName: 'ID', enableCellEdit: false },
				{ field: 'accountExpired', displayName: 'AccountExpired', enableCellEdit: false },
				{ field: 'accountLocked', displayName: 'AccountLocked', enableCellEdit: false },
				{ field: 'email', displayName: 'Email', enableCellEdit: false },
				{ field: 'enabled', displayName: 'Enabled', enableCellEdit: false }
               ]
              };
         }
	function getParameterByName(name) {
		name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
		var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), results = regex
				.exec(location.search);
		return results == null ? "" : decodeURIComponent(results[1].replace(
				/\+/g, " "));
	}

	function SearchCtrl($window, $scope, $rootScope, $http) {
		$scope.showGridFlag = 'false';
		// The function that will be executed on button click (ng-click="search()")
		$scope.search = function() {

			var searchval = $("input[name=user]").val();
			//alert(searchval+" in search");
			var link = "";
			if (searchval == '') {
				form.user.focus();
				link = "#"
				document.form.action = link;
				$window.location.href = link;

			} else {
				link = "/loginMvcApp/userSearch?user=" + searchval
				$window.location.href = link;

			}
		}
	};
</script>
</head>
<body ng-controller="gridController">
	<div class="container-fluid" align="center">
		<h2 class="sub-header" align="center">Search Result</h2>
		<div ng-controller="SearchCtrl">
			<form method="post" name="form" class="well form-search">
				<label>Search :</label> <input name="user" id="user" type="text"
					required ng-model="keywords" class="input-medium search-query"
					placeholder="Keywords...">
				<button type="submit" class="btn" ng-click="search()">Go!</button>			
			</form>
		</div>
     <div class="table-responsive">
            <div class="gridStyle table table-striped" ng-grid="gridOptions"></div>
     </div>			
		
	</div>
</body>
</html>

