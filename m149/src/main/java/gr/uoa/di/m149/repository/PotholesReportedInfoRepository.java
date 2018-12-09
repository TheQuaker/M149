package gr.uoa.di.m149.repository;

import gr.uoa.di.m149.domain.PotholesReportedInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotholesReportedInfoRepository extends CrudRepository<PotholesReportedInfo, Integer> {
}
