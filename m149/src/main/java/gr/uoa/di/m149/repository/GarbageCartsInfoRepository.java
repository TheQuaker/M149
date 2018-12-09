package gr.uoa.di.m149.repository;

import gr.uoa.di.m149.domain.GarbageCartsInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarbageCartsInfoRepository extends CrudRepository<GarbageCartsInfo, Integer> {
}
