package com.example.asynresponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * Created by zhuguowei on 5/12/17.
 */
@RestController
public class FooController {
    @RequestMapping("/hello")
    public String hello() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }

    @RequestMapping("/asyncHello")
    public Callable<String> asyncHello() {
        return () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        };
    }
}
