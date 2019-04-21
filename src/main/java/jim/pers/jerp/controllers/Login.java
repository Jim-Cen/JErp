package jim.pers.jerp.controllers;


import jim.pers.jerp.business.LoginService;
import jim.pers.jerp.mapper.LoginMapper;
import jim.pers.jerp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping(value = "/login")
public class Login {
	@Autowired
	LoginService loginService;

	@Autowired
	LoginMapper loginMapper;

	@PostMapping(value = "/user")
	public Mono<String> getUser(@RequestBody Mono<User> user)  {
		return  user.flatMap( e ->{
			String password = e.getPassword();
			String name = e.getName();
			String token = loginService.checkPassword(name, password);
			if(token != null) {
				long timestamp =new Timestamp(new Date().getTime()).getTime();
				int result = loginMapper.setToken(Integer.parseInt(name),timestamp,token);
				if (result <=0){
					return  Mono.error(new Exception("密码错误"));
				}
				return Mono.just(token);
			}else {
				return  Mono.error(new Exception("密码错误"));
			}
	});
    }
}
