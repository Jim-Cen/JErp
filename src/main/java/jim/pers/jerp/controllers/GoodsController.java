package jim.pers.jerp.controllers;

import jim.pers.jerp.mapper.GoodsTypeMapper;
import jim.pers.jerp.model.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GoodsController {
    @Autowired
    GoodsTypeMapper goodsTypeMapper;

    @PostMapping("/goodstype/set")
    public Mono<Integer> setGoodsType(@RequestBody Mono<GoodsType> goodsType){
        return  goodsType.map(gt ->{
             int uuid =  goodsTypeMapper.setGoodsType(gt.getName(),gt.getSupplierUuid());
             return  uuid;
        });
    }
}
