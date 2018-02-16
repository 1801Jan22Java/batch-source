class Animal {
    name: string;
    constructor(theName: string){
        this.name = theName;
    }
    move(distance: number = 0){
        console.log(`${this.name} moved ${distance} meters.`)
    }
}

class Snake extends Animal{
    constructor(name: string) {
        super(name);
    }
    move(distance: number = 5){
        console.log("Slithering");
        super.move(distance);
    }
}

class Doge extends Animal{
    constructor(name: string){super(name);}
    move(distance: number = 45){
        console.log("Much move, very locomotion, wow");
        super.move(distance);
    }
}

let drSnaken = new Snake("Doctor Carl Snaken");

let shibe: Animal = new Doge("Very Shibe");
drSnaken.move();
shibe.move(50);
