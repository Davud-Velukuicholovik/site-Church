package com.davyd.site.dto.response;

import com.davyd.site.entity.Order;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime time;
    private String phoneNumber;
    private String address;
    private Boolean finished;
//    @JsonProperty("products")
//    private UserResponse userResponse;

    public OrderResponse(Order order) {
        id = order.getId();
        date = order.getDate();
        time = order.getTime();
        phoneNumber = order.getPhoneNumber();
        address = order.getAddress();
        finished = order.getFinished();
//        userResponse = new UserResponse(order.getUser());

    }
}
