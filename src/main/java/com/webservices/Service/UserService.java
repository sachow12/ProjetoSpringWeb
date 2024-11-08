package com.webservices.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.webservices.Model.User;
import com.webservices.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
    return userRepository.findAll();
    }
    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }
}
