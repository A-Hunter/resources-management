'use strict';

angular.module('myApp').controller('PersonController', ['$scope', 'PersonService', function($scope, PersonService) {
    var self = this;
    self.person={id:null,username:'',address:'',email:''};
    self.persons=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllPersons();

    function fetchAllPersons(){
        PersonService.fetchAllPersons()
            .then(
            function(d) {
                self.persons = d;
            },
            function(errResponse){
                console.error('Error while fetching Persons');
            }
        );
    }

    function createPerson(person){
        PersonService.createPerson(person)
            .then(
            fetchAllPersons,
            function(errResponse){
                console.error('Error while creating Person');
            }
        );
    }

    function updatePerson(person, id){
        PersonService.updatePerson(person, id)
            .then(
            fetchAllPersons,
            function(errResponse){
                console.error('Error while updating Person');
            }
        );
    }

    function deletePerson(id){
        PersonService.deletePerson(id)
            .then(
            fetchAllPersons,
            function(errResponse){
                console.error('Error while deleting Person');
            }
        );
    }

    function submit() {
        if(self.person.id===null){
            console.log('Saving New Person', self.person);
            createPerson(self.person);
        }else{
            updatePerson(self.person, self.person.id);
            console.log('Person updated with id ', self.person.id);
        }
        self.reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.persons.length; i++){
            if(self.persons[i].id === id) {
                self.person = angular.copy(self.persons[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.person.id === id) {//clean form if the person to be deleted is shown there.
            reset();
        }
        deletePerson(id);
    }


    function reset(){
        self.person={id:null,username:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
