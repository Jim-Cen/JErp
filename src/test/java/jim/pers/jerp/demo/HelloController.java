package jim.pers.jerp.demo;

import jim.pers.jerp.aop.AuthTokenAOP;
import jim.pers.jerp.mapper.EmployeeMapper;
import jim.pers.jerp.mapper.GoodsMapper;
import jim.pers.jerp.mapper.PurchOrderMapper;
import jim.pers.jerp.mapper.SupplierMapper;
import jim.pers.jerp.model.PurchOrder;
import jim.pers.jerp.model.PurchOrderDetail;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
//    @Autowired
//    EmployeeMapper employeeMapper;
//
//    @Autowired
//    SupplierMapper supplierMapper;

    @Autowired
    PurchOrderMapper purchOrderMapper;


//    @Autowired
//    GoodsMapper goodsMapper;
//
//    @Autowired
//    AuthTokenAOP authTokenAOP;
//
//    @Autowired
//    SqlSessionFactory sqlSessionFactory;
//
//    @Autowired
//    SqlSession sqlSession;

//    @GetMapping("/")
//    public Mono<Person> hello() {
//        System.out.println("index");
//        return Mono.just(new Person(1,"Jim"));
//    }

    @PostMapping("/test")
    public  Mono<PurchOrder> test(){
        return Mono.just(purchOrderMapper.getPurchOrderByUuid(1));
    }
//
//    @PostMapping("/goods")
//    public  Mono<Goods> getGoods(){
//        return Mono.just(goodsMapper.getGoodsByUuid(1));
//    }
//
//    @PostMapping("/suppliers")
//    public  Mono<List> getSuppliers(){
//        return Mono.just(supplierMapper.getAllSuppliers());
//    }
//
//    //@AuthToken
//    @RequestMapping("/User")
//    public  Mono<Employee> getUser(@RequestHeader("name") String name,
//                               @RequestBody Publisher<String> path,
//                               ServerHttpRequest request,
//                               ServerHttpResponse response,
//                               ServerWebExchange exchange,
//                               WebSession session){
//        //authTokenAOP.authTokenCheck();
//        //System.out.println(name);
//        //System.out.println(request.getId());
//        HttpHeaders headers = request.getHeaders();
//        //String headerName = headers.getFirst("name");
//        //System.out.println(headerName);
//        System.out.println(session.getId());
////        if("jim".equals(headerName))
//                session.getAttributes().put("admin","jim");
//        String admin = session.getAttributes().get("admin").toString();
//        System.out.println(admin);
//        //DefaultDataBuffer dataBuffer= new DefaultDataBufferFactory().wrap("Hello\n\r".getBytes());
//        Employee user= employeeMapper.getEmployeeByUuid(6);
//        return  Mono.just(user);
//    }
}