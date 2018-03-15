package com.hgicreate.rno.service.indicator.indicatornames;

import com.hgicreate.rno.repository.io.JsonLoader;
import org.springframework.stereotype.Component;

/**
 * Created by hadoop on 2016/12/21.
 */
@Component
public class IndicatorNamesService {
    private String jsonStr;
    public IndicatorNamesService(){
        JsonLoader jsonLoader=new JsonLoader();
        this.jsonStr= jsonLoader.load("db/allIndicator.json");
    }
    public String getIndicatorsStr(){
        return this.jsonStr;
    }
}
