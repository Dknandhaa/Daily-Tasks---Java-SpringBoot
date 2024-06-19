package com.web.service.repository;

import com.web.service.entites.dataset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface datasetRepo extends JpaRepository<dataset, Long> {

}
