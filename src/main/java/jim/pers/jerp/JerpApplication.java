package jim.pers.jerp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("jim.pers.jerp.mapper")
public class JerpApplication {
	public static void main(String[] args) {
		SpringApplication.run(JerpApplication.class, args);
	}
}
