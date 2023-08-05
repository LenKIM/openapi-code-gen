package com.likelen.openapi.controller;

import com.likelen.openapi_demo.apis.OrderApi;
import com.likelen.openapi_demo.models.SubscriptionOrdersModel;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

class OrderController implements OrderApi {

    @Override
    public ResponseEntity<List<SubscriptionOrdersModel>> showAllOrdersByUsers(String v, String user, String detail) {
        List<SubscriptionOrdersModel> body = new ArrayList<>();
        //something working
        return ResponseEntity.ok(body);
    }
}
