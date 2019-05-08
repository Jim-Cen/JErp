package jim.pers.jerp.controllers;


import jim.pers.jerp.annotation.AuthToken;
import jim.pers.jerp.mapper.ProgramMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public class ProgramController {
	@Autowired
	ProgramMapper programMapper;
	
	@PostMapping(value = "/program/get")
	@AuthToken
	public Flux<List> getPrograms(ServerHttpRequest request) {
		return Flux.fromIterable((List)programMapper.getProgram());
	}
}
