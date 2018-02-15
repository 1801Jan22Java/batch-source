var Student = /** @class */ (function () {
    function Student(firstName, middleInitial, lastName) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.fullName = firstName + " " + middleInitial + " " + lastName;
    }
    return Student;
}());
function greeting(person) {
    return "Hello, " + person.firstName + " " + person.lastName;
}
var user = new Student("carl", "e", "Sagan");
// let user = {
//     firstName: "Carl",
//     lastName: "Sagan"
// };
// Entirely possible to transpile, just we get an error
// let user = [1,2,3];
document.body.innerHTML = greeting(user);
