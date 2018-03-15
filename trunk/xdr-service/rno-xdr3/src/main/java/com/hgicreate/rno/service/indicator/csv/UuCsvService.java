package com.hgicreate.rno.service.indicator.csv;

import com.hgicreate.rno.repository.io.IndicatorNamesReader;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

/**
 * Created by hadoop on 17-1-16.
 */
@Component
public class UuCsvService {
    private IndicatorNamesReader indicatorNamesReader;
    private LinkedHashMap<String,String> headers=new LinkedHashMap<>();
    public UuCsvService(IndicatorNamesReader indicatorNamesReader) {
        this.indicatorNamesReader = indicatorNamesReader;
    }

}
