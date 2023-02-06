import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* Author: Derek Tominaga
 * File: WikiRacer.java 
 * Description: This program takes two strings to find the ladder(which are wikilinks) to get from 
 * string1's webpage to string2's webpage by only using links that exisits on wikipedia pages. It contains
 * main which will call findWikiLadder to find the ladder from string 1 to string 2. findWikiLadder calls
 * a utiity class WikiScraper.java to get the links that exists on a page.
 * */
public class WikiRacer {

	/*
	 * Do not edit this main function
	 */
	public static void main(String[] args) {
		List<String> ladder = findWikiLadder(args[0], args[1]);
		System.out.println(ladder);
	}

	/*
	 * This methods takes 2 strings as parameters to find the ladder(which is a list of strings) that
	 * exists between the wiki pages of start, and end. This is done by getting the list of
	 * links that exists on the start strings webpage and following the links to see if you can get
	 * to the end strings webpage.  In order to make the method more efficient, the use of a Max priority
	 * queue, paralleization and memoizaton are used. By using parallelization we can do multiple fetchs
	 * to the internet at once, instead of doing them in serial. Memoization eliminates the need to 
	 * fetch a set of links from a pages if we have already visited it before. Using a MaxPQ we can logically 
	 * decided in what order we check a link, in an attempt to find the ladder more quickly. If there is no path
	 * from the start page to the end page, return an empty set.
	 * Return: an ArrayList of strings that are in order ladder connections of wiki links from start page to end page.
	 */
	private static List<String> findWikiLadder(String start, String end) {
		MaxPQ linkQueue = new MaxPQ();
		List<String> startLadder = new ArrayList<String>();
		Map<String, Set<String>> linksChecked = new HashMap<String,Set<String>>();
		Set<String> endPageLinks = WikiScraper.findWikiLinks(end);
		startLadder.add(start);
		linkQueue.enqueue(startLadder, 0);
		while(!linkQueue.isEmpty()) {
			Set<String> linksToCheck;
			List<String> ladderStep = linkQueue.dequeue();
			String pageToCheck = ladderStep.get(ladderStep.size()-1);
			if(linksChecked.containsKey(pageToCheck)) {
				linksToCheck = linksChecked.get(pageToCheck);
			} else {
				Set<String> linksOnPage = WikiScraper.findWikiLinks(pageToCheck);
				linksChecked.put(pageToCheck, linksOnPage);
				linksToCheck = linksOnPage;
			}
			if(linksToCheck.contains(end)) {
				ladderStep.add(end);
				return ladderStep;
			}
			linksToCheck.parallelStream().forEach(link -> {
				WikiScraper.findWikiLinks(link);
			});
			for(String link : linksToCheck) {
				if(!linksChecked.containsKey(link)) {
					List<String> carbonLadder = new ArrayList<String>(ladderStep);
					carbonLadder.add(link);
					Set<String> linksOnPage = WikiScraper.findWikiLinks(link);
					// get the intersection of linksOnPage and endPageLinks
					linksOnPage.retainAll(endPageLinks);
					linkQueue.enqueue(carbonLadder,linksOnPage.size());
				}
			}
		}
		List<String> emptyLadder = new ArrayList<String>();
		return emptyLadder;
	}
}
