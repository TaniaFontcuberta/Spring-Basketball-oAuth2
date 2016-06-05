(function() {
    'use strict';

    angular
        .module('basketballOauth2App')
        .controller('TeamDetailController', TeamDetailController);

    TeamDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'entity', 'Team', 'Player'];

    function TeamDetailController($scope, $rootScope, $stateParams, entity, Team, Player) {
        var vm = this;
        vm.team = entity;
        
        var unsubscribe = $rootScope.$on('basketballOauth2App:teamUpdate', function(event, result) {
            vm.team = result;
        });
        $scope.$on('$destroy', unsubscribe);

    }
})();
