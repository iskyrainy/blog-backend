package com.example.bb.runner;

import com.example.bb.service.StartService;
import jakarta.annotation.Resource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * <p>className: com.example.bb.init-StartRunner
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/20
 **/
@Component
public class StartRunner implements ApplicationRunner {
    @Resource
    StartService startService;

    @Override
    public void run(ApplicationArguments args) {
        startService.initApplication();
    }
}
