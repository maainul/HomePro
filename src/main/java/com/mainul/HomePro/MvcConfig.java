package com.mainul.HomePro;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path renterUploadDir = Paths.get("./renter-images");
        String renterUploadPath = renterUploadDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/renter-images/**").addResourceLocations("file:" + renterUploadPath+"/");
    }
}
