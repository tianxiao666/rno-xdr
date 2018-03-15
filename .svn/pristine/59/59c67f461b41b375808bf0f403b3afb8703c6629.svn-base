package com.hgicreate.rno.repository.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hadoop on 16-11-17.
 */
public class JsonLoader {
    public String load(String path) {
        String str = "";
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(path);
        try {
            //FileInputStream in = new FileInputStream(in);
            // size  为字串的长度 ，这里一次性读完
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            str = new String(buffer, "UTF-8");
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return str;
    }
}
