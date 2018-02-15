var Student = /** @class */ (function () {
    function Student(firstName, middleInitial, lastName) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.fullName = firstName + " " + middleInitial
            + " " + lastName;
    }
    return Student;
}());
function greeting(person) {
    return "Hello, " + person.firstName + "  " +
        person.lastName;
}
var user = new Student("Carl", "E", "Sagan");
document.body.innerHTML = greeting(user);
