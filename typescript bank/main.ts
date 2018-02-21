import { User } from './user';
import { Account } from './account';

//Define a user interface via the console
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
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
]
users[2].accounts = [
    new Account(500, 'savings'),
    new Account(500, 'checking')
]

let username: string;
let password: string;

let loggedUser: User;
let account: Account;

getUsername();

function getUsername() {
    rl.question("Input your username: ('q' to quit)", (answer: string) => {
        if (answer === 'q') {
            rl.close();
        } else {
            username = answer;
            getPassword();
        }
    });
}

function getPassword() {
    rl.question("Input your password: ", (answer: string) => {
        password = answer;
        login();
    })
}

function login() {
    loggedUser = users.filter((user: User) => user.login(username, password))[0];
    if (loggedUser) {
        getAccount();
    } else {
        getUsername();
    }
}

function getAccount() {

    rl.question("Input your account type: ", (answer: string) => {
        if (answer === 'checking') {
            account = loggedUser.accounts[0];
            console.log(account);
        } else {
            account = loggedUser.accounts[1];
            console.log(account);
        }

    })
}
