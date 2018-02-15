var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Animal = /** @class */ (function () {
    function Animal(theName) {
        this.name = theName;
    }
    Animal.prototype.move = function (distance) {
        if (distance === void 0) { distance = 0; }
        console.log(this.name + " moved " + distance + "m.");
    };
    return Animal;
}());
var Snake = /** @class */ (function (_super) {
    __extends(Snake, _super);
    function Snake(name) {
        return _super.call(this, name) || this;
    }
    Snake.prototype.move = function (distance) {
        if (distance === void 0) { distance = 5; }
        console.log("Slithering");
        _super.prototype.move.call(this, distance);
    };
    return Snake;
}(Animal));
var Kangaroo = /** @class */ (function (_super) {
    __extends(Kangaroo, _super);
    function Kangaroo(name) {
        return _super.call(this, name) || this;
    }
    Kangaroo.prototype.move = function (distance) {
        console.log("Hopping");
        _super.prototype.move.call(this, distance);
    };
    return Kangaroo;
}(Animal));
var nagini = new Snake("Nagini");
var dundee = new Kangaroo("Dundee");
nagini.move();
dundee.move(50);
