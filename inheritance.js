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
        console.log("$this.name) moved $(distance)meters.");
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
var Doge = /** @class */ (function (_super) {
    __extends(Doge, _super);
    function Doge(name) {
        return _super.call(this, name) || this;
    }
    Doge.prototype.move = function (distance) {
        if (distance === void 0) { distance = 45; }
        console.log("Much move, very locomotive, wow");
        _super.prototype.move.call(this, distance);
    };
    return Doge;
}(Animal));
var drSnaken = new Snake("Dcotor Carl Snaken");
var shibe = new Doge("very Shibe");
drSnaken.move();
shibe.move(50);
