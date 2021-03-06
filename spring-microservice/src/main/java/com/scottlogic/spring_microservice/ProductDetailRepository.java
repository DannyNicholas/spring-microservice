package com.scottlogic.spring_microservice;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * A spring repository - essentially a DAO that is wired together. This gives us
 * CRUD functionality for our ProductDetail entity.
 * 
 * Repository annotation on the interface informs Spring that this class should
 * be respected in its specialized role as a DAO. The annotation also serves as
 * a mechanism by which we can inform the framework to automatically wire it
 * into the microservice's configuration, so that we can get access to it
 * through dependency injection.
 * 
 * @author dnicholas
 *
 */
@Repository
public interface ProductDetailRepository extends PagingAndSortingRepository<ProductDetail, String> {

	@Query("select p from ProductDetail p where UPPER(p.productName) like UPPER(?1) or "
			+ "UPPER(p.longDescription) like UPPER(?1)")
	List<ProductDetail> search(String term);
}