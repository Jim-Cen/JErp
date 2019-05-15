package jim.pers.jerp.controllers;

import jim.pers.jerp.annotation.AuthToken;
import jim.pers.jerp.mapper.PurchOrderMapper;
import jim.pers.jerp.model.PurchOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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
}
