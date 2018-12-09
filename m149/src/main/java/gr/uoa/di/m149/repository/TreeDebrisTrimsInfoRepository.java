package gr.uoa.di.m149.repository;

import gr.uoa.di.m149.domain.TreeDebrisTrimsInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeDebrisTrimsInfoRepository extends CrudRepository<TreeDebrisTrimsInfo, Integer> {
}
