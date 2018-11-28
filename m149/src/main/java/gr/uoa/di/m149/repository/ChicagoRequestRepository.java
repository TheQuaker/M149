package gr.uoa.di.m149.repository;

import gr.uoa.di.m149.domain.ChicagoRequest;
import gr.uoa.di.m149.domain.TypeTotalRequests;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ChicagoRequestRepository extends CrudRepository<ChicagoRequest, Integer>{

}
