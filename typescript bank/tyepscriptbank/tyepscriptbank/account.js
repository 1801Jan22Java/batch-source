"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Account = /** @class */ (function () {
    function Account(balance, type) {
        if (balance === void 0) { balance = 0; }
        this.balance = balance;
        this.type = type;
    }
    Account.prototype.withdraw = function (amount) {
        this.balance = this.balance - amount;
    };
    Account.prototype.deposit = function (amount) {
        this.balance = this.balance + amount;
    };
    return Account;
}());
exports.Account = Account;
//# sourceMappingURL=account.js.map