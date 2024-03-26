package net.vino9.vino.demo;

import com.github.fppt.jedismock.RedisServer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.io.IOException;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

@TestConfiguration
public class JRedisMockConfiguration {
    private RedisServer redisServer;

    @PostConstruct
    public void postConstruct() throws IOException {
        redisServer = RedisServer.newRedisServer(); // bind to a random port
        redisServer.start();
    }

    @PreDestroy
    public void preDestroy() throws IOException {
        redisServer.stop();
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration config =
                new RedisStandaloneConfiguration("localhost", redisServer.getBindPort());
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        JedisClientConfiguration clientConfig =
                JedisClientConfiguration.builder().usePooling().poolConfig(poolConfig).build();
        JedisConnectionFactory jedisConnectionFactory =
                new JedisConnectionFactory(config, clientConfig);
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }
}
// DELETE_IF: cookiecutter.cache_type != 'redis'
