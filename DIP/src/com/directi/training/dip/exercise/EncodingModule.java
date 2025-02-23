package com.directi.training.dip.exercise;

import java.util.Base64;

public class EncodingModule {
    private IReader reader;
    private IWriter writer;

    public EncodingModule(IReader reader, IWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void encode() throws Exception {
        String input = reader.read();
        String encoded = Base64.getEncoder().encodeToString(input.getBytes());
        writer.write(encoded);
    }
}

