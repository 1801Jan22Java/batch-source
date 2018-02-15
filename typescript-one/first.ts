class Student {
    fullName: string;
    constructor(public firstName: string,public middleInitial: string,public lastName: string ){
        this.fullName = firstName+ " " + middleInitial + " " + lastName;
    }
}

function greeting(person: Person) {
    let p1 = (person as Student);
    return "Hello, " + person.firstName + " " + person.lastName;
}

let user = new Student("carl", "e","Sagan");

// let user = {
//     firstName: "Carl",
//     lastName: "Sagan"
// };

// Entirely possible to transpile, just we get an error
// let user = [1,2,3];

document.body.innerHTML = greeting(user);

interface Person {
    firstName: string;
    lastName: string;
}