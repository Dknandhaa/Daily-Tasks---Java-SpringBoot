package com.psql.demo.repo;
import com.psql.demo.model.quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// this page creates a connction between the database and this page
@RepositoryRestResource
public interface quoterepo extends JpaRepository<quote,Long> {
    boolean existsByQuoteId(String quoteId);
}
