import { User } from './user';
import { Account } from './account';

//define user interface via the console.

const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});


let users = [
    new User('Karl', 'pass1'),
    new User('Karol', 'pass2'),
    new User('Wesley Crusher', 'pass3'),
    new User('Exodus', 'pass4')
]

users[0].accounts = [
    new Account(500, 'CD'),
    new Account(500, 'savings')
]
users[1].accounts = [
    new Account(500, 'CD'),
    new Account(500, 'checking')
]
users[2].accounts = [
    new Account(500, 'CD'),
    new Account(500, 'checking')
]

users[3].accounts = [
    new Account(500, 'CD'),
    new Account(500, 'savings')
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
    rl.question("input your password: ", (answer: string) => {
        password = answer;
        login();
    })
}

function login() {
    loggedUser = users.filter((user: User) => user.login(username, password))[0];
    if (loggedUser) {
        getOptions();

    } else {
        getUsername();
    }
}

function getOptions() {

    rl.question("Which option would you like('d' to deposit, 'w' to withdraw, 's' to show account", (answer: string) => {
        if (answer === 's') {
            for (let i = 0; i < loggedUser.accounts.length; i++) {
                console.log(loggedUser.accounts[i]);
            }
            getOptions();
        }
        else if (answer === 'w') {
            rl.question("Which account would you like to withdraw from?", (accountType: string) => {
                if (accountType === 'CD') {
                    rl.question("How much do you want to withdraw?", (amount: number) => {
                        loggedUser.getAccount('CD').withdraw(amount);
                    })
                    console.log(loggedUser.getAccount('CD'));
                    getOptions();
                }
            })

        }

        else if (answer === 'd') {
            rl.question("Which account would you like to deposit to?", (accountType: string) => {
                if (accountType === 'CD') {
                    rl.question("How much do you want to deposit?", (amount: number) => {
                        loggedUser.getAccount('CD').deposit(amount)
                    })
                    console.log(loggedUser.getAccount('CD'));
                    getOptions();
                }

            })
        }
        else {
            getUsername();
        }
    })
}