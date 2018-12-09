package gr.uoa.di.m149.repository;

import gr.uoa.di.m149.domain.ChicagoRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChicagoRequestRepository extends CrudRepository<ChicagoRequest, Integer>{

    List<ChicagoRequest> findAllByZipcodeAndStreetaddressLike(int zipcode, String streetaddress);
    List<ChicagoRequest> findAllByStreetaddressLike(String streetaddress);

    @Query("select distinct typeofservicerequest from ChicagoRequest ")
    List<String> getTypeOfServiceRequests();

    @Query("select count(requestid) from ChicagoRequest ")
    long getLastId();
}
