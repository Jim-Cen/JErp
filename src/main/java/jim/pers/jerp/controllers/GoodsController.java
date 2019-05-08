package jim.pers.jerp.controllers;

import jim.pers.jerp.annotation.AuthToken;
import jim.pers.jerp.mapper.GoodsMapper;
import jim.pers.jerp.mapper.GoodsTypeMapper;
import jim.pers.jerp.mapper.SupplierMapper;
import jim.pers.jerp.model.Goods;
import jim.pers.jerp.model.GoodsType;
import jim.pers.jerp.model.Unit;
import jim.pers.jerp.utils.PojoToMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GoodsController {
    @Autowired
    GoodsTypeMapper goodsTypeMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    SupplierMapper supplierMapper;

    @AuthToken
    @PostMapping("/units")
    public Flux<Unit> getUnits(){
        return Flux.fromIterable(goodsMapper.getUnits());
    }

    @AuthToken
    @GetMapping("/goodstype")
    public Flux<Map> getGoodTypes(){
        return Flux.fromIterable(goodsTypeMapper.getGoodsTypeAll()).map(
                goodsType -> {
                    HashMap hashMap = new HashMap<String,String>();
                    PojoToMap.Convert(goodsType,hashMap);
                    String supplierName = supplierMapper.getSupplierByUuid(goodsType.getSupplierUuid()).getName();
                    hashMap.put("supplierName",supplierName);
                    return  hashMap;
                });
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
