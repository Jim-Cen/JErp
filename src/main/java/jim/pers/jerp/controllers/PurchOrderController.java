package jim.pers.jerp.controllers;

import jim.pers.jerp.annotation.AuthToken;
import jim.pers.jerp.mapper.PurchOrderMapper;
import jim.pers.jerp.model.PurchOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/purchorder")
public class PurchOrderController {
    @Autowired
    PurchOrderMapper purchOrderMapper;

    @GetMapping
    @AuthToken
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Flux<PurchOrder> getAll(ServerHttpRequest request){
        return  Flux.fromIterable(purchOrderMapper.getAllPurchOrders());
    }

    @PostMapping
    @AuthToken
    @Transactional(propagation = Propagation.REQUIRED)
    public Mono<PurchOrder> addPurchOrder(ServerHttpRequest request){
        HttpHeaders headers = request.getHeaders();
        int creator = Integer.parseInt(headers.getFirst("clientId"));
        PurchOrder purchOrder = new PurchOrder();
        purchOrder.setCreator(creator);
        purchOrder.setCreateTime(new Date());
        purchOrder.setOrderNo(UUID.randomUUID().toString());
        purchOrderMapper.addPurchOrder(purchOrder);
        //create OrderNo
        String orderNo = createOrderNo(purchOrder.getUuid());
        purchOrder.setOrderNo(orderNo);
        //update Order
        purchOrderMapper.updatePurchOrder(purchOrder);
        return  Mono.just(purchOrder);
    }

    private static String createOrderNo(int uuid){
        String orderNo = "000000000"+uuid;
        return orderNo.substring(orderNo.length() - 8);
    }

}
