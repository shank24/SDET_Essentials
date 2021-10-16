package com.utils.owner;

import org.aeonbits.owner.Config;
import java.util.List;

@Config.Sources(value="file:/home/shanky/Personal/Azure/Practice/SDET_QA/src/main/resources/FrameworkConfig.properties")
public interface FrameworkConfig extends Config {

    String browser();
    Long timeout();
    boolean takeScreenshot();
    List<String> tools();
}
