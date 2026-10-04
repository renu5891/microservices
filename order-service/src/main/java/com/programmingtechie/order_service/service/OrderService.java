package com.programmingtechie.order_service.service;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.programmingtechie.order_service.dto.InventoryResponse;
import com.programmingtechie.order_service.dto.OrderLineItemsDto;
import com.programmingtechie.order_service.dto.OrderRequest;
import com.programmingtechie.order_service.model.Order;
import com.programmingtechie.order_service.model.OrderLineItems;
import com.programmingtechie.order_service.repository.OrderRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    private final WebClient.Builder webClientBuilder;


    public String  placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = new ArrayList<>(orderRequest.getOrderLineItemsDtoList().stream().map(this::mapToDto).toList());

        order.setOrderLineItemsList(orderLineItems);

       List<String> skuCodes= order.getOrderLineItemsList().stream().map(orderLineItem->orderLineItem.getSkuCode()).toList();

        //Call inventory service and place order if product is in stock
      InventoryResponse[] inventoryResponseArray= webClientBuilder.build().get()
       .uri("http://inventory-service/api/inventory",
       uriBuilder->uriBuilder.queryParam("skuCode",skuCodes).build()).retrieve().bodyToMono(InventoryResponse[].class).block();

       boolean allProductsInStock=Arrays.stream(inventoryResponseArray).allMatch(inventoryResponse->inventoryResponse.isInStock());

    if (!allProductsInStock) {
        throw new IllegalArgumentException("Product is not in stock,please try again later");
       }

        orderRepository.save(order);
        return "Order Placed Successfully";
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems orderLineItems=new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;

    }
    
}
