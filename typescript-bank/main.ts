import {User} from './user';
import {Account} from './account';

//Define a user interface via the console
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let users = [
    new User('Carl','pass1'),
    new User('Wezley', 'pass2'),
    new User('Genesis', 'pass3')
];

users[0].accounts = [
    new Account(500,'savings'),
    new Account(500,'checking')
];

users[1].accounts = [
    new Account(500,'savings'),
    new Account(500,'checking')
]
users[2].accounts = [
    new Account(500,'savings'),
    new Account(500,'checking')
]

let username: string;
let password: string;

let loggedUser: User;
let account: Account;

getUsername();

function getUsername(){
    rl.question("Input your username: ('q' to quit)",(answer: string) =>{
        if(answer==='q'){
            rl.close();
        } else {
            username = answer;
            getPassword();
        }
    });
}

function getPassword() {
    rl.question("Input your password: ", (answer: string) =>{
        password = answer;
        login();
    })
}

function login() {
    loggedUser = users.filter((user: User) => user.login(username,password))[0];
    if (loggedUser){
        rl.question("Deposit = d, Withdraw = w, Logout = l. Btw, you are going to deposit in checking. YOU HAVE NO CHOICE HAHAHAHAHAHA!!!", (answer: string) => {
            if (answer === "d") {
                deposit();
            } else if (answer === "w") {
                withdraw();
            } else if (answer === "l") {
                logout();
            } else {
                console.log("Welp! Can't help you!");
                logout();
            }
        })
    } else {
        getUsername();
    }
}

function logout() {
    console.log("Lulz. I actually do nothing. Pretend you are logged out or something idk...");
}

function deposit() {
    rl.question("How much to deposit?", (answer: number) => {
        loggedUser.accounts[0].deposit(answer);
        console.log(`Yos! ${answer} hundred cents deposited!!!!`);
        console.log(`You got ${loggedUser.accounts[0].balance} now!!!`);
        login();
    })
}

function withdraw() {
    rl.question("How much to withdraw?", (answer: number) => {
        loggedUser.accounts[0].withdraw(answer);
        console.log(`Yos! ${answer} hundred cents stol- I mean withdrawn!!!!`);
        console.log(`You got ${loggedUser.accounts[0].balance} now!!!`);
        login();
    })
}