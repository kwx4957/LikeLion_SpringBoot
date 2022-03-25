package dev.projectlion.demo.week6;

import com.google.gson.Gson;
import dev.projectlion.demo.week7.interceptor.HeaderLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class DemoConfig implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(DemoConfig.class);

    private final HeaderLoggingInterceptor headerLoggingInterceptor;

    public DemoConfig(HeaderLoggingInterceptor headerLoggingInterceptor){
        this.headerLoggingInterceptor = headerLoggingInterceptor;
    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(headerLoggingInterceptor)
//                .addPathPatterns("/post/**")
//                .excludePathPatterns("/except/**");
//    }
//
//    @Value("${custom.property.single}")
//    private String customProperty;
//
//    @Value("${custom.property.comlist}")
//    private List<String> customCommaList;
//
//    @Value("${custom.property.default:default-property}")
//    private String propertyDefault;
//
//    @PostConstruct
//    public void init(){
//        logger.info("cuostom property: {} " ,customProperty);
//
//        for (String commaListItem:customCommaList){
//            logger.info("comma list time {} ", commaListItem);
//        }
//
//        logger.info("cuostom property: {} " ,propertyDefault);
//    }
    @Bean
    public Gson gson(){
        return new Gson();
    }
}
