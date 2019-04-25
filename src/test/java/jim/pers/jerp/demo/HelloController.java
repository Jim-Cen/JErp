package jim.pers.jerp.demo;

import jim.pers.jerp.aop.AuthTokenAOP;
import jim.pers.jerp.mapper.EmployeeMapper;
import jim.pers.jerp.mapper.GoodsTypeMapper;
import jim.pers.jerp.mapper.SupplierMapper;
import jim.pers.jerp.model.Employee;
import jim.pers.jerp.model.GoodsType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    GoodsTypeMapper goodsTypeMapper;

    @Autowired
    SupplierMapper supplierMapper;

    @Autowired
    AuthTokenAOP authTokenAOP;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    SqlSession sqlSession;

    @GetMapping("/")
    public Mono<Person> hello() {
        System.out.println("index");
        return Mono.just(new Person(1,"Jim"));
    }

    @PostMapping("/suppliers")
    public  Mono<List> getSuppliers(){
        return Mono.just(supplierMapper.getAllSuppliers());
    }

    @PostMapping("/goodstype")
    public  Mono<GoodsType> getGoodsType(){
       return Mono.just(goodsTypeMapper.getGoodsTypeByUuid(1));
    }
    //@AuthToken
    @RequestMapping("/User")
    public  Mono<Employee> getUser(@RequestHeader("name") String name,
                               @RequestBody Publisher<String> path,
                               ServerHttpRequest request,
                               ServerHttpResponse response,
                               ServerWebExchange exchange,
                               WebSession session){
        //authTokenAOP.authTokenCheck();
        //System.out.println(name);
        //System.out.println(request.getId());
        HttpHeaders headers = request.getHeaders();
        //String headerName = headers.getFirst("name");
        //System.out.println(headerName);
        System.out.println(session.getId());
//        if("jim".equals(headerName))
                session.getAttributes().put("admin","jim");
        String admin = session.getAttributes().get("admin").toString();
        System.out.println(admin);
        //DefaultDataBuffer dataBuffer= new DefaultDataBufferFactory().wrap("Hello\n\r".getBytes());
        Employee user= employeeMapper.getEmployeeByUuid(6);
        return  Mono.just(user);
    }
}