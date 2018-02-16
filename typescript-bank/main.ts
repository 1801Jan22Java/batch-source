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
	new Account(500, 'checking')
]

let username: string;
let password: string;

let loggedUser: User;
let account: Account;

getUsername();

function getUsername() {
	rl.question("Input your username: ('q' to quit)", (answer: string) => {
		if(answer === 'q') {
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
		options();
	} else {
		getUsername();
	}

}

function options() {
	let a = true;
	rl.question("('q' to quit) Enter 1.) Deposit; 2.) Withdraw", (answer: string) => {
		if(answer === 'q') {
			a = false;
			rl.close();
		} 
		else if(answer === '1') {
			putMoneyIn();
		} 
		else if(answer === '2') {
			takeMoneyOut();
		}
		else {
			username = answer;
			getPassword();
		}
	})

}

function putMoneyIn() {
	rl.question("Enter amount to deposit: ", (answer: number) => {
		console.log("Amount before deposit: " + account.balance);
		new Account(500, 'savings')
		account.deposit(answer);
		console.log("Amount after deposit: " + account.balance);
	})
}

function takeMoneyOut() {
	rl.question("Enter amount to withdraw: ", (answer: number) => {
		console.log("Amount before withdrawal: " + account.balance);
		account.withdraw(answer);
		console.log("Amount after deposit: " + account.balance);
	})
}