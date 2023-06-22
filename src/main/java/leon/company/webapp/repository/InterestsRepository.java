package leon.company.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import leon.company.webapp.classes.Interests;

@Repository
public interface InterestsRepository extends CrudRepository<Interests, Long>
{
    
}