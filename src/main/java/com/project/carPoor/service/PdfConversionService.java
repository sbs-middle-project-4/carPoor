package com.project.carPoor.service;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class PdfConversionService {

    private final WebDriver webDriver;

    public PdfConversionService() {
        ChromeOptions options = new ChromeOptions();
        // Chrome 드라이버 경로 설정
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        // Chrome 브라우저를 headless 모드로 실행 (화면에 띄우지 않음)
        options.addArguments("--headless");

        webDriver = new ChromeDriver(options);
    }

    public void convertHtmlToPdf(String url, String outputFilePath) throws IOException {
        // 웹 페이지 열기
        webDriver.get(url);

        // 특정 버튼을 찾고 클릭
        WebElement button = webDriver.findElement(By.id("downloadButton"));
        button.click();

        // 스크린샷 찍기
        TakesScreenshot screenshot = (TakesScreenshot) webDriver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);

        // 스크린샷 파일을 BufferedImage로 읽어들임
        BufferedImage bufferedImage = ImageIO.read(screenshotFile);

        // 스크린샷을 PDF로 변환
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        PDImageXObject image = JPEGFactory.createFromImage(document, bufferedImage);
        contentStream.drawImage(image, 0, 0, PDRectangle.A4.getWidth(), PDRectangle.A4.getHeight());
        contentStream.close();

        // PDF 파일로 저장
        document.save(outputFilePath);
        document.close();
    }

    public void closeWebDriver() {
        webDriver.quit();
    }
}
