"use strict";
exports.__esModule = true;
var user_1 = require("./user");
var account_1 = require("./account");
//define user interface via the console.
var readline = require('readline');
var rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
var users = [
    new user_1.User('Karl', 'pass1'),
    new user_1.User('Karol', 'pass2'),
    new user_1.User('Wesley Crusher', 'pass3'),
    new user_1.User('Exodus', 'pass4')
];
users[0].accounts = [
    new account_1.Account(500, 'CD'),
    new account_1.Account(500, 'savings')
];
users[1].accounts = [
    new account_1.Account(500, 'CD'),
    new account_1.Account(500, 'checking')
];
users[2].accounts = [
    new account_1.Account(500, 'CD'),
    new account_1.Account(500, 'checking')
];
users[3].accounts = [
    new account_1.Account(500, 'CD'),
    new account_1.Account(500, 'savings')
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
    rl.question("input your password: ", function (answer) {
        password = answer;
        login();
    });
}
function login() {
    loggedUser = users.filter(function (user) { return user.login(username, password); })[0];
    if (loggedUser) {
        getOptions();
    }
    else {
        getUsername();
    }
}
function getOptions() {
    rl.question("Which option would you like('d' to deposit, 'w' to withdraw, 's' to show account", function (answer) {
        if (answer === 's') {
            for (var i = 0; i < loggedUser.accounts.length; i++) {
                console.log(loggedUser.accounts[i]);
            }
            getOptions();
        }
        else if (answer === 'w') {
            rl.question("Which account would you like to withdraw from?", function (accountType) {
                if (accountType === 'CD') {
                    rl.question("How much do you want to withdraw?", function (amount) {
                        loggedUser.getAccount('CD').withdraw(amount);
                    });
                    console.log(loggedUser.getAccount('CD'));
                    getOptions();
                }
            });
        }
        else if (answer === 'd') {
            rl.question("Which account would you like to deposit to?", function (accountType) {
                if (accountType === 'CD') {
                    rl.question("How much do you want to deposit?", function (amount) {
                        loggedUser.getAccount('CD').deposit(amount);
                    });
                    console.log(loggedUser.getAccount('CD'));
                    getOptions();
                }
            });
        }
        else {
            getUsername();
        }
    });
}
