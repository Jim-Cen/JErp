package jim.pers.jerp.controllers;

import jim.pers.jerp.annotation.AuthToken;
import jim.pers.jerp.mapper.SupplierMapper;
import jim.pers.jerp.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
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
    public Flux<Supplier> getAll(){
        return  Flux.fromIterable(supplierMapper.getAllSuppliers());
    }

    @DeleteMapping
    @AuthToken
    public Mono<Integer> deleteSupplier(ServerHttpRequest request,@RequestBody Mono<Supplier> supplier) {
        return supplier.map( s -> {
            return  supplierMapper.deleteSupplier(s.getUuid());
        });
    }

    @PostMapping
    @AuthToken
    public Mono<Supplier> addSupplier(ServerHttpRequest request,@RequestBody Mono<Supplier> supplier) {
        return supplier.map( s -> {
            supplierMapper.addSupplier(s);
            return  supplierMapper.getSupplierByUuid(s.getUuid());
        });
    }

    @PutMapping
    @AuthToken
    public Mono<Supplier>  updateSupplier(ServerHttpRequest request,@RequestBody Mono<Supplier> supplier) {
        return supplier.map( s -> {
             supplierMapper.updateSuppliers(s);
             return  supplierMapper.getSupplierByUuid(s.getUuid());
        });
    }
}
