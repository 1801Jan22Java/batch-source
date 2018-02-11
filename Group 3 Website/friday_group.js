//Proxying 
/*The proxy object is used to define custom behavior for fundamental
 operations
 */
 
//Useful for validating the passed value of an object 
let target = {
	world : "Hello, World",
	newthing: "Hello...you",
}

let blankObj ={
	name: "ok"
	}


let proxy = new Proxy(target, {
	get(receiver,name){
	if( name in receiver)
		console.log(receiver[name]);
	else{console.log("nothing there");}
	}
});
proxy.world = "Welcome, foo";
proxy.name = "default";
proxy.world;
proxy.name;
proxy.newthing;;
proxy.blankObj;
proxy.nihil;

//Reflection

let obj={a:1};
var newObj = {b:1}

Object.defineProperty(obj, "b", {value:2});
obj[Symbol("c")]=3;
{
	var newThing = {c:3}
}

Reflect.ownKeys(obj);
console.log(Reflect.ownKeys(obj));
console.log(Reflect.ownKeys(newObj));
console.log(Reflect.ownKeys(newThing));
