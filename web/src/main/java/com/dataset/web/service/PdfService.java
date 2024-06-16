package com.dataset.web.service;

import com.dataset.web.model.dataset;
import com.dataset.web.repository.datasetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdfService {

    @Autowired
    private datasetRepo datasetRepository;

    public List<dataset> getAllDatasets() {
        return datasetRepository.findAll();
    }
}
