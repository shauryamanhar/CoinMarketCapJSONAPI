package org.json;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Methods {
	public Coin getCoin(String url){
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

}
