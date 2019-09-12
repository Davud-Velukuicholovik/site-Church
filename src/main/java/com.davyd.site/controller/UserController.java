package com.davyd.site.controller;

import antlr.collections.List;
import com.davyd.site.dto.request.UserRequest;
import com.davyd.site.dto.response.UserResponse;
import com.davyd.site.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
//import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void save(@Valid @RequestBody UserRequest request) {
        userService.save(request);
    }

    @GetMapping
    public List<UserResponse> findAll(@RequestParam(defaultValue = "id") String fieldName) {
        return userService.findAll(fieldName);
    }
    @PutMapping
    public void update(@Valid @RequestBody UserRequest request, Long id) {
        userService.update(request, id);
    }

    @DeleteMapping
    public void delete(Long id) {
        userService.delete(id);
    }
}
