package com.dbudim.client.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.*;

public class BaseResource {

    public String id;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JSON_STYLE);
    }

}
