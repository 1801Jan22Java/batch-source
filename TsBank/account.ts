export class Account {
    balance : number;
    type : string;
    constructor(balance : number = 0, type : string){
        this.balance = balance;
        this.type = type;
    }

    withdraw(amount : number) {
        this.balance = this.balance - amount;
    }

    deposit(amount : number) {
        this.balance = this.balance + amount;
    }
}