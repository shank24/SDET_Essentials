package com.utils.owner;

import org.aeonbits.owner.Config;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Config.Sources(value="file:${user.dir}/src/test/resources/FrameworkConfig.properties")
public interface FrameworkConfig extends Config {

    @DefaultValue("FIREFOX")
    BrowserType browser();

    @DefaultValue("SECONDS")
    TimeUnit value();

    Long timeout();

    @Key("takeScreenshot")
    boolean takeScreenshot();

    List<String> tools();
}
