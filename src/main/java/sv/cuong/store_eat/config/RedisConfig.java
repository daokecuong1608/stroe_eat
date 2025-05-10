package sv.cuong.store_eat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Bean //ket noi den server
    public LettuceConnectionFactory redisConnection() {
        //tao thong tin cau hinh
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName("localhost");
        configuration.setPort(6380);
        return new LettuceConnectionFactory(configuration);
    }

    @Bean //set tempplate
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory redisConnection) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnection);
        return template;
    }
}
//SD redis co du lieu trk day len redis
//redis la  1 he thong => cache su luu tru tren o cung SSD