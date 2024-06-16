package com.dataset.web.repository;


import com.dataset.web.model.dataset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface datasetRepo extends JpaRepository<dataset, Long> {
}
