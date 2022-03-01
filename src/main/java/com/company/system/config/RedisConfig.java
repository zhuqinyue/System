//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig {
    public RedisConfig() {
    }

    @Bean({"jedisConnectionFactory"})
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory config = new JedisConnectionFactory();
        config.setHostName("59.110.175.182");
        config.setPort(6379);
        config.setPassword("yunding12..");
        return config;
    }

    @Bean({"stringRedisTemplate"})
    public StringRedisTemplate stringRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(jedisConnectionFactory);
        return template;
    }
}
