package gr.uoa.di.m149.repository;

import gr.uoa.di.m149.domain.RodentBaitingInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RodentBaitingInfoRepository extends CrudRepository<RodentBaitingInfo, Integer> {
}
