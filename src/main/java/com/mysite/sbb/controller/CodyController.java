package com.mysite.sbb.controller;

import com.mysite.sbb.packet.requestbody.CodyRequestBody;
import com.mysite.sbb.packet.responsebody.CodyResponseBody;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.openqa.selenium.chrome.ChromeOptions;

@Controller
//@CrossOrigin(allowedHeaders = "*")
public class CodyController {
    @PostMapping("/codies")
    public List<CodyResponseBody> crawling_codies(@RequestBody CodyRequestBody requestBody){

        final int CODY_COUNT = 12;
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe"); // 윈도우
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        // 무신사 코디맵 페이지 접속
        driver.get("https://www.musinsa.com/app/codimap/lists?tag_no=" + requestBody);

        // 1. 드라이버 설치 경로
        public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
        public static String WEB_DRIVER_PATH = "C:/chromedriver/chromedriver.exe";

        List<CodyResponseBody> responseBodies = new ArrayList<>();

        // 셀레니움으로 responseBodies에 코디들 넣기

        return responseBodies;
    }

}
