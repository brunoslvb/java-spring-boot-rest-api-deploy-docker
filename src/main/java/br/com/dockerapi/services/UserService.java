package br.com.dockerapi.services;

import br.com.dockerapi.interfaces.CommonServices;
import br.com.dockerapi.exceptions.ObjectNotFoundException;
import br.com.dockerapi.models.User;
import br.com.dockerapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements CommonServices {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new ObjectNotFoundException("Usuário '" + id + "' não encontrado na base de dados"));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        return userRepository.save(this.findById(id));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(this.findById(id).getId());
    }
}
