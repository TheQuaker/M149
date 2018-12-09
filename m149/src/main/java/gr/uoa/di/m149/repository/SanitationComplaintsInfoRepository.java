package gr.uoa.di.m149.repository;

import gr.uoa.di.m149.domain.SanitationComplaintsInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanitationComplaintsInfoRepository extends CrudRepository<SanitationComplaintsInfo, Integer> {
}
