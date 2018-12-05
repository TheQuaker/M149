package gr.uoa.di.m149.repository;

import gr.uoa.di.m149.domain.ChicagoRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChicagoRequestRepository extends CrudRepository<ChicagoRequest, Integer>{

    public Integer countByByZipcodeAndStreetaddressLike(int zipcode, String streetaddress);
    public List<ChicagoRequest> findAllByZipcodeAndStreetaddressLike(int zipcode, String streetaddress, Pageable page);
    public List<ChicagoRequest> findAllByStreetaddressLike(String streetaddress, Pageable page);
}
