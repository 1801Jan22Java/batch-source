"use strict";
exports.__esModule = true;
var user_1 = require("./user");
var account_1 = require("./account");
var readline = require('readline');
var rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
var users = [
    new user_1.User('Carl', 'pass1'),
    new user_1.User('Wezley', 'pass2'),
    new user_1.User('Gensis', 'pass3')
];
users[0].accounts = [
    new account_1.Account(500, 'savings'),
    new account_1.Account(500, 'checkings')
];
users[1].accounts = [
    new account_1.Account(500, 'savings'),
    new account_1.Account(500, 'checkings')
];
users[2].accounts = [
    new account_1.Account(500, 'savings'),
    new account_1.Account(500, 'checkings')
];
var username;
var password;
var loggedUser;
var account;
getUsername();
function getUsername() {
    rl.question("Input your username: ('q' to quit)", function (answer) {
        if (answer === 'q') {
            rl.close();
        }
        else {
            username = answer;
            getPassword();
        }
    });
}
function getPassword() {
    rl.question("Input your password: ", function (answer) {
        password = answer;
        login();
    });
}
function login() {
    loggedUser = users.filter(function (user) { return user.login(username, password); })[0];
    if (loggedUser) {
        rl.question("What would you like to do?", function (answer) {
            if (answer === 'deposit') {
                depositMoney();
            }
            else if (answer === 'withdraw') {
                console.log("hello");
            }
        });
    }
    else {
        getUsername();
    }
}
function depositMoney() {
    if (loggedUser) {
        rl.question("Which account would you like to deposit into?", function (answer) {
            var acc = loggedUser.getAccount(answer);
            rl.question("How much would you like to deposit?", function (amount) {
                acc.deposit(amount);
                console.log(acc.balance);
            });
        });
    }
}
