import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Author: Derek Tominaga
 * File: WikiScraper.java
 * Description: This utility class will allow you to extract the wiki links of a
 * wiki page. Its state is a memoization of prior links you have scrubed. It contains methods
 * internally connect to wikipedia, getting the html from a wiki page, parsing the html to find
 * wikilinks.   */
public class WikiScraper {
	
	/*Dictionary used for memoization to keep track of the Links for pages that have already been fetched.*/
	private static Map<String,Set<String>> memoLinks = new HashMap<String,Set<String>>();
	
	/*
	 * This is a public method that takes one parameter to get a Set of links on a page.
	 * This is done by calling fetchHTML which gets teh html code of a web-page, and then 
	 * calling scraperHTML to get the set of links. fetchHTML and scraperHTML are private 
	 * helper function of the WikiScraper class. It also uses memoization to avoid having to 
	 * refetch html from the web.
	 * Return: a Set of strings that are the links on a webpage.
	 */
	public static Set<String> findWikiLinks(String link) {
		if(!memoLinks.containsKey(link)) {
			String html = fetchHTML(link);
			Set<String> linksOnPage = scrapeHTML(html);
			memoLinks.put(link, linksOnPage);
			
		}
		return memoLinks.get(link);
	}
	
	/* This function takes one parameter to connect to the internet and get
	 * the HTML from a page on the web. Where link is the location on the internet
	 * where the HTML will be fetched from.
	 * Return: a string that is the entirety of the webpages html code for the 
	 * that destination.
	 */
	private static String fetchHTML(String link) {
		StringBuffer buffer = null;
		try {
			URL url = new URL(getURL(link));
			InputStream is = url.openStream();
			int ptr = 0;
			buffer = new StringBuffer();
			while ((ptr = is.read()) != -1) {
			    buffer.append((char)ptr);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return buffer.toString();
	}
	
	/*
	 * This function takes one parameter to complete the wikipedia url destination
	 * for connecting to the web. 
	 * Return: string URL.
	 */
	private static String getURL(String link) {
		return "https://en.wikipedia.org/wiki/" + link;
	}
	
	/*
	 * This function takes one parameter to extract the links that exists on a webpage. The string is 
	 * HTML code that is parsed to find sentinel values that indicate a wiki-link. Baring locaitons links
	 * and external links.
	 * Returns: a Set of strings that are all the links that exists in the html code. 
	 */
	private static Set<String> scrapeHTML(String html) {
		Set<String> linksOnPage = new HashSet<String>();
		String[] htmlArray = html.split("<a ");
		for(int index = 0; index < htmlArray.length; index++) {
			String htmlString = htmlArray[index];
			if(htmlString.contains("href=\"/wiki/")) {
				htmlString.replace("\n", "");
				String[] linkArray = htmlString.split("href=\"/wiki/");
				String linkToAdd = linkArray[1].replace("\n", "");
				if(!linkToAdd.split("\"")[0].contains("#") && !linkToAdd.split("\"")[0].contains(":")) {
					linksOnPage.add(linkToAdd.split("\"")[0]);
				}
			}
		}
		return linksOnPage;
	}
	
}
