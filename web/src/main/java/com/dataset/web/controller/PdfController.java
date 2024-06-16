package com.dataset.web.controller;
import com.dataset.web.model.dataset;
import com.dataset.web.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/datasets")
public class PdfController {

    @Autowired
    private PdfService datasetService;

    @GetMapping
    public String getAllDatasets(Model model) {
        List<dataset> datasets = datasetService.getAllDatasets();
        model.addAttribute("datasets", datasets);
        return "home";
    }
}


