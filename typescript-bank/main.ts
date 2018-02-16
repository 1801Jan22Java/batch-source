import {User} from './user';
import {Account} from './account';

const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let users = [
    new User('Carl', 'pass1'),
    new User('Wezley', 'pass2'),
    new User('Gensis', 'pass3')
];

users[0].accounts = [
    new Account(500, 'savings'),
    new Account(500, 'checkings')
];

users[1].accounts = [
    new Account(500, 'savings'),
    new Account(500, 'checkings')
];

users[2].accounts = [
    new Account(500, 'savings'),
    new Account(500, 'checkings')
];

let username: string;
let password: string;

let loggedUser: User;
let account: Account;

getUsername();

function getUsername(){
    rl.question("Input your username: ('q' to quit)",(answer: string) => {
        if(answer === 'q'){
            rl.close();
        } else {
            username = answer;
            getPassword();
        }
    })
}

function getPassword(){
    rl.question("Input your password: ", (answer: string)=>{
        password = answer;
        login();
    })
}

function login(){
    loggedUser = users.filter((user: User)=> user.login(username, password))[0];
    if(loggedUser){
        rl.question("What would you like to do?", (answer: string) => {
            if(answer === 'deposit'){
                depositMoney();
            } else if (answer === 'withdraw'){
                console.log("hello");
            }
        })
    } else {
        getUsername();
    }
}

function depositMoney(){
    if(loggedUser){
        rl.question("Which account would you like to deposit into?", (answer: string) => {
            let acc: Account = loggedUser.getAccount(answer);
            rl.question("How much would you like to deposit?", (amount: number) => {
                acc.deposit(amount);
                console.log(acc.balance);
            })
        })
    }
}
