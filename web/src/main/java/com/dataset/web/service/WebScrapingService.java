package com.dataset.web.service;

import com.dataset.web.model.dataset;
import com.dataset.web.repository.datasetRepo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;


@Service
public class WebScrapingService {

    @Autowired
    private datasetRepo repo;

    public void downloadPdfsFromWebsite(String websiteUrl) throws IOException {
        Document document = Jsoup.connect(websiteUrl).get();
        Elements links = document.select("a[href$=.pdf]"); // Select links ending with .pdf
        Elements names = document.select(".dataset-item .dataset-content .dataset-heading a");
        Elements descriptions = document.select(".dataset-item .dataset-content .notes div");

//        for (Element link : links) {
//            String pdfUrl = link.absUrl("href");
//            pdfInfo.setPdfUrl(pdfUrl);
//        }
//
//        for (Element name : names) {
//            String title = name.text();
//            pdfInfo.setPdfName(title);
//
//        }
//
//        for (Element desc : descriptions) {
//            String pdfdesc = desc.text();
//            pdfInfo.setDescription(pdfdesc);
//
//        }
//        repo.save(pdfInfo);
        for (int i = 0; i < links.size(); i++) {

            dataset pdfInfo = new dataset();

            Element link = links.get(i);
            Element name = names.get(i);
            Element desc = descriptions.get(i);

            String pdfUrl = link.absUrl("href");
            String title = name.text();
            String pdfdesc = desc.text();

            pdfInfo.setPdfUrl(pdfUrl);
            pdfInfo.setPdfName(title);
            pdfInfo.setDescription(pdfdesc);
            repo.save(pdfInfo);


        }
    }

}


