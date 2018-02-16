class Student {
    fullName: string
    constructor(public firstName: string, public middleInitial: string, public lastName: string){
        this.fullName = firstName+" "+this.middleInitial+" "+this.lastName;
    }
}

interface Person {
    firstName: string;
    lastName: string;

}

function greeting(person: Person){
    return "Hello" + person.firstName+" "+person.lastName;

};



let user = new Student("Carl", "E", "Sagan");
document.body.innerHTML= greeting(user);
