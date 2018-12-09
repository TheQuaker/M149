package gr.uoa.di.m149.repository;

import gr.uoa.di.m149.domain.GraffitiRemovalInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraffitiRemovalInfoRepository extends CrudRepository<GraffitiRemovalInfo, Integer> {
}
