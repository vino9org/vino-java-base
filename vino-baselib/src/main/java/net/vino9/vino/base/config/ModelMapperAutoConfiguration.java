package net.vino9.vino.base.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(
        prefix = "custom",
        name = "enable-default-modelmapper",
        havingValue = "true",
        matchIfMissing = true)
public class ModelMapperAutoConfiguration {
    @Bean
    public ModelMapper createModelMapper() {
        var mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        // additional configuration goes here
        return mapper;
    }
}
