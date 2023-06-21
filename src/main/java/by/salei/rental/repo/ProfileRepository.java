package by.salei.rental.repo;

import by.salei.rental.entity.Profile;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaSpecificationExecutor<Profile>, PagingAndSortingRepository<Profile, Integer> {
}
