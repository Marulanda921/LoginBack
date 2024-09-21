package Riwi.LoginUsers.Infraestructure.Persistence.Repository;

import Riwi.LoginUsers.Domain.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
