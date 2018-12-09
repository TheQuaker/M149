package gr.uoa.di.m149.repository;

import gr.uoa.di.m149.domain.SSA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SSARepository extends CrudRepository<SSA, Integer> {
}
