package jim.pers.jerp.demo;

import jim.pers.jerp.annotation.AuthToken;
import jim.pers.jerp.aop.AuthTokenAOP;
import jim.pers.jerp.mapper.UserMapper;
import jim.pers.jerp.model.User;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;

@RestController
public class HelloController {
    @Autowired
    UserMapper userMapper;

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

    //@AuthToken
    @RequestMapping("/User")
    public  Mono<User> getUser(@RequestHeader("name") String name,
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
        User user=userMapper.getUserByName("Jim");
        return  Mono.just(user);
    }
}