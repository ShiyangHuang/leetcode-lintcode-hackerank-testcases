package com.testcases.reflaction;

/**
 * Created by shiyanghuang on 16/3/2.
 */
public class ToBeReflact {
    private String name;

    ToBeReflact() { this.name = "Default"; }
    ToBeReflact(String name) {
        this.name = name;
    }

    private void setName(String name)
    {
        this.name = name;
    }

    private String getName() {
        return this.name;
    }
}
