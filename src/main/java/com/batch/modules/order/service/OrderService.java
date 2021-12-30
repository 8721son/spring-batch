package com.batch.modules.order.service;

import com.batch.modules.order.dto.entity.OrderEntity;
import com.batch.modules.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void save(){
        Random rand = new Random();
        int price = rand.nextInt(26);
        price+=65;
        char name = (char)price;
        int cnt = rand.nextInt(10) + 1;
        price*=100;
        String store="";
        if(price<7500){
            store="suyeong";
        }else if(price<8500){
            store="centom";
        }else{
            store="gwangan";
        }
        orderRepository.save(
                OrderEntity.builder()
                        .store(store)
                        .name(Character.toString(name))
                        .price((long)price)
                        .productCount((long)cnt)
                        .totalPrice((long)price*cnt)
                        .build());
    }
}
