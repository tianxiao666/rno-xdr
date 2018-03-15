package com.hgicreate.rno.repository.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hgicreate.rno.domain.exception.XdrTableColumns;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * Created by hadoop on 2016/12/29.
 */
@Component
public class ExceptionColumnsReader {
    private String jsonStr = "";
    private XdrTableColumns[] xdrColumns;

    public ExceptionColumnsReader() {
        JsonLoader jsonLoader = new JsonLoader();
        this.jsonStr = jsonLoader.load("db/exceptionNames.json");
        this.xdrColumns = this.readXdrTableColumns();
    }

    public String getJsonStr() {
        return this.jsonStr;
    }

//    public InterfaceName[] getInterfaceNames() {
//        return this.interfaceNames;
//    }

    public XdrTableColumns getXdrTableColumns(String tableName) {
        for (XdrTableColumns name : this.xdrColumns) {
            if (name.getName().equals(tableName)) {
                return name;
            }
        }
        return null;
    }

    private XdrTableColumns[] readXdrTableColumns() {
        ObjectMapper mapper = new ObjectMapper();
        XdrTableColumns[] tableColumns = null;
        try {
            tableColumns = mapper.readValue(this.jsonStr, XdrTableColumns[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tableColumns;
    }

}
