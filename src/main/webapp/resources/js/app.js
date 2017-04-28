var app = angular.module('myApp', ['ngResource']);

app.factory('TreeData', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/treeeasy/info/tree/:treeId', {treeId: '@pid'},
	{
		updateTreeData: {method: 'PUT'}
	}
    );
}]);

app.controller('TreeController', ['$scope', 'TreeData', function($scope, TreeData) {
    var ob = this;
    ob.treesData=[];
    ob.treeData = new TreeData(); 
    ob.fetchAllTreesData = function(){
        ob.treesData = TreeData.query();
    };
    ob.fetchAllTreesData();
    ob.addTreeData = function(){
		console.log('Inside save');
		if($scope.treeForm.$valid) {
			ob.treeData.$save(function(treeData){
				console.log(treeData); 
				ob.flag= 'created';	
				ob.reset();	
				ob.fetchAllTreesData();
			},
			function(err){
				console.log(err.status);
				ob.flag='failed';
			}
			);
		}
    }; 
    ob.editTreeData = function(id){
	    console.log('Inside edit');
        ob.treeData = TreeData.get({ treeId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateTreeDataDetail = function(){
	console.log('Inside update');
	if($scope.treeForm.$valid) {
    	   ob.treeData.$updateTreeData(function(treeData){
    		console.log(treeData); 
		ob.updatedId = treeData.pid;
				ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllTreesData();
           });
	}
    };	
    ob.deleteTreeData = function(id){
	    console.log('Inside delete');
	    ob.treeData = TreeData.delete({ treeId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllTreesData(); 
	    });
    };		
    ob.reset = function(){
    	ob.treeData = new TreeData();
        $scope.treeForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.treeData = new TreeData();
	    ob.flag= '';	
   	    ob.fetchAllTreesData();
    };    
}]);    
   