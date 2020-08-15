package exam;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupEx {
	
	String url;
	Document doc;	
	Elements elements;
	
	public JsoupEx() {
		// TODO Auto-generated constructor stub
		url = "http://localhost/aspTest_201607058/tutoring/index.aspx";
		try {
			doc= Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectAndPrint() {
		
		elements = doc.select("ul.tot");
		Iterator<Element> ie = elements.select("a.stu").iterator();
		
		while(ie.hasNext()) {
			System.out.println(ie.next().text());
		}
		
		
	}
	
	
}
