package net.comdude2.apps.carlookup.main;

import java.util.LinkedList;

/**
 * Holds the contents of a page
 * @author comdude2
 */
public class Page {
	
	private String pageName = null;
	private LinkedList <String> pageContent = null;
	
	public Page(String name, LinkedList <String> content) {
		this.pageName = name;
		this.pageContent = content;
	}
	
	public String getPageName() {
		return this.pageName;
	}
	
	public LinkedList <String> getPageContent(){
		return this.pageContent;
	}
	
	public void print() {
		System.out.println("Address: " + this.pageName);
		System.out.println("");
		System.out.println("Content:");
		for (String l : this.pageContent) {
			System.out.println(l);
		}
		System.out.println("");
		System.out.println("Page line length: " + this.pageContent.size());
	}
	
}
