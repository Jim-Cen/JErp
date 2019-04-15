package jim.pers.jerp.demo;

import jim.pers.jerp.mapper.UserMapper;
import jim.pers.jerp.model.User;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    SqlSession sqlSession;

    @GetMapping("/")
    public Mono<Person> hello() {
        return Mono.just(new Person(1,"Jim"));
    }

    @GetMapping("/User")
    public  Mono<User> getUser(){ ;
        User user=userMapper.getUserByName("Jim");
        return  Mono.just(user);
    }
}