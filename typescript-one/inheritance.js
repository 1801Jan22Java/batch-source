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
var drSnaken = new Snake("Dr Carl Snaken");
drSnaken.move();
var Doge = /** @class */ (function (_super) {
    __extends(Doge, _super);
    function Doge(name) {
        return _super.call(this, name) || this;
    }
    Doge.prototype.move = function (distance) {
        if (distance === void 0) { distance = 12; }
        console.log("Much move, very locomotion, wow");
        _super.prototype.move.call(this, distance);
    };
    return Doge;
}(Animal));
var shibe = new Doge("Very Shibe");
shibe.move(50);
