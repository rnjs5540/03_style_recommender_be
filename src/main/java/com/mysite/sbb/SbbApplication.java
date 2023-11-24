package com.mysite.sbb;

import com.mysite.sbb.controller.CodyController;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbbApplication {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe"); // 윈도우

		ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-dev-shm-usage");
		WebDriver driver = new ChromeDriver(options);

		// 무신사 코디맵 페이지 접속
//        driver.get("https://www.musinsa.com/app/codimap/lists?tag_no=" + requestBody.getTag());
//		driver.get("https://www.naver.com");




//		SpringApplication.run(SbbApplication.class, args);
	}

}
