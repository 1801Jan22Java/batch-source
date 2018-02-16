import {User} from './user';
import {Account} from './account';

// Define a user interface via the console
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
    new Account(500, 'checking'),
]

users[1].accounts = [
    new Account(500, 'savings'),
    new Account(500, 'checking'),
]

users[2].accounts = [
    new Account(500, 'savings'),
    new Account(500, 'checking'),
]

let username: string;
let password: string;

let loggedUser: User;
let account: Account;

function userMenu(){
    let choice: string;
    console.log("Specify Action - Get Account, Withdraw, Deposit, logout");
    rl.question("Input your choice: ", (answer:string)=>{
        switch (answer){
            case "Get Account":
            getAccount();
            break;

        }
    });
};

function getAccount(){
    let account:Account;
    if(loggedUser.accounts.length > 0){
        rl.question("Enter in the type of account: ", (acct:string)=>{
            account = loggedUser.getAccount(acct);
            console.log("Balance: "+account.balance);
        });
    } else {
        console.log("You have no accounts, you pauper!");
    }
}

function getUsername(){
    rl.question("Input your username ('q' to quit): ", (answer: string)=>{
        if(answer==='q'){
            rl.close();
        } else {
            username = answer;
            getPassword();
        }
    });
};

function getPassword(){
    rl.question("Input your password: ", (answer:string) =>{
        password = answer;
        login();
    });
}

function login(){
    loggedUser = users.filter((user: User) => {user.login(username, password)})[0];
    if(loggedUser){ // narrow use of truthy / falsey
        console.log("Success! "+loggedUser.username+" is now logged in");
    } else {
        console.log("Login Failure");
        getUsername();
    }
};

function showAccounts(){
    for(let n = 0; n < loggedUser.accounts.length; n++){
        console.log("Account type: "+loggedUser.accounts[n].type+" balance: "+loggedUser.accounts[n].balance);
    }
};

console.log("Welcome to TS Bank");
getUsername();