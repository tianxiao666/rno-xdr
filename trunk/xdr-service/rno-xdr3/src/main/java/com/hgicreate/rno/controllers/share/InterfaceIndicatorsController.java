package com.hgicreate.rno.controllers.share;

import com.hgicreate.rno.service.indicator.indicatornames.IndicatorNamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hadoop on 16-12-22.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/share/ii")
public class InterfaceIndicatorsController {
    private IndicatorNamesService indicatorNamesService;
    @Autowired
    public InterfaceIndicatorsController(IndicatorNamesService indicatorNamesService){
        this.indicatorNamesService = indicatorNamesService;
    }
    @RequestMapping("/json")
    public String getII(){
        return this.indicatorNamesService.getIndicatorsStr();
    }
}
