package com.dataset.web.model;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "dataset")
public class dataset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    private String pdfName;
    private String description;
    private String pdfUrl;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        System.out.println(id);
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
        System.out.println(pdfName);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description =  description;
        System.out.println(this.description);
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
        System.out.println(this.pdfUrl);
    }


}


