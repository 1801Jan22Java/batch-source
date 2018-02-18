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
        rl.question("Deposit = d, Withdraw = w, Logout = l. Btw, you are going to deposit in checking. YOU HAVE NO CHOICE HAHAHAHAHAHA!!!", function (answer) {
            if (answer === "d") {
                deposit();
            }
            else if (answer === "w") {
                withdraw();
            }
            else if (answer === "l") {
                logout();
            }
            else {
                console.log("Welp! Can't help you!");
                logout();
            }
        });
    }
    else {
        getUsername();
    }
}
function logout() {
    console.log("Lulz. I actually do nothing. Pretend you are logged out or something idk...");
}
function deposit() {
    rl.question("How much to deposit?", function (answer) {
        loggedUser.accounts[0].deposit(answer);
        console.log("Yos! " + answer + " hundred cents deposited!!!!");
        console.log("You got " + loggedUser.accounts[0].balance + " now!!!");
        login();
    });
}
function withdraw() {
    rl.question("How much to withdraw?", function (answer) {
        loggedUser.accounts[0].withdraw(answer);
        console.log("Yos! " + answer + " hundred cents stol- I mean withdrawn!!!!");
        console.log("You got " + loggedUser.accounts[0].balance + " now!!!");
        login();
    });
}
