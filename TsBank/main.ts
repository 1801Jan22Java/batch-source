import {User} from './user';
import {Account} from './account';

//Define a user interface
const readline = require('readline');

const r1 = readline.createInterface({
    input : process.stdin,
    output: process.stdout
});


let users = [
    new User('Carl', 'pass1'),
    new User('Wezley', 'pass2'),
    new User('Genesis', 'pass3')
];

users[0].accounts = [
    new Account(500, 'savings'),
    new Account(500, 'checking')
];

users[1].accounts = [
    new Account(500, 'savings'),
    new Account(500, 'checking')
];

users[2].accounts = [
    new Account(500, 'savings'),
    new Account(500, 'checking')
];

let username : string;
let password : string;

let  loggedUser : User;
let account : Account;

getUserName()

function getUserName(){
    r1.question("Input your username: ('q' to quit)", (answer: string) => {
        if (answer==='q'){
            r1.close;
        } else {
            username = answer;
            getPassword();
        }
    });
}

function getPassword() {
    r1.question("Input your password", (answer : string) => {
        password = answer;
        login();
    });
}

function login() {
    loggedUser = users.filter((user : User) => user.login(username, password))[0];

    if (loggedUser) {
        options();
    }else {
        getUserName();
    }

}

function options() {
    let acct : string;
    let action : string;
    
        r1.question("Enter action(1 for deposit, 2 for withdraw, 3 view accounts, q to quit): ", (answer : string) => {action = answer});
        if (action === "3") {
            displayAccounts();
        }
        else if (action === "1" || action === "2"){
            r1.question("Enter account type you wish to perform the action on: ", (answer : string) => {acct = answer});
            performAction(acct, action);
        } else if (action === "q"){
            console.log("Goodbye");
        }
        else {
            options();
        }
       
   
}

function performAction(account : string, action : string) {
    let amount : number;
    switch (action){
        case "1":
            r1.question("Enter amount to deposit: ", (answer : number) => {amount = answer});
            loggedUser.getAccount(account).deposit(amount);
            break;
        case "2":
            r1.question("Enter amount to withdraw: ", (answer : number) => {amount = answer});
            loggedUser.getAccount(account).withdraw(amount);
    }
    options();
}

function displayAccounts() {
    for (let x = 0; x < loggedUser.accounts.length; x++) {
        console.log(`Account ${x+1}: ${loggedUser.accounts[x].type} has a balance of $${loggedUser.accounts[x].balance}`);
    }
    options();
}