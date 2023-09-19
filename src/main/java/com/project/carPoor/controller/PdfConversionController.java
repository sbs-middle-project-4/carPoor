package com.project.carPoor.controller;

import com.project.carPoor.service.PdfConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController


public class PdfConversionController {

    @Autowired
    private PdfConversionService pdfConversionService;


    @PostMapping("/generatePdf")
    public ResponseEntity<String> generatePdf(@RequestParam("url") String url) {
        // PDF 생성 로직을 호출하고, 생성된 PDF 파일을 반환 또는 다운로드할 수 있는 방법
        // 예: PdfConversionService를 호출하여 PDF를 생성하고 파일 경로를 반환
        // 그 후 클라이언트에게 파일 다운로드 링크를 전달하거나 PDF를 표시할 수 있음
        String outputPath = "C:\\path\\output.pdf";
        try {
            pdfConversionService.convertHtmlToPdf(url, outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pdfConversionService.closeWebDriver();
        }
        // PDF 생성 로직은 PdfConversionService에 있어야 함

        return ResponseEntity.ok(outputPath); // PDF 다운로드 링크로 리다이렉트
    }

    @RequestMapping("/downloadPdf")
    public String downloadPdf() {
        // PDF 파일 다운로드 또는 표시 로직
        // 클라이언트에게 PDF 파일을 제공

        return "pdfDownloadView"; // PDF 다운로드 뷰로 이동
    }


}
