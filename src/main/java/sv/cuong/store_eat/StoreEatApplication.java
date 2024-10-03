package sv.cuong.store_eat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableCaching //cho phep ung dung sd cache
@SpringBootApplication
public class StoreEatApplication {
	public static void main(String[] args) {
		SpringApplication.run(StoreEatApplication.class, args);
	}
}
