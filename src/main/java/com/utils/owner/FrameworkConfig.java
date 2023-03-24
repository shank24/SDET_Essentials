package com.utils.owner;

import org.aeonbits.owner.Config;
import java.util.List;

@Config.Sources(value="file:${user.dir}/src/main/resources/FrameworkConfig.properties")
public interface FrameworkConfig extends Config {

    @DefaultValue("FIREFOX")
    BrowserType browser();

    Long timeout();

    @Key("takeSscreenshot")
    boolean takeScreenshot();

    List<String> tools();
}
