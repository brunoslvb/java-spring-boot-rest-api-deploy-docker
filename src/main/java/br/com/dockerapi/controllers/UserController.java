package br.com.dockerapi.controllers;

import br.com.dockerapi.interfaces.CommonRequests;
import br.com.dockerapi.models.ApiResponse;
import br.com.dockerapi.models.User;
import br.com.dockerapi.services.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController implements CommonRequests {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ApiResponse<List<User>> findAll(){
        return new ApiResponse<>(userService.findAll());
    }

    @Override
    public ApiResponse<User> findById(@PathVariable Long id){
        return new ApiResponse<>(userService.findById(id));
    }

    @Override
    public ApiResponse<User> save(@RequestBody User user){
        return new ApiResponse<>(userService.save(user));
    }

    @Override
    public ApiResponse<User> update(@PathVariable Long id, @RequestBody User user){
        return new ApiResponse<>(userService.update(id, user));
    }

    @Override
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }
}
