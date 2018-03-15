package com.hgicreate.rno.service.exception.exceptionnames;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by hadoop on 17-1-16.
 */
public class TableHeaders {
    private Map<String,String> names;

    public TableHeaders(Map<String,String> columns) {
        this.names = columns;
    }

    public Map<String, String> getDateCell() {
        Map<String, String> result = new LinkedHashMap<>();
        result.put("date", "日期");
        result.put("cellid", "CellId");
        result.putAll(this.getBaseMap());
        return result;
    }

    private Map<String, String> getBaseMap() {
        return names;
    }

}
