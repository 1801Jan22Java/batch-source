import {Account} from './account'

export class User {
    username: string;
    password: string;
    accounts: Account[] = [];

    constructor(username: string, password:string){
        this.username = username;
        this.password = password;
    }

    login(user: string, pass: string): boolean {
        return (this.username===user && this.password===pass);
    }

    getAccount(type: string): Account {
        return this.accounts.filter((account: Account) => account.type == type)[0];
    }

}