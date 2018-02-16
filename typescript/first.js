var Student = /** @class */ (function () {
    function Student(firstName, middleInitial, lastName) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.fullName = firstName + " " + middleInitial + ". " + lastName;
    }
    return Student;
}());
function greeting(person) {
    var p1 = person;
    return "Hello " + p1.firstName + " " + p1.middleInitial + " " + person.lastName;
}
var user = new Student("Carl", "E", "Sagan");
document.body.innerHTML = greeting(user);
