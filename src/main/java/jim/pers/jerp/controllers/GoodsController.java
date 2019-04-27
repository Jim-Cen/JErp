package jim.pers.jerp.controllers;

import jim.pers.jerp.annotation.AuthToken;
import jim.pers.jerp.mapper.GoodsMapper;
import jim.pers.jerp.mapper.GoodsTypeMapper;
import jim.pers.jerp.model.Goods;
import jim.pers.jerp.model.GoodsType;
import jim.pers.jerp.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class GoodsController {
    @Autowired
    GoodsTypeMapper goodsTypeMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @AuthToken
    @PostMapping("/units")
    public Flux<Unit> getUnits(){
        return Flux.fromIterable(goodsMapper.getUnits());
    }

    @AuthToken
    @PostMapping("/goodstypes")
    public Flux<GoodsType> getGoodTypes(){
        return Flux.fromIterable(goodsTypeMapper.getGoodsTypeAll());
    }

    @AuthToken
    @PostMapping("/goodstype/set")
    public Mono<Integer> setGoodsType(@RequestBody Mono<GoodsType> goodsType){
        return  goodsType.map(gt ->{
             int uuid =  goodsTypeMapper.setGoodsType(gt.getName(),gt.getSupplierUuid());
             return  uuid;
        });
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
