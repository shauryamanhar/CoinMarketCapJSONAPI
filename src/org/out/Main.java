package org.out;

import java.io.*;
import java.util.Iterator;

import org.jsoup.*;
import org.json.Coin;
import org.jsoup.nodes.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
	public static Coin getCoin(String url){
		Coin coin = new Coin();
		try {
			Document document = Jsoup.connect(url).ignoreContentType(true).get();
			String json=document.text();
			System.out.println(json);
			JSONParser parser = new JSONParser();
			Object obj = null;
			JSONArray jsonArray=null;
			JSONObject jsonObject=null;
			try {
				obj = parser.parse(json);
				jsonArray = (JSONArray) obj;
				obj = jsonArray.get(0);
				jsonObject = (JSONObject) obj;
				
				coin.setId(""+jsonObject.get("id"));
				coin.setName(jsonObject.get("name").toString());
				coin.setSymbol(jsonObject.get("symbol").toString());
				coin.setRank(jsonObject.get("rank").toString());
				
				coin.setPriceUsd(jsonObject.get("price_usd").toString());
				coin.setPriceBtc(jsonObject.get("price_btc").toString());
				coin.set_24hVolumeUsd(jsonObject.get("24h_volume_usd").toString());
				coin.setMarketCapUsd(jsonObject.get("market_cap_usd").toString());
				
				coin.setAvailableSupply(jsonObject.get("available_supply").toString());
				coin.setTotalSupply(jsonObject.get("total_supply").toString());
				coin.setMaxSupply(jsonObject.get("max_supply").toString());
				coin.setPercentChange1H(jsonObject.get("percent_change_1h").toString());
				
				coin.setPercentChange24H(jsonObject.get("percent_change_24h").toString());
				coin.setPercentChange7D(jsonObject.get("percent_change_7d").toString());
				
			} catch (Exception e) {
				System.out.println("Error in getCoin() 1");
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			System.out.println("Error inside the getCoin() 2");
			e.printStackTrace();
		}
		return coin;
	}

	public static void main(String[] args) throws IOException {
/*		Document document=null;
		String responseFromServerJson="";
		//String url="https://api.coinmarketcap.com/v1/global/";
		String url="https://api.coinmarketcap.com/v1/ticker/bitcoin/";
		//document = Jsoup.connect("https://api.coinmarketcap.com/v1/global").ignoreContentType(true).get();
		document = Jsoup.connect(url).ignoreContentType(true).get();
		String s=document.text();
		//System.out.println(s);
		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//JSONObject jsonObject = (JSONObject) obj;
		//System.out.println(jsonObject);
		
		JSONArray jsonArray = (JSONArray) obj;
		//System.out.println(jsonObject.get("id"));
		System.out.println(jsonArray.get(0));
		Object b = jsonArray.get(0);
		JSONObject jsonObject = (JSONObject) b;
		System.out.println("+++"+jsonObject.get("id"));
		*/
		String url="https://api.coinmarketcap.com/v1/ticker/bitcoin";
		Coin coin = getCoin(url);
		System.out.println(coin.getId());
		
	}

}
