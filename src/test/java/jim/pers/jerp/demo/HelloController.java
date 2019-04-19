package jim.pers.jerp.demo;

import jim.pers.jerp.annotation.AuthToken;
import jim.pers.jerp.aop.AuthTokenAOP;
import jim.pers.jerp.mapper.UserMapper;
import jim.pers.jerp.model.User;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @AuthToken
    @PostMapping("/User")
    public  Mono<User> getUser(@RequestHeader("name") String name,@RequestBody Flux<String> path){
        //authTokenAOP.authTokenCheck();
        //System.out.println(name);
        User user=userMapper.getUserByName("Jim");
        return  Mono.just(user);
    }
}