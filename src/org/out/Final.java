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

public class Final {

	public static void main(String[] args) throws IOException {
		Document document=null;
		
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
		

	}

}
