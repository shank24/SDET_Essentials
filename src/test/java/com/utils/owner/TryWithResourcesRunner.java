package com.utils.owner;

import com.utils.owner.TryWithResources;
import com.utils.owner.ConfigProperties;

public class TryWithResourcesRunner {
    public static void main(String[] args) {
        String browser = TryWithResources.get(ConfigProperties.BROWSER);
        System.out.println("browser = " + browser);
    }
}
