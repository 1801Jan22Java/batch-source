"use strict";
exports.__esModule = true;
var user_1 = require("./user");
var account_1 = require("./account");
//Define a user interface
var readline = require('readline');
var r1 = readline.createInterface({
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
getUserName();
function getUserName() {
    r1.question("Input your username: ('q' to quit)", function (answer) {
        if (answer === 'q') {
            r1.close;
        }
        else {
            username = answer;
            getPassword();
        }
    });
}
function getPassword() {
    r1.question("Input your password", function (answer) {
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
        getUserName();
    }
}
function options() {
    var acct;
    var action;
    r1.question("Enter action(1 for deposit, 2 for withdraw, 3 view accounts, q to quit): ", function (answer) { action = answer; });
    if (action === "3") {
        displayAccounts();
    }
    else if (action === "1" || action === "2") {
        r1.question("Enter account type you wish to perform the action on: ", function (answer) { acct = answer; });
        performAction(acct, action);
    }
    else if (action === "q") {
        console.log("Goodbye");
    }
    else {
        options();
    }
}
function performAction(account, action) {
    var amount;
    switch (action) {
        case "1":
            r1.question("Enter amount to deposit: ", function (answer) { amount = answer; });
            loggedUser.getAccount(account).deposit(amount);
            break;
        case "2":
            r1.question("Enter amount to withdraw: ", function (answer) { amount = answer; });
            loggedUser.getAccount(account).withdraw(amount);
    }
    options();
}
function displayAccounts() {
    for (var x = 0; x < loggedUser.accounts.length; x++) {
        console.log("Account " + (x + 1) + ": " + loggedUser.accounts[x].type + " has a balance of $" + loggedUser.accounts[x].balance);
    }
    options();
}
