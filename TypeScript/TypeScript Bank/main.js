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
    new account_1.Account(500, 'checking'),
];
users[1].accounts = [
    new account_1.Account(500, 'savings'),
    new account_1.Account(500, 'checking'),
];
users[2].accounts = [
    new account_1.Account(500, 'savings'),
    new account_1.Account(500, 'checking'),
];
var username;
var password;
var loggedUser;
var account;
function userMenu() {
    var choice;
    console.log("Specify Action - Get Account, Withdraw, Deposit, logout");
    rl.question("Input your choice: ", function (answer) {
        switch (answer) {
            case "Get Account":
                getAccount();
                break;
        }
    });
}
;
function getAccount() {
    var account;
    if (loggedUser.accounts.length > 0) {
        rl.question("Enter in the type of account: ", function (acct) {
            account = loggedUser.getAccount(acct);
            console.log("Balance: " + account.balance);
        });
    }
    else {
        console.log("You have no accounts, you pauper!");
    }
}
function getUsername() {
    rl.question("Input your username ('q' to quit): ", function (answer) {
        if (answer === 'q') {
            rl.close();
        }
        else {
            username = answer;
            getPassword();
        }
    });
}
;
function getPassword() {
    rl.question("Input your password: ", function (answer) {
        password = answer;
        login();
    });
}
function login() {
    loggedUser = users.filter(function (user) { user.login(username, password); })[0];
    if (loggedUser) {
        console.log("Success! " + loggedUser.username + " is now logged in");
    }
    else {
        console.log("Login Failure");
        getUsername();
    }
}
;
function showAccounts() {
    for (var n = 0; n < loggedUser.accounts.length; n++) {
        console.log("Account type: " + loggedUser.accounts[n].type + " balance: " + loggedUser.accounts[n].balance);
    }
}
;
console.log("Welcome to TS Bank");
getUsername();
