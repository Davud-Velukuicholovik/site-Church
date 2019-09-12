package com.davyd.site.controller;


import com.davyd.site.dto.request.OrderRequest;
import com.davyd.site.dto.response.OrderResponse;
import com.davyd.site.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public void create(@Valid @RequestBody OrderRequest orderRequest) {
        orderService.create(orderRequest);
    }
    @GetMapping
    public List<OrderResponse> findAll() {
        return orderService.findAll();
    }

    @DeleteMapping
    public void delete(Long id) {
        orderService.deleteOrder(id);
    }
    @PutMapping
    public void update(@Valid @RequestBody OrderRequest request, Long id) throws IOException {
        orderService.update(request, id);
    }

//    @GetMapping("/byUserId/{userId}")
//    public List<OrderResponse> findAllByUsersId(@PathVariable Long userId) {
//        return orderService.findAllByUsersId(userId);
//    }




}
