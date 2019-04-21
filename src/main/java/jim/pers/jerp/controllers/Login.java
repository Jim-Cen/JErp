package jim.pers.jerp.controllers;


import jim.pers.jerp.business.LoginService;
import jim.pers.jerp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/login")
public class Login {
	@Autowired
	LoginService loginService;

	@PostMapping(value = "/user")
	public Mono<Map> getUser(@RequestBody Mono<User> user)  {
		return  user.flatMap( e ->{
			String password = e.getPassword();
			String name = e.getName();
			String token = loginService.checkPassword(name, password);
			if(token != null) {
				HashMap map = new HashMap();
				map.put("token",token);
				return Mono.just(map);
			}else {
				return  Mono.error(new Exception("密码错误"));
			}
	});
    }
}
