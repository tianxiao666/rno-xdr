package com.hgicreate.rno.controllers;

import com.hgicreate.rno.service.HelperServer;
import com.hgicreate.rno.service.indicator.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 16-12-23.
 */
//@CrossOrigin("*")
@RestController
@RequestMapping("/indicator/{interface}")
public class IndicatorController {

    //    private UuIndicatorService uuIndicatorService;
    private HelperServer helperServer;
    private Map<String, IndicatorServiceAbstract> indicatorServiceMap = new HashMap<>();
    private HttpServletRequest request;
    private static final Logger logger = LoggerFactory.getLogger(IndicatorController.class);

    @Autowired
    public IndicatorController(HttpServletRequest request,
                               UuIndicatorService uuIndicatorService,
                               MrIndicatorService mrIndicatorService,
                               X2IndicatorService x2IndicatorService,
                               Brd31IndicatorService brd31IndicatorService,
                               Brd39IndicatorService brd39IndicatorService,
                               HelperServer helperServer) {
//        this.uuIndicatorService = uuIndicatorService;
        this.request = request;
        this.helperServer = helperServer;
        this.indicatorServiceMap.put("uu", uuIndicatorService);
        this.indicatorServiceMap.put("mr", mrIndicatorService);
        this.indicatorServiceMap.put("x2", x2IndicatorService);
        this.indicatorServiceMap.put("brd31", brd31IndicatorService);
        this.indicatorServiceMap.put("brd39", brd39IndicatorService);
    }


    @RequestMapping("/hour/network")
    public List<?> getNetHour(long date) {
        return this.getIndicator().getNetHours(date);
    }

    @RequestMapping("/hour/eci")
    public List<?> getCellHour(long date, long input) {
        return this.getIndicator().getCellHours(input, date);
    }

    @RequestMapping("/hour/imsi")
    public List<?> getUserHour(long date, long input) {
        return this.getIndicator().getUserHours(input, date);
    }

    @RequestMapping("/day/network")
    public List<?> getNetDate(long beginDate, long endDate) {
        return this.getIndicator().getNetDates(beginDate, endDate);
    }

    @RequestMapping("/day/eci")
    public List<?> getCellDate(long beginDate, long endDate, long input) {
        return this.getIndicator().getCellDates(beginDate, endDate, input);
    }

    @RequestMapping("/day/imsi")
    public List<?> getUserDate(long beginDate, long endDate, long input) {
        return this.getIndicator().getUserDates(beginDate, endDate, input);
    }

    @RequestMapping("/detail/network")
    public Map<String, Object> getDetial(long date) {
        IndicatorServiceAbstract indicatorService = this.getIndicator();
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("head", indicatorService.getTableHeaders().getDateCell());
        result.put("data", indicatorService.getCellDates(date));
        return result;
    }


    @RequestMapping("/detail/network/download")
    public void downloadDetial(HttpServletResponse response, long date) throws IOException {
        IndicatorServiceAbstract indicatorService = this.getIndicator();
        indicatorService.downloadCsvFile(response, indicatorService.getCellDates(date), "(" + this.helperServer.getDate(date) + ")" + getInterfaceName() + "口指标.csv");

    }

    @RequestMapping("/detail/eci")
    public Map<String, Object> getDetial(long date, long cellInput) {
//        return this.uuTranslator.translate(this.uuIndicatorService.getCellDates(date, cellInput));
        IndicatorServiceAbstract indicatorService = this.getIndicator();
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("head", indicatorService.getTableHeaders().getDateCell());
        result.put("data", indicatorService.getCellDates(date, cellInput));
        return result;
    }

    private IndicatorServiceAbstract getIndicator() {
        String interfaceName = getInterfaceName();
        logger.debug("interfaceName={}",interfaceName);
        IndicatorServiceAbstract indicator = this.indicatorServiceMap.get(interfaceName);
        logger.debug("IndicatorServiceAbstract={}",indicator);
        return indicator;
    }

    private String getInterfaceName() {
        Map<String, String> variables = (Map<String, String>)
                request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        return variables.get("interface");
    }
}
