package com.hgicreate.rno.repository.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hgicreate.rno.domain.indicator.InterfaceName;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * Created by hadoop on 2016/12/29.
 */
@Component
public class IndicatorNamesReader {
    private String jsonStr = "";
    private InterfaceName[] interfaceNames;

    public IndicatorNamesReader() throws IOException {
        JsonLoader jsonLoader = new JsonLoader();
        this.jsonStr = jsonLoader.load("db/allIndicator.json");
        this.interfaceNames = this.readInterfaceNames();
    }

    public String getJsonStr() {
        return this.jsonStr;
    }

    public InterfaceName[] getInterfaceNames() {
        return this.interfaceNames;
    }

    public InterfaceName getInterfaceName(String interfaceType) {
        for (InterfaceName name : this.interfaceNames) {
            if (name.getInterfaceType().equals(interfaceType)) {
                return name;
            }
        }
        return null;
    }

    private InterfaceName[] readInterfaceNames() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InterfaceName[] interfaceNames = null;
        interfaceNames = mapper.readValue(this.jsonStr, InterfaceName[].class);
        if (interfaceNames == null||interfaceNames.length==0)
            throw new NullPointerException("interfaceNames is null");
        return interfaceNames;
    }

}
