package com.hgicreate.rno.repository.io;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 17-1-16.
 */
public class MapToCsvWriter {
    private Writer writer;
    private String[] outputBuf;

    public MapToCsvWriter(Writer writer) {
        this.writer = writer;

    }

    public void write(List<Map<String, Object>> list) throws IOException {

        if (list.size() == 0)
            return;
        outputBuf = new String[list.get(0).size()];
        this.writeln(list.get(0).keySet());
        for (Map<String, Object> map : list) {
            this.writeln(map.values());
        }
    }

    private void writeln(String[] coll) throws IOException {
        this.writeln(String.join(",", coll));
    }

    private void writeln(Collection coll) throws IOException {
        int index = 0;
        for (Object o : coll) {
            this.outputBuf[index] = o == null ? "" : String.valueOf(o);
            index++;
        }
        this.writeln(this.outputBuf);
    }

    private void writeln(String str) throws IOException {
        this.writer.append(str + "\r\n");
    }
}
