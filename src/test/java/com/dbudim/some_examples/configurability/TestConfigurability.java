package com.dbudim.some_examples.configurability;

import com.dbudim.configuration.Configuration;
import org.testng.annotations.Test;

public class TestConfigurability {

    @Test
    public void printConfiguration() {
        System.out.println("PROJECT HOST: " + Configuration.getProjectUrl());
    }
}
