package jim.pers.jerp.controllers;

import jim.pers.jerp.annotation.AuthToken;
import jim.pers.jerp.mapper.SupplierMapper;
import jim.pers.jerp.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class SupplierController {
    @Autowired
    SupplierMapper supplierMapper;

    @PostMapping(value = "/supplier/all")
    @AuthToken
    public Flux<Supplier> getAll(){
        return  Flux.fromIterable(supplierMapper.getAllSuppliers());
    }

    @PostMapping(value = "/supplier/set")
    @AuthToken
    public Mono<Supplier> setSupplier(ServerHttpRequest request,@RequestBody Mono<Supplier> supplier) {
        return supplier.map( s -> {
            int uuid = supplierMapper.setSupplier(s.getName(),s.getAddress(),s.getContact(),s.getTel());
            System.out.println("uuid="+uuid);
            return  supplierMapper.getSupplierByUuid(uuid);
        });
    }
    @PostMapping(value = "/supplier/update")
    @AuthToken
    public Mono<Supplier>  updateSupplier(ServerHttpRequest request,@RequestBody Mono<Supplier> supplier) {
        return supplier.map( s -> {
             supplierMapper.updateSuppliers(s);
             return  supplierMapper.getSupplierByUuid(s.getUuid());
        });
    }
}
