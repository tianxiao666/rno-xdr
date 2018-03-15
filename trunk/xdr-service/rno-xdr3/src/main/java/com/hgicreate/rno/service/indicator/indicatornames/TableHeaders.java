package com.hgicreate.rno.service.indicator.indicatornames;

import com.hgicreate.rno.domain.indicator.IndicatorName;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by hadoop on 17-1-16.
 */
public class TableHeaders {
    private IndicatorName[] indicatorNames;

    public TableHeaders(IndicatorName[] indicatorNames) {
        this.indicatorNames = indicatorNames;
    }

    public Map<String, String> getDateCell() {
        Map<String, String> result = new LinkedHashMap<>();
        result.put("date", "日期");
        result.put("cellid", "CellId");
        result.putAll(this.getBaseMap());
        return result;
    }

    private Map<String, String> getBaseMap() {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (IndicatorName indicatorName : this.indicatorNames) {
            result.put(indicatorName.getEn(), indicatorName.getCh());
        }
        return result;
    }

}
