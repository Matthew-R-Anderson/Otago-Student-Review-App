/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var module = angular.module('OtagoReviewApp', ['ngResource', 'ngStorage']);
class PaperReviews {

    constructor(code, review) {
        this.code = code;
        this.review = review;
    }

}


class ReviewItem {
    constructor() {
        this.reviewItem = new String();

    }

    reconstruct(sessionData) {
        for (let item of sessionData.reviewItem) {
            this.addItem(Object.assign(new Review(), item));
        }
    }

    addReview(item) {
        this.reviewItem;

    }

}

module.factory('registerAPI', function ($resource) {
    return $resource('/api/register');
});

module.factory('signInAPI', function ($resource) {
    return $resource('/api/students/:Student_ID');
});

module.factory('paperAPI', function ($resource) {
    return $resource('/api/papers/:id');

});

module.factory('reviewAPI', function ($resource) {
    return $resource('/api/review');

});

module.factory('departmentsAPI', function ($resource) {
    return $resource('/api/departments/:dept');

});

module.factory('hallsAPI', function ($resource) {
    return $resource('/api/halls/:name');

});

module.factory('librariesAPI', function ($resource) {
    return $resource('/api/libraries/:name');

});

module.factory('tutorsAPI', function ($resource) {
    return $resource('/api/tutors/:name');

});

module.config(function ($sessionStorageProvider, $httpProvider) {
    // get the auth token from the session storage
    let authToken = $sessionStorageProvider.get('authToken');

    // does the auth token actually exist?
    if (authToken) {
        // add the token to all HTTP requests
        $httpProvider.defaults.headers.common.Authorization = 'Basic ' + authToken;
    }
});


module.factory('paperReviews', function ($sessionStorage) {
    let review = new PaperReviews();

    // is the cart in the session storage?
    if ($sessionStorage.review) {

        // reconstruct the cart from the session data
        review.reconstruct($sessionStorage.review);
    }

    return review;
});


module.controller('ReviewController', function ($sessionStorage, $window, paperReviews) {
    this.test = "testing";

    this.selectedReview = $sessionStorage.selectedReview;

    this.reviewRedirect = function (paper) {
        $sessionStorage.selectedItem = paper;
        $window.location = '../signedIn/leaveReview.html';

    };
    
    this.leaveReview = function (review) {
        
        
        
        delete $sessionStorage.selectedItem;
        $window.location = '../signedIn/viewPapers.html';


    };
});

module.controller('PaperController', function (paperAPI, departmentsAPI) {
    this.test = "It works!";
    // load the products
    this.papers = paperAPI.query();
    // load the categories
    this.departments = departmentsAPI.query();
    // click handler for the category filter buttons
    this.selectDepartment = function (selectedDep) {
        this.papers = departmentsAPI.query({"dept": selectedDep});
    };

    this.selectAll = function () {
        this.papers = paperAPI.query();
    };

    this.addReview = function () {


    }


});

module.controller('LibraryController', function (librariesAPI) {
    this.test = "It works!";
    // load the products
    this.library = librariesAPI.query();

});


module.controller('HallController', function ($window, $sessionStorage, hallsAPI) {
    this.test = "It works!";
    // load the products
    this.hall = hallsAPI.query();

    this.selectedHall = $sessionStorage.selectedReview;

    this.storeReview = function (hall) {

        $sessionStorage.selectedHall = hall;

        $window.location = 'leaveReview.html';
    }

});

module.controller('TutorController', function (tutorsAPI) {
    this.test = "It works!";
    // load the products
    this.tutors = tutorsAPI.query();



});

module.controller('StudentController', function (registerAPI, $window, signInAPI, $sessionStorage, $http) {
    // If student exists, then we can call it's first name for the message
    if ($sessionStorage.student) {
        this.welcome = "Welcome " + $sessionStorage.student.First_Name;
    }

    this.registerStudent = function (student) {
        registerAPI.save(null, student,
                // success callback
                        function () {
                            $window.location = 'signIn.html';
                        },
                        // error callback
                                function (error) {
                                    console.log(error);
                                }
                        );
                    };

// alias 'this' so that we can access it inside callback functions
            let ctrl = this;
            this.signIn = function (Student_ID, Password) {
                // generate authentication token
                let authToken = $window.btoa(Student_ID + ":" + Password);

                // store token
                $sessionStorage.authToken = authToken;

                // add token to the HTTP request headers
                $http.defaults.headers.common.Authorization = 'Basic ' + authToken;

                // get student from web service
                signInAPI.get({'Student_ID': Student_ID},
                        // success callback
                                function (student) {
                                    // also store the retrieved student
                                    $sessionStorage.student = student;
                                    // redirect to home
                                    $window.location = '../signedIn/signedInIndex.html';
                                },
                                // fail callback
                                        function () {
                                            ctrl.signInMessage = 'Sign in failed. Please try again.';
                                        }
                                );
                            };

                    this.signOut = function () {
                        $sessionStorage.$reset();
                        // Redirect to home
                        $window.location = '/signedOut/index.html';
                    };

                    this.checkSignIn = function () {
                        // has the student been added to the session?
                        if ($sessionStorage.student) {
                            this.signedIn = true;
                            this.welcome = "Welcome " + $sessionStorage.student.First_Name;
                        } else {
                            this.signedIn = false;
                        }
                    };

                });

       