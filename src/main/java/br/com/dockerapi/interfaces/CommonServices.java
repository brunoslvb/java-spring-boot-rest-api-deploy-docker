package br.com.dockerapi.interfaces;

import br.com.dockerapi.models.User;

import java.util.List;

public interface CommonServices {

    List<User> findAll();

    User findById(Long id);

    User save(User user);

    User update(Long id, User user);

    void deleteById(Long id);
}
