class Animal{
    name: string;
    constructor(theName:string){
        this.name=theName;
    }
    move(distance:number=0){
        console.log(`${this.name} moved ${distance}m.` );
    }
}

class Snake extends Animal{
    constructor(name: string){
        super(name);
    }
    move(distance: number=5){
        console.log("Slithering");
        super.move(distance);
    }
}

class Kangaroo extends Animal {
    constructor(name:string){
        super(name);
    }
    move(distance:number){
        console.log("Hopping");
        super.move(distance);
    }
}

let nagini = new Snake("Nagini");
let dundee :Animal = new Kangaroo("Dundee");
nagini.move();
dundee.move(50);