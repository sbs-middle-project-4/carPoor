package com.project.carPoor;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SeleniumConfig {

    @Bean
    public WebDriver webDriver() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // 크롬 드라이버 경로 설정
        return new ChromeDriver();
    }
}
