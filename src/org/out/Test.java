package org.out;

import java.io.PrintWriter;

import org.json.Coin;
import org.json.Methods;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Methods m = new Methods();
		String url="https://api.coinmarketcap.com/v1/ticker/bitcoin";
		Coin coin = m.getCoin(url);
		System.out.println(coin.getId());
	}

}
