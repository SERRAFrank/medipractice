package org.medipractice.pageserver.repository;

import org.medipractice.pageserver.model.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PageRepository extends CrudRepository<Page, UUID> {

    Optional<Page> findByName(@Param("name") String name);

}
