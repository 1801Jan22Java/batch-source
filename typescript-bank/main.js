"use strict";
exports.__esModule = true;
var user_1 = require("./user");
var account_1 = require("./account");
// Define a user interface via the console
var readline = require('readline');
var rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
var users = [
    new user_1.User('Carl', 'pass1'),
    new user_1.User('Wezley', 'pass2'),
    new user_1.User('Genesis', 'pass3')
];
users[0].accounts = [
    new account_1.Account(500, 'savings'),
    new account_1.Account(500, 'checking')
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
        options();
    }
    else {
        getUsername();
    }
}
function options() {
    var a = true;
    rl.question("('q' to quit) Enter 1.) Deposit; 2.) Withdraw", function (answer) {
        if (answer === 'q') {
            a = false;
            rl.close();
        }
        else if (answer === '1') {
            putMoneyIn();
        }
        else if (answer === '2') {
            takeMoneyOut();
        }
        else {
            username = answer;
            getPassword();
        }
    });
}
function putMoneyIn() {
    rl.question("Enter amount to deposit: ", function (answer) {
        console.log("Amount before deposit: " + account.balance);
        account.deposit(answer);
        console.log("Amount after deposit: " + account.balance);
    });
}
function takeMoneyOut() {
    rl.question("Enter amount to withdraw: ", function (answer) {
        console.log("Amount before withdrawal: " + account.balance);
        account.withdraw(answer);
        console.log("Amount after deposit: " + account.balance);
    });
}
