package by.salei.rental.repo;

import by.salei.rental.entity.UserRole;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaSpecificationExecutor<UserRole>, PagingAndSortingRepository<UserRole, Integer> {
}
