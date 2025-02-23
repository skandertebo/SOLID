package com.directi.training.dip.exercise;

public class DatabaseWriter implements IWriter {
    private MyDatabase database;

    public DatabaseWriter(MyDatabase database) {
        this.database = database;
    }

    @Override
    public void write(String data) {
        database.write(data);
    }
} 