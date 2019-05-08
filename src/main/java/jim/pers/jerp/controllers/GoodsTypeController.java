package jim.pers.jerp.controllers;

import jim.pers.jerp.annotation.AuthToken;
import jim.pers.jerp.mapper.GoodsTypeMapper;
import jim.pers.jerp.mapper.SupplierMapper;
import jim.pers.jerp.model.GoodsType;
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
@RequestMapping("/goodstype")
public class GoodsTypeController {
    @Autowired
    GoodsTypeMapper goodsTypeMapper;

    @Autowired
    SupplierMapper supplierMapper;

    @AuthToken
    @GetMapping
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Flux<Map> getGoodTypes(ServerHttpRequest request){
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
    @PostMapping
    @Transactional(propagation = Propagation.REQUIRED)
    public Mono<Map> addGoodsType(ServerHttpRequest request, @RequestBody Mono<GoodsType> goodsType){
        return  goodsType.map(gt ->{
            goodsTypeMapper.addGoodsType(gt);
            HashMap hashMap = new HashMap<String,String>();
            PojoToMap.Convert(gt,hashMap);
            String supplierName = supplierMapper.getSupplierByUuid(gt.getSupplierUuid()).getName();
            hashMap.put("supplierName",supplierName);
            return  hashMap;
        });
    }

    @PutMapping
    @AuthToken
    @Transactional(propagation = Propagation.REQUIRED)
    public Mono<Map>  updateGoodsType(ServerHttpRequest request, @RequestBody Mono<GoodsType> goodsType) {
        return goodsType.map( gt -> {
            goodsTypeMapper.updateGoodsType(gt);
            HashMap hashMap = new HashMap<String,String>();
            PojoToMap.Convert(gt,hashMap);
            String supplierName = supplierMapper.getSupplierByUuid(gt.getSupplierUuid()).getName();
            hashMap.put("supplierName",supplierName);
            return  hashMap;
        });
    }

    @DeleteMapping
    @AuthToken
    @Transactional(propagation = Propagation.REQUIRED)
    public Mono<Integer> deleteGoodsType(ServerHttpRequest request,@RequestBody Mono<GoodsType> goodsType) {
        return goodsType.map( gt -> {
            return  goodsTypeMapper.deleteGoodsType(gt.getUuid());
        });
    }

}
