package com.web.service.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "dataset")
public class dataset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Getter
    @Setter
    private String pdfName;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String pdfUrl;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

//    public String getPdfName() {
//        return pdfName;
//    }
//
//    public void setPdfName(String pdfName) {
//        this.pdfName = pdfName;
//
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description =  description;
//
//    }
//
//    public String getPdfUrl() {
//        return pdfUrl;
//    }
//
//    public void setPdfUrl(String pdfUrl) {
//        this.pdfUrl = pdfUrl;
//
//    }


}


