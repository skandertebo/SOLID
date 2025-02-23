package com.directi.training.dip.exercise;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkReader implements IReader {
    private String url;

    public NetworkReader(String url) {
        this.url = url;
    }

    @Override
    public String read() throws IOException {
        URL urlObject = new URL(url);
        StringBuilder content = new StringBuilder();
        try (InputStreamReader reader = new InputStreamReader(urlObject.openStream())) {
            int c;
            while ((c = reader.read()) != -1) {
                content.append((char) c);
            }
        }
        return content.toString();
    }
} 