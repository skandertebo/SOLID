package com.directi.training.dip.exercise;

public class EncodingModuleClient {
    public static void main(String[] args) throws Exception {
        IReader fileReader = new FileReader("DIP/src/com/directi/training/dip/exercise/beforeEncryption.txt");
        IWriter fileWriter = new FileWriter("DIP/src/com/directi/training/dip/exercise/afterEncryption.txt");
        EncodingModule fileEncoder = new EncodingModule(fileReader, fileWriter);
        fileEncoder.encode();

        IReader networkReader = new NetworkReader("http://myfirstappwith.appspot.com/index.html");
        IWriter databaseWriter = new DatabaseWriter(new MyDatabase());
        EncodingModule networkDbEncoder = new EncodingModule(networkReader, databaseWriter);
        networkDbEncoder.encode();
    }
}
