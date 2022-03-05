package ru.itis.response_entity_example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class AppConfiguration implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converterConfig());
    }

    private MappingJackson2HttpMessageConverter converterConfig() {
        return new MappingJackson2HttpMessageConverter();
    }
}
