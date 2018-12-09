package gr.uoa.di.m149.repository;

import gr.uoa.di.m149.domain.AbandonedVehiclesInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbandonedVehicleInfoRepository extends CrudRepository<AbandonedVehiclesInfo, Integer>{

}
