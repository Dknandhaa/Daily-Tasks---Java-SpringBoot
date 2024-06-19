package com.web.service.service;

import com.web.service.entites.dataset;
import com.web.service.repository.datasetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdfService {

    @Autowired
    private datasetRepo datasetRepository;

    public List<dataset> getAllDatasets() {
        return datasetRepository.findAll();
    }
    public String getCurrentUserEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            return userDetails.getUsername(); // assuming the username is the email
        }
        return null;
    }

}
