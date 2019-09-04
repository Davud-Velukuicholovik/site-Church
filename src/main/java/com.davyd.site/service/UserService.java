package com.davyd.site.service;

import com.davyd.site.dto.request.UserRequest;
import com.davyd.site.dto.response.UserResponse;
import com.davyd.site.entity.User;
import com.davyd.site.exception.NoMatchesException;
import com.davyd.site.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductService productService;

    public void save(UserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        userRepository.save(user);
    }
    public List<UserResponse> findAll(String fieldName) {
        return userRepository.findAll(Sort.by(fieldName)).stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public User findOne(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoMatchesException("User with id " + id + " not exists"));
    }
    public void update(UserRequest request, Long id) {
        userRepository.save(userRequestToUser(findOne(id), request));
    }
    public void delete(Long id) {
        User user = findOne(id);
            userRepository.delete(user);
    }


    private User userRequestToUser(User user,UserRequest request) {
        if (user == null) {
            user = new User();
        }
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        return user;
    }

//    public void create(UserRequest request) {
//        User user = new User();
//        user.setPassword(request.getPassword());
//        user.setUsername(request.getUsername());
//        }
//        userRepository.save(user);
//    }
}
