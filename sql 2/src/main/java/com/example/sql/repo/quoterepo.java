package com.example.sql.repo;
import com.example.sql.model.quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// this page creates a connction between the database and this page
@RepositoryRestResource
public interface quoterepo extends JpaRepository<quote,Long> {
    boolean existsByQuoteId(String quoteId);
}
