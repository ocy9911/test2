package Crawling;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CrawlingMain {

	public static void main(String[] args) {
		// 1. 크롤링 하기 위해서는 url저장 
		
		String url ="https://www.naver.com/";
		
		// 외부에 있는 데이터와 통신을 하려면 에러가
		// 발생할 수있다(예외가 발생)
		try {
			// 2. 연결 
			// Document  html문서 생성시
			// 저장하는 클래스 타입 
			// connect(url) : 페이지 주소의 문자열 가져온다.
			// get() 이용해서 html 문서를 가져온다.
			
			Document doc = Jsoup
						  .connect(url)
						  .get();
			
			//3. 위에서 연결 됨 확인하는 출력
			//System.out.println(doc);
			
			//4. 타이틀 꺼내기
			String title=doc.title();
			
			System.out.println(title);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
