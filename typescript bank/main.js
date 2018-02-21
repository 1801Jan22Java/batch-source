"use strict";
exports.__esModule = true;
var user_1 = require("./user");
var account_1 = require("./account");
//Define a user interface via the console
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
users[1].accounts = [
    new account_1.Account(500, 'savings'),
    new account_1.Account(500, 'checking')
];
users[2].accounts = [
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
        getAccount();
    }
    else {
        getUsername();
    }
}
function getAccount() {
    rl.question("Input your account type: ", function (answer) {
        if (answer === 'checking') {
            account = loggedUser.accounts[0];
        }
        else {
            account = loggedUser.accounts[1];
        }
    });
}
