package com.dlut.gym.action;

import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dlut.gym.util.C;

public class NewsAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int newsNum = 5;
	
	public void setNewsNum(int newsNum){
		this.newsNum = newsNum;
	}
	
	public String getNews() throws IOException{
		String url = "http://tyg.dlut.edu.cn/index.htm";
		Elements links = Jsoup.connect(url).get().select("a[href][class=c63065]");
		
		List<Map<String, String>> newsList = new ArrayList<Map<String, String>>();
		int i = 0;
		for(Element link : links) {
			if(i == newsNum)
				break;
			
			Elements el = Jsoup.connect(link.attr("abs:href")).get().select("span[class=timestyle63106]");
			
			Map<String, String> newsMap = new HashMap<String, String>();
			newsMap.put("url", link.attr("abs:href"));
			newsMap.put("title", link.attr("title"));
			newsMap.put("time", el.text());
			
			newsList.add(newsMap);
			i++;
		}
		
		setResultMap(C.code.NEWS, C.message.SUCCESS, C.name.NEWS_MAPNAME, newsList);
		return SUCCESS;
	}

}
