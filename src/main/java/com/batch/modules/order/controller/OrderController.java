package com.batch.modules.order.controller;

import com.batch.modules.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @Scheduled(cron = "0 * * * * *")
    public void insertOrder(){
        orderService.save();
    }
}
