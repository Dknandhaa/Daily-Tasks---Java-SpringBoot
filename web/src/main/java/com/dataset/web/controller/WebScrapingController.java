package com.dataset.web.controller;


import com.dataset.web.service.WebScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
public class WebScrapingController {

    @Autowired
    private WebScrapingService pdfDownloaderService;

    @GetMapping("/scrape")
    public String downloadPdfs(@RequestParam String websiteUrl) {
        try {
            pdfDownloaderService.downloadPdfsFromWebsite(websiteUrl);
            return "PDFs downloaded successfully!";
        } catch (IOException e) {
            return "Error downloading PDFs: " + e.getMessage();
        }
    }
}
//http://localhost:8080/scrape?url=https://catalog.data.gov/dataset/?res_format=PDF