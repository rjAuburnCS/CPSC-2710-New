package edu.au.cpsc.module4.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AirlineDatabaseIO {
    public static void save(AirlineDatabase ad, OutputStream strm) throws IOException {
        if (ad == null) throw new IllegalArgumentException("AirlineDatabase cannot be null");
        ObjectOutputStream oos = new ObjectOutputStream(strm);
        oos.writeObject(ad);
        oos.flush();
    }

    public static AirlineDatabase load(InputStream strm) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(strm);
        return (AirlineDatabase) ois.readObject();
    }
}
