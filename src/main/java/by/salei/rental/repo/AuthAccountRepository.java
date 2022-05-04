package by.salei.rental.repo;

import by.salei.rental.entity.AuthAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthAccountRepository extends CrudRepository<AuthAccount, Integer> {

    AuthAccount findByLogin(String login);

}
