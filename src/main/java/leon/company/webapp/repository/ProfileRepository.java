package leon.company.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import leon.company.webapp.classes.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long>
{
    
}