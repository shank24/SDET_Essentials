package com.tests.owner;

import com.utils.owner.FrameworkConfig;
import org.aeonbits.owner.ConfigFactory;

public class RunnerWithOwner {

    public static void main(String[] args) {
        FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
        System.out.println(config.browser());
        System.out.println(config.timeout());
    }
}
