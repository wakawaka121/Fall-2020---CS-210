import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Drill07 {
	public static final String LINK_STRING = "<a href=/wiki/";
	/*
	 * Takes in a string of the HTML source for a webPage.
	 * Returns a Set<String> containing all of the valid wiki link
	 * titles found in the HTML source.
	 * 
	 * In order for a link to be a valid wikiLink for our case, it must
	 * match the pattern:
	 * <a href="/wiki/Marine_mammal">
	 * and NOT contain the character '#' nor ':'. From the above match, you
	 * would then extract the link name which in this case is:
	 * Marine_mammal
	 * Refer to the testcases for more examples.
	 * 
	 * The fact that the input to this parameter is HTML is largely
	 * irrelevant to this function. It is just a string processing function.
	 * You take in a string, and need to search for matches to a specific
	 * pattern in that string. We will go through a brief description of HTML
	 * in class this week if you are curious.
	 * 
	 * Your first job is to pass all of the tests. This means you either have
	 * a functionally correct algorithm, or are close to one. However, performance
	 * and efficiency will be very important for this PA. After finding a functionally
	 * correct algorithm, spend time designing other approaches to see if
	 * you can determine a more efficient approach. It will pay off when
	 * writing the PA! i.e. do not do anything inefficient, for
	 * instance, you should only go through the string once.
	 */
	public static Set<String> findWikiLinks(String html) {
		Set<String> wikiLinks = new HashSet<String>();
		String[] htmlArray = html.split("<a ");
		//System.out.println(htmlArray[0]);
		for(int index = 0; index < htmlArray.length; index++) {
			String htmlString = htmlArray[index];
			//System.out.println(htmlString);
			if(htmlString.contains("href=\"/wiki/")) {
				System.out.println(htmlString);
				htmlString.replace("\n","");
				System.out.println(htmlString);
				String[] linkArray = htmlString.split("href=\"/wiki/");
				String linkToAdd = linkArray[1].replace("\n","");
				//System.out.println(linkToAdd.split("\"")[0]);
				if(!linkToAdd.split("\"")[0].contains(":") && !linkToAdd.split("\"")[0].contains("#")) {
					wikiLinks.add(linkToAdd.split("\"")[0]);
				}
		}
		}
		return  wikiLinks;
	}
}
