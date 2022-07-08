package br.com.dockerapi.interfaces;

import br.com.dockerapi.models.ApiResponse;
import br.com.dockerapi.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CommonRequests {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    ApiResponse<List<User>> findAll();

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    ApiResponse<User> findById(Long id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ApiResponse<User> save(User user);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<User> update(Long id, User user);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(Long id);
}
