"use strict";
exports.__esModule = true;
var User = /** @class */ (function () {
    function User(username, password) {
        this.accounts = [];
        this.username = username;
        this.password = password;
    }
    User.prototype.login = function (user, pass) {
        return (this.username === user && this.password === pass);
    };
    User.prototype.getAccount = function (type) {
        return this.accounts.filter(function (account) { return account.type == type; })[0];
    };
    return User;
}());
exports.User = User;
