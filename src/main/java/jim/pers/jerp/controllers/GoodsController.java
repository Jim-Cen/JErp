package jim.pers.jerp.controllers;

import jim.pers.jerp.annotation.AuthToken;
import jim.pers.jerp.mapper.GoodsMapper;
import jim.pers.jerp.mapper.GoodsTypeMapper;
import jim.pers.jerp.model.Goods;
import jim.pers.jerp.model.Unit;
import jim.pers.jerp.utils.PojoToMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GoodsController {
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GoodsTypeMapper goodsTypeMapper;

    @AuthToken
    @GetMapping("/units")
    public Mono<List> getUnits(ServerHttpRequest request){
        return Mono.just(goodsMapper.getUnits());
    }

    @AuthToken
    @GetMapping("/goods")
    public Flux<Map> getGoods(ServerHttpRequest request){
        Map<Integer,Unit> units = goodsMapper.getUnitsMap();
       return Flux.fromIterable(goodsMapper.getAllGoods())
                  .map(g ->{
                      Map result = new HashMap();
                      PojoToMap.Convert(g,result);
                      result.put("unitDesc",units.get(g.getUnitUuid()).getName());
                      result.put("goodsTypeDesc",goodsTypeMapper.getGoodsTypeByUuid(g.getGoodsTypeUuid()).getName());
                      return  result;
                  });
    }

    @AuthToken
    @PostMapping("/goods")
    public Mono<Map> addGoods(ServerHttpRequest request,@RequestBody Mono<Goods> goods){
        Map<Integer,Unit> units = goodsMapper.getUnitsMap();
        return  goods.map(g ->{
            goodsMapper.addGoods(g);
            Map result = new HashMap();
            PojoToMap.Convert(g,result);
            result.put("unitDesc",units.get(g.getUnitUuid()).getName());
            result.put("goodsTypeDesc",goodsTypeMapper.getGoodsTypeByUuid(g.getGoodsTypeUuid()).getName());
            return  result;
        });
    }

    @PutMapping
    @AuthToken
    @Transactional(propagation = Propagation.REQUIRED)
    public Mono<Map>  updateGoodsType(ServerHttpRequest request, @RequestBody Mono<Goods> goods) {
        Map<Integer,Unit> units = goodsMapper.getUnitsMap();
        return goods.map( gs -> {
            goodsMapper.updateGoods(gs);
            HashMap hashMap = new HashMap<String,String>();
            PojoToMap.Convert(gs,hashMap);
            hashMap.put("unitDesc",units.get(gs.getUnitUuid()).getName());
            hashMap.put("goodsTypeDesc",goodsTypeMapper.getGoodsTypeByUuid(gs.getGoodsTypeUuid()).getName());
            return  hashMap;
        });
    }

    @DeleteMapping
    @AuthToken
    @Transactional(propagation = Propagation.REQUIRED)
    public Mono<Integer> deleteGoodsType(ServerHttpRequest request,@RequestBody Mono<Goods> goods) {
        return goods.map( gs -> {
            return  goodsMapper.deleteGoods(gs.getUuid());
        });
    }
}
