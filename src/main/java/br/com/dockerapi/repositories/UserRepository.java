package br.com.dockerapi.repositories;

import br.com.dockerapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
