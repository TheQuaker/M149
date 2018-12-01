package gr.uoa.di.m149.repository;

import gr.uoa.di.m149.domain.ChicagoRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChicagoRequestRepository extends CrudRepository<ChicagoRequest, Integer>{

}
