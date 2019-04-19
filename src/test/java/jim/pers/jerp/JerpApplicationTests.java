package jim.pers.jerp;

import jim.pers.jerp.annotation.AuthToken;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JerpApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private URL base;

	@AuthToken
	public void aopTest(){

	}
	@Before
	public void setUp() throws Exception {
		String url = String.format("http://localhost:%d/", port);
		System.out.println(String.format("port is : [%d]", port));
		this.base = new URL(url);
	}
	@Test
	public void test1() throws Exception {
		//aopTest();

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("name", "jim");
		MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
		postParameters.add("path", "291974");
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(postParameters, requestHeaders);

//		ResponseEntity<String> response = this.restTemplate.getForEntity(
//				this.base.toString() + "/User", String.class, "");
		ResponseEntity<String> response = this.restTemplate.exchange(this.base.toString() + "/User",
										 HttpMethod.POST, requestEntity, String.class);
		System.out.println(String.format("测试结果为：%s", response.getBody()));
	}
}
