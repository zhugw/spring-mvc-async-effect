package com.example.asynresponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zhuguowei on 5/13/17.
 */
@Configuration
public class AppConfig {
    @Bean
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(200);

        return threadPoolTaskExecutor;
    }

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(AsyncTaskExecutor asyncTaskExecutor) {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
                configurer.setTaskExecutor(asyncTaskExecutor);
                super.configureAsyncSupport(configurer);
            }
        };
    }
}
