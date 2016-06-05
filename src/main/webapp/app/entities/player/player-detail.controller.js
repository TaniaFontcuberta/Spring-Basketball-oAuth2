(function() {
    'use strict';

    angular
        .module('basketballOauth2App')
        .controller('PlayerDetailController', PlayerDetailController);

    PlayerDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'entity', 'Player', 'Team'];

    function PlayerDetailController($scope, $rootScope, $stateParams, entity, Player, Team) {
        var vm = this;
        vm.player = entity;
        
        var unsubscribe = $rootScope.$on('basketballOauth2App:playerUpdate', function(event, result) {
            vm.player = result;
        });
        $scope.$on('$destroy', unsubscribe);

    }
})();
