package jim.pers.jerp;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import jim.pers.jerp.model.Employee;
import jim.pers.jerp.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import static javafx.scene.input.KeyCode.J;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JerpApplicationTests {

	@Autowired
	private WebTestClient webClient;

	@LocalServerPort
	private int port;


	@Before
	public void setUp() throws Exception {
		String url = String.format("http://localhost:%d/", port);
		System.out.println(String.format("port is : [%d]", port));
	}
	@Test
	public void test1() throws Exception {

//		MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
//		postParameters.add("name", "6");
//		postParameters.add("password", "1");
		Employee employee =new Employee();
		employee.setUserName("6");
		employee.setPwd("1");
		User user = new User();
		user.setName("6");
		user.setPassword("1");
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(user));
		webClient.post()
				   .uri("/login/user")
					.header("name","jim")
					//.body(Mono.just(postParameters),MultiValueMap.class)
					//.body(BodyInserters.fromFormData("name","6"))
				    //.body(Mono.just(employee),Employee.class)
					.header("Content-Type","application/json")
					.body(BodyInserters.fromObject(mapper.writeValueAsString(user)))
					//.body(BodyInserters.fromObject(mapper.writeValueAsString(employee)))
					.exchange()
					.expectBody()
					.consumeWith(response -> {
						byte[] body = response.getResponseBody();
						System.out.println(new String(body));
					});


//		ResponseEntity<String> response = this.restTemplate.getForEntity(
//				this.base.toString() + "/User", String.class, "");
//		ResponseEntity<String> response = this.restTemplate.exchange(this.base.toString() + "/User",
//										 HttpMethod.POST, requestEntity, String.class);
		//System.out.println(String.format("测试结果为：%s", response.getBody()));
	}
}
