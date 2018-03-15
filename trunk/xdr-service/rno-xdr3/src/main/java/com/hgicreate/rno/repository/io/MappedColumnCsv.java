package com.hgicreate.rno.repository.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.support.ManagedList;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 17-1-13.
 */
public class MappedColumnCsv {
    private Writer writer;
    private ObjectMapper mapper = new ObjectMapper();
    private String[] outputBuf;

    public MappedColumnCsv(Writer writer) {
        this.writer = writer;
    }

    public void write(List<?> list, FormatFunction function) throws IOException {
        if (list.size() == 0)
            return;
        Map<String, String> head = new LinkedHashMap<>();

        head = this.mapper.convertValue(list.get(0), head.getClass());
        this.write(head, list,function);
    }

    public void write(Map<String, String> head, List<?> list, FormatFunction function) throws IOException {
//        java.util.function.<String,Object,Object> translate
        this.outputBuf = new String[head.size()];
        this.writeln(head.values());
        List<Map<String, Object>> maplist = new ManagedList<>();
        maplist = mapper.convertValue(list, maplist.getClass());
        for (Map<String, Object> objectMap : maplist) {
            writeMap(head, objectMap,function);
        }
    }

    private void writeMap(Map<String, String> head, Map<String, Object> map, FormatFunction function) throws IOException {
        int index = 0;
        for (String s : head.keySet()) {
            if (map.get(s) == null) {
                this.outputBuf[index] = "";
            } else {
                this.outputBuf[index] = String.valueOf(function.format(s, map.get(s)));
            }
            index++;
        }
        this.writeln(this.outputBuf);
    }

    private void writeln(String[] coll) throws IOException {
        this.writeln(String.join(",", coll));
    }

    private void writeln(Collection coll) throws IOException {
        this.writeln(StringUtils.join(coll, ","));
    }

    private void writeln(String str) throws IOException {
        this.writer.append(str + "\r\n");
    }

    @FunctionalInterface
    public interface FormatFunction {
        Object format(String key, Object value);
    }
}
