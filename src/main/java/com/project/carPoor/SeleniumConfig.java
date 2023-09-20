package com.project.carPoor;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SeleniumConfig {

    @Bean
    public WebDriver webDriver() {
        ChromeOptions options = new ChromeOptions();
        // Chrome 드라이버 경로 설정
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        // Chrome 브라우저를 headless 모드로 실행 (화면에 띄우지 않음)
        options.addArguments("--headless");


        return new ChromeDriver();
    }
}
