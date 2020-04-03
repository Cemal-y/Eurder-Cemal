package com.cml.eurder.api.controllers;

import com.cml.eurder.domain.order.OrderRepository;
import com.cml.eurder.service.order.OrderDto;
import com.cml.eurder.service.order.OrderService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = OrderController.ORDER_RESOURCE_PATH)
public class OrderController {
    public static final String ORDER_RESOURCE_PATH = "/orders";
    private final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private OrderService orderService;
    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @PreAuthorize("hasAuthority('VIEW_ALL_ORDERS')")
    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Get all orders", notes = "A list of all orders will be returned", response = OrderDto.class)
    @ResponseStatus(HttpStatus.OK)
    public Collection<OrderDto> getAllOrders() {
        logger.info("Returning all orders");
        return orderService.getAllActiveOrders();
    }

    @PreAuthorize("hasAuthority('CREATE_ORDER')")
    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Create order", notes = "A new order will be created", response = OrderDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        logger.info("Creating a new order");
        return orderService.addOrder(orderDto);
    }
}
