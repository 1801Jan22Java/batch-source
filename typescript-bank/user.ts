import {Account} from './account';

export class User {
	
	username: string;
	password: string;
	accounts: Account[] = [];

	constructor(user: string, pass: string) {
		this.username = user;
		this.password = pass;
	}

	login(user: string, pass: string): boolean {
		return this.username === user && this.password === pass;
	}

	getAccount(type: string): Account {
       return this.accounts.filter((account: Account) => account.type == type)[0];
   }
}