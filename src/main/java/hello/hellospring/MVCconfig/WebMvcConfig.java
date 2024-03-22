package hello.hellospring.MVCconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("IMG/CenterBanner/**")
                .addResourceLocations("file:src/main/resources/public/uploads/CenterBanner/");
        registry.addResourceHandler("IMG/HomeBanner/**")
                .addResourceLocations("file:src/main/resources/public/uploads/HomeBanner/");
        registry.addResourceHandler("IMG/Review/**")
                .addResourceLocations("file:src/main/resources/public/uploads/Review/");
        registry.addResourceHandler("IMG/Car/**")
                .addResourceLocations("file:src/main/resources/public/uploads/Car/");
        registry.addResourceHandler("IMG/CarBrand/**")
                .addResourceLocations("file:src/main/resources/public/uploads/CarBrand/");
    }
}