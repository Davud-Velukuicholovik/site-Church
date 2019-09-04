package com.davyd.site.service;

import com.davyd.site.dto.request.OrderRequest;
import com.davyd.site.dto.request.ProductCountRequest;
import com.davyd.site.dto.response.OrderResponse;
import com.davyd.site.entity.Order;
import com.davyd.site.entity.ProductCount;
import com.davyd.site.exception.NoMatchesException;
import com.davyd.site.repository.OrderRepository;
import com.davyd.site.repository.ProductCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private ProductCountRepository productCountRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductZbutService productZbutService;

    public void create(OrderRequest request) {
        Order order = orderRequestToOrder(null, request);
        order = orderRepository.saveAndFlush(order);
        List<ProductCount> productCounts = orderRequestToProductCounts(request, order);
        productCountRepository.saveAll(productCounts);
    }

    private List<ProductCount> orderRequestToProductCounts(OrderRequest request, Order order) {
        return request.getProductCountRequests().stream().map(p -> productCountRequestToProductCount(p, order)).collect(Collectors.toList());
    }

    private ProductCount productCountRequestToProductCount(ProductCountRequest request, Order order) {
        return ProductCount.builder()
                .count(request.getCount())
                .productZbut(productZbutService.findOne(request.getProductZbutId()))
                .order(order)
                .build();
    }

    private Order orderRequestToOrder(Order order, OrderRequest request) {
        if (order == null) {
            order = new Order();
            order.setDate(LocalDate.now());
            order.setTime(LocalTime.now());
            order.setFinished(false);
            order.setPhoneNumber(request.getPhoneNumber());
            order.setAddress(request.getAddress());
//            order.getAddress();
//            order.getPhoneNumber();
        }
        //other fields
        return order;
    }

    public void update(OrderRequest request, Long id) throws IOException {
        orderRepository.save(orderRequestToOrder(findOne(id), request));
    }

    public Order findOne(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NoMatchesException("Order with id " + id + " not exists"));
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll().stream()
                .map(OrderResponse::new).collect(Collectors.toList());
    }

    public void deleteOrder(Long id) {
        Order order = findOne(id);
        orderRepository.delete(order);
    }

//    public List<OrderResponse> findAllByUsersId(Long userId) {
//        return orderRepository.findAllByUsersId(userId).stream().
//                map(OrderResponse::new).collect(Collectors.toList());
//    }
}
