//package com.psql.demo.service;
//
//import com.psql.demo.model.quote;
//import com.psql.demo.repo.quoterepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
////import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.List;
////import java.time.format.DateTimeFormatter;
//
//@Service
//public class QuoteService {
//
//    @Autowired
//    private quoterepo quoteRepository;
//
//    private QuoteService quoteService;
//    // Make sure this is injected correctly
//
//
//    // this page will act as a service page that get appends data using quote page and connect the quote by using repo
//    public void fetchQuotes() {
//        String apiUrl = "https://api.quotable.io/quotes";
//        RestTemplate restTemplate = new RestTemplate();
//        QuoteResponse response = restTemplate.getForObject(apiUrl, QuoteResponse.class);
//
//        if (response != null) {
//            Arrays.stream(response.getResults()).forEach(quoteApi -> {
//                if (!quoteRepository.existsByQuoteId(quoteApi.get_id())) {
//                    quote quote = new quote();
//                    quote.setQuoteId(quoteApi.get_id());
//                    quote.setAuthor(quoteApi.getAuthor());
//                    quote.setContent(quoteApi.getContent());
//                    quote.setDateAdded(quoteApi.getDateAdded());
//                    quote.setDateModified(quoteApi.getDateModified());
//                    quoteRepository.save(quote);
//                    }
//            });
//        }
//    }
//
//
//    public List<quote> getAllQuotes() {
//        return quoteRepository.findAll(); // Ensure this is called on the instance variable
//    }
//}
//
//class QuoteResponse {
//    private QuoteApi[] results;
//
//    public QuoteApi[] getResults() {
//        return results;
//    }
//
//    public void setResults(QuoteApi[] results) {
//        this.results = results;
//    }
//
//    static class QuoteApi {
//        private String _id;
//        private String author;
//        private String content;
//        private String dateAdded; // Changed to match Java conventions
//        private String dateModified;
////        private LocalDate dateAdded; // Changed to match Java conventions
////        private LocalDate dateModified;
//
//        // Getters and Setters
//        public String get_id() {
//            return _id;
//        }
//
//        public void set_id(String _id) {
//            this._id = _id;
//        }
//
//        public String getAuthor() {
//            return author;
//        }
//
//        public void setAuthor(String author) {
//            this.author = author;
//        }
//
//        public String getContent() {
//            return content;
//        }
//
//        public void setContent(String content) {
//            this.content = content;
//        }
//
//        public String getDateAdded() {
//            return dateAdded;
//        }
//
//        public void setDateAdded(String dateAdded) {
//            this.dateAdded = dateAdded;
//        }
//
//        public String getDateModified() {
//            return dateModified;
//        }
//
//        public void setDateModified(String dateModified) {
//            this.dateModified = dateModified;
//        }
//
////        public LocalDate getDateAdded() {
////            return dateAdded;
////        }
////
////        public void setDateAdded(LocalDate dateAdded) {
////            this.dateAdded = dateAdded;
////        }
////
////        public LocalDate getDateModified() {
////            return dateModified;
////        }
////
////        public void setDateModified(LocalDate dateModified) {
////            this.dateModified = dateModified;
////        }
//    }
//}
//
package com.psql.demo.service;

import com.psql.demo.model.quote;
import com.psql.demo.repo.quoterepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class QuoteService {

    @Autowired
    private quoterepo quoteRepository;

    public void fetchAndSaveQuotes() {
        String apiUrl = "https://api.quotable.io/quotes";
        RestTemplate restTemplate = new RestTemplate();
        QuoteResponse response = restTemplate.getForObject(apiUrl, QuoteResponse.class);

        if (response != null) {
            Arrays.stream(response.getResults()).forEach(quoteApi -> {
                if (!quoteRepository.existsByQuoteId(quoteApi.get_id())) {
                    quote quote = new quote();
                    quote.setQuoteId(quoteApi.get_id());
                    quote.setAuthor(quoteApi.getAuthor());
                    quote.setContent(quoteApi.getContent());
                    quote.setDateAdded(quoteApi.getDateAdded());
                    quote.setDateModified(quoteApi.getDateModified());
                    quoteRepository.save(quote);
                }
            });
        }
    }

    public List<quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    static class QuoteResponse {
        private QuoteApi[] results;

        public QuoteApi[] getResults() {
            return results;
        }

        public void setResults(QuoteApi[] results) {
            this.results = results;
        }

        static class QuoteApi {
            private String _id;
            private String author;
            private String content;
            private String dateAdded;
            private String dateModified;

            // Getters and Setters
            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getDateAdded() {
                return dateAdded;
            }

            public void setDateAdded(String dateAdded) {
                this.dateAdded = dateAdded;
            }

            public String getDateModified() {
                return dateModified;
            }

            public void setDateModified(String dateModified) {
                this.dateModified = dateModified;
            }
        }
    }
}
