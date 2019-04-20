package jim.pers.jerp;

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
import reactor.core.publisher.Mono;

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

		MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
		postParameters.add("path", "291974");
		webClient.post()
				   .uri("/User")
					.header("name","jim")
					.body(Mono.just(postParameters),MultiValueMap.class)
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
