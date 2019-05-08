package jim.pers.jerp.controllers;

import jim.pers.jerp.annotation.AuthToken;
import jim.pers.jerp.mapper.GoodsMapper;
import jim.pers.jerp.mapper.GoodsTypeMapper;
import jim.pers.jerp.mapper.SupplierMapper;
import jim.pers.jerp.model.Goods;
import jim.pers.jerp.model.GoodsType;
import jim.pers.jerp.model.Supplier;
import jim.pers.jerp.model.Unit;
import jim.pers.jerp.utils.PojoToMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GoodsController {
    @Autowired
    GoodsMapper goodsMapper;

    @AuthToken
    @PostMapping("/units")
    public Flux<Unit> getUnits(){
        return Flux.fromIterable(goodsMapper.getUnits());
    }

    @AuthToken
    @PostMapping("/goods/set")
    public Mono<Integer> setGoods(@RequestBody Mono<Goods> goods){
        return  goods.map(gt ->{
            int uuid =  goodsMapper.setGoods(gt);
            return  uuid;
        });
    }
}
