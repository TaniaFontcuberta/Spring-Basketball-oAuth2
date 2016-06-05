(function() {
    'use strict';
    angular
        .module('basketballOauth2App')
        .factory('Player', Player);

    Player.$inject = ['$resource', 'DateUtils'];

    function Player ($resource, DateUtils) {
        var resourceUrl =  'api/players/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    data.birthdate = DateUtils.convertLocalDateFromServer(data.birthdate);
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    data.birthdate = DateUtils.convertLocalDateToServer(data.birthdate);
                    return angular.toJson(data);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    data.birthdate = DateUtils.convertLocalDateToServer(data.birthdate);
                    return angular.toJson(data);
                }
            }
        });
    }
})();
