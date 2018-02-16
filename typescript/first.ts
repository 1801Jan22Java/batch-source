class Student {
    fullName: string;
    constructor(public firstName: string, public middleInitial: string, public lastName: string){
        this.fullName = firstName + " " + middleInitial + ". " + lastName;
    }
}

interface Person {
    firstName: string;
    lastName: string;
}

function greeting(person: Person){
    let p1 = (person as Student);
    return "Hello " + p1.firstName + " " + p1.middleInitial + " " + person.lastName;
}
let user= new Student("Carl", "E", "Sagan");

document.body.innerHTML = greeting(user);
