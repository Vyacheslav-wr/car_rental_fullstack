package by.salei.rental.repo;

import by.salei.rental.entity.AuthAccount;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthAccountRepository extends JpaSpecificationExecutor<AuthAccount>, PagingAndSortingRepository<AuthAccount, Integer> {

    AuthAccount findByLogin(String login);

}
