package Crawling;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingMain3 {

	public static void main(String[] args) {
		ArrayList<String> movieList = new ArrayList<String>();
		try {
			// 1. url
			String url = "https://www.cgv.co.kr/";

			// 2. 연결
			Document doc = Jsoup.connect(url).get();
			// 3.출력
			// System.out.println(doc);

			// 이미지를 둘러쌓고 있는 테두리인
			// img_wrap 그룹으로 찾는다.
			Elements images = doc.getElementsByClass("img_wrap");

			// System.out.println(images);
			// 각 img_wrap 내의 이미지 링크를 가져오기
			for (Element temp : images) {

				// selectFirst()
				// 선택한 요소들 중에서 첫 번째 요소를 선택한다.
				Element img = temp.selectFirst("img");
				// System.out.println(img);
				if (img != null) {
					// 이미지 태그 안에 경로를 (속성)
					// attr()메서드를 이용한다.
					String imgUrl = img.attr("src");
					movieList.add(imgUrl);
				}

			}
			Elements info = doc.getElementsByClass("movie_info_wrap");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//이미지랑 영화 제목이랑 한꺼번에 저장하는 클래스
	class Movie {

		private String title;
		private String imageURL;

		public Movie(String title, String imageURL) {
			this.title = title;
			this.imageURL = imageURL;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getImageURL() {
			return imageURL;
		}

		public void setImageURL(String imageURL) {
			this.imageURL = imageURL;
		}

		@Override
		public String toString() {
			return "Movie [title=" + title + ", imageURL=" + imageURL + "]";
		}
	}
}
