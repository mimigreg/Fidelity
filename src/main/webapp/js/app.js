var app = angular.module('fidelity', []).
  config(['$routeProvider', function($routeProvider) {
  $routeProvider.
      when('/client', {templateUrl: 'partials/client-list.html',   controller: ClientListCtrl}).
      when('/client/:clientId', {templateUrl: 'partials/client-detail.html', controller: ClientDetailCtrl}).
      when('/client/edit/:clientId', {templateUrl: 'partials/client-edit.html', controller: ClientEditCtrl}).
      otherwise({redirectTo: '/client'});
}]).filter('escape', function() {
	  return function(input) {
		    return escape(input);
	  };
}).directive('date', function(dateFilter) {
    return {
        require: 'ngModel',
        link: function(scope, elm, attrs, ctrl) {

            var dateFormat = attrs['date'];

            ctrl.$parsers.unshift(function(viewValue) {
                var parsedDateMilissec = Date.parse(viewValue);
                if (parsedDateMilissec > 0) {
                    // it is valid
                    ctrl.$setValidity('date', true);
                    return parsedDateMilissec;
                } else {
                    // it is invalid, return undefined (no model update)
                    ctrl.$setValidity('date', false);
                    return undefined;
                }
            });

            ctrl.$formatters.unshift(function(modelValue) {
                return dateFilter(modelValue, dateFormat);
            });
        }
    };
});
