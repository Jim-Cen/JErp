package jim.pers.jerp.controllers;

import jim.pers.jerp.annotation.AuthToken;
import jim.pers.jerp.mapper.SupplierMapper;
import jim.pers.jerp.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierMapper supplierMapper;

    @GetMapping
    @AuthToken
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Flux<Supplier> getAll(ServerHttpRequest request){
        return  Flux.fromIterable(supplierMapper.getAllSuppliers());
    }

    @DeleteMapping
    @AuthToken
    @Transactional(rollbackFor = Exception.class)
    public Mono<Integer> deleteSupplier(ServerHttpRequest request,@RequestBody Mono<Supplier> supplier) {
        return supplier.map( s -> {
            return  supplierMapper.deleteSupplier(s.getUuid());
        });
    }

    @PostMapping
    @AuthToken
    @Transactional(rollbackFor = Exception.class)
    public Mono<Supplier> addSupplier(ServerHttpRequest request,@RequestBody Mono<Supplier> supplier) {
        return supplier.map( s -> {
            supplierMapper.addSupplier(s);
            return  supplierMapper.getSupplierByUuid(s.getUuid());
        });
    }

    @PutMapping
    @AuthToken
    @Transactional(rollbackFor = Exception.class)
    public Mono<Supplier>  updateSupplier(ServerHttpRequest request,@RequestBody Mono<Supplier> supplier) {
        return supplier.map( s -> {
             supplierMapper.updateSuppliers(s);
             return  supplierMapper.getSupplierByUuid(s.getUuid());
        });
    }
}
