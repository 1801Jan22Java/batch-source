package com.revature.dao;

import java.util.List;

import com.revature.beans.Wallet;

public interface WalletDao {
	List<Wallet> getWallets(int id);
	void addWallet(Wallet wallet);
	int getWalletID(int empID, String address);
	Wallet getWalletByID(int id);
}
