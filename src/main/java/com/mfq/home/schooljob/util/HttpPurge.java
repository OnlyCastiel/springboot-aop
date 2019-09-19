package com.mfq.home.schooljob.util;

import org.apache.http.client.methods.HttpRequestBase;

import java.net.URI;

public class HttpPurge extends HttpRequestBase {
    public static final String METHOD_NAME = "PURGE";

    public HttpPurge() {
    }

    public String getMethod() {
        return "PURGE";
    }

    public HttpPurge(String uri) {
        this.setURI(URI.create(uri));
    }

    public String getName() {
        return "PURGE";
    }
}

