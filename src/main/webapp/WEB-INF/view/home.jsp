<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
    <head>
        <meta charset="UTF-8" />
        <title> TREEEASY </title>
    </head>
    <body ng-app="myApp">
        <div style="font-family:Arial Black;" ng-controller="TreeController as treeCtrl">
            <form name="treeForm" method="POST">
                <table style="background-color: #a0ce4e;">
                    <tr>
                        <td colspan="2">
                            <div ng-if="treeCtrl.flag != 'edit'">
                                <h3 style="color:white;"> ADICIONAR NOVO REGISTRO </h3>
                            </div>
                            <div ng-if="treeCtrl.flag == 'edit'">
                                <h2 style="color:white;"> ATUALIZAR ID: {{ treeCtrl.treedata.pid }} </h2>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td style="color:white;">Nome*: </td>
                        <td><input style="border: 2px solid white;" type="text" name="name" ng-model="treeCtrl.treeData.name" required/> 
                            <span ng-show="treeForm.name.$error.required" class="msg-val"></span> 
                        </td>
                    </tr>
                    <tr>
                        <td style="color:white;">Descrição*: </td>
                        <td> <input style="border: 2px solid white;" type="text" name="description" ng-model="treeCtrl.treeData.description" required/> 
                            <span ng-show="treeForm.description.$error.required" class="msg-val"></span> 
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="treeCtrl.flag=='created'" class="msg-success">Registro salvo com sucesso.</span>
                            <span ng-if="treeCtrl.flag=='failed'" class="msg-val">Registro já existe.</span> 
                        </td>
                    </tr>
                    <tr align="center">
                        <td colspan="2">
                            <div ng-if="treeCtrl.flag != 'edit'">
                                <input style="font-size: 20px;" type="submit" ng-click="treeCtrl.addTreeData()" value="Adicionar registro"/>
                                <input style="font-size: 20px;" type="button" ng-click="treeCtrl.reset()" value="Limpar"/>
                            </div>
                            <div ng-if="treeCtrl.flag == 'edit'">
                                <input style="font-size: 20px;" type="submit" ng-click="treeCtrl.updateTreeDataDetail()" value="Atualizar registro"/> 	
                                <input style="font-size: 20px;" type="button" ng-click="treeCtrl.cancelUpdate()" value="Cancelar"/>				   
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="personCtrl.flag=='deleted'" class="msg-success">Registro deletado com sucesso.</span>
                    </tr>
                </table>
            </form>
            <div>
			</br>
            <table>
                <tr style="background-color: #a0ce4e;border: 2px solid black;color:white">
                    <th>ID </th>
                    <th>Nome</th>
                    <th>Descrição</th>
                </tr>
                <tr ng-repeat="row in treeCtrl.treesData">
                    <td style="background-color: #a0ce4e;"><span ng-bind="row.pid"></span></td>
                    <td style="background-color: #a0ce4e;"><span ng-bind="row.name"></span></td>
                    <td style="background-color: #a0ce4e;"><span ng-bind="row.description"></span></td>
                    <td>
                        <input style="font-size: 20px;" type="button" ng-click="treeCtrl.deleteTreeData(row.pid)" value="Deletar"/>
                        <input style="font-size: 20px;" type="button" ng-click="treeCtrl.editTreeData(row.pid)" value="Editar"/>
                        <span ng-if="treeCtrl.flag=='updated' && row.pid==treeCtrl.updatedId" class="msg-success">Atualizado</span> 
                    </td>
                </tr>
            </table>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/app-resources/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/app-resources/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/app-resources/js/app.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-resources/css/style.css"/>
    </body>
</html>