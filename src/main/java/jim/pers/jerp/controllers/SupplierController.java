package jim.pers.jerp.controllers;

import jim.pers.jerp.annotation.AuthToken;
import jim.pers.jerp.mapper.SupplierMapper;
import jim.pers.jerp.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class SupplierController {
    @Autowired
    SupplierMapper supplierMapper;

    @PostMapping(value = "/supplier/set")
    @AuthToken
    public Mono<Integer> getPrograms(ServerHttpRequest request,@RequestBody Mono<Supplier> supplier) {
        return supplier.flatMap( s -> {
            int uuid = supplierMapper.setSupplierByUuid(s.getName(),s.getAddress(),s.getContact(),s.getTel());
            return Mono.just(uuid);
        });
    }
}
