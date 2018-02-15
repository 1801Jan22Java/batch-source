class Animal {
    name: string;
    constructor(theName: string) {
        this.name = theName;
    }
    move(distance: number = 0) {
        console.log(`${this.name} moved ${distance}m.`);
    }
}

class Snake extends Animal {
    constructor(name: string){
        super(name);
    }
    move(distance: number = 5){
        console.log("Slithering");
        super.move(distance);
    }
}

let drSnaken = new Snake("Dr Carl Snaken");

drSnaken.move();

class Doge extends Animal{
    constructor(name: string){
        super(name);
    }
    move(distance: number = 12){
        console.log("Much move, very locomotion, wow");
        super.move(distance);
    }
}

let shibe: Animal = new Doge("Very Shibe");

shibe.move(50);