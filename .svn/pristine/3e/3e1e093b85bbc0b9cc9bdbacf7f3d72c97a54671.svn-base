package com.hgicreate.rno.controllers;

import com.hgicreate.rno.domain.exception.brd39.Brd39CellDate;
import com.hgicreate.rno.service.HelperServer;
import com.hgicreate.rno.service.exception.ExceptionService;
import net.minidev.json.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by hadoop on 16-12-23.
 */
@RestController
@RequestMapping("/exception/brd39")
public class ExceptionController {

    //    private UuIndicatorService uuIndicatorService;
    private HelperServer helperServer;
    private ExceptionService service;
    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @Autowired
    public ExceptionController(HelperServer helperServer, ExceptionService service) {
        this.helperServer = helperServer;
        this.service = service;
    }

    @RequestMapping("/detail/network")
    public Map<String, Object> getDetial(long date) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("head", service.getTableHeaders().getDateCell());
        result.put("data", service.getCellDates(date));
        return result;
    }

    //    @RequestMapping("/detailByQuery/network")
//    public Map<String, Object> getDetialWithQuery(long date, DBObject query) throws IOException, ParseException {
//        System.out.println(query);
//        Map<String, Object> result = new LinkedHashMap<>();
//        result.put("head", context.getTableHeaders().getDateCell());
//        result.put("data", context.getDetialWithQuery(date, query));
//        return result;
//    }
//    @RequestMapping(value = "/detailByQuery", method = RequestMethod.POST)
//    public Map<String, Object> getDetialWithQuery(@RequestBody Map<String,String> args) throws IOException, ParseException {
//        Pageable pageable=new PageRequest(Integer.valueOf(args.get("page")),Integer.valueOf(args.get("size")) );
//        Map<String, Object> result = new LinkedHashMap<>();
//        result.put("head", service.getTableHeaders().getDateCell());
//        result.put("data", this.service.getDetialWithQuery(args.get("query"),pageable));
//        return result;
//    }
    @RequestMapping(value = "/detailByQuery", method = RequestMethod.POST)
    public Page<Brd39CellDate> getDetialWithQuery(@RequestBody Map<String,String> args) throws IOException, ParseException {
        Pageable pageable=new PageRequest(Integer.valueOf(args.get("page")),Integer.valueOf(args.get("size")) );
        return this.service.getDetialWithQuery(args.get("query"),pageable);
    }
    //
    @RequestMapping("/detailByQuery/download")
    public void downloadDetial(HttpServletResponse response, @RequestBody Map<String,String> query, Pageable pageable) throws IOException, ParseException {
//        service.downloadCsvFile(response, this.service.getDetialWithQuery(query.get("query"),pageable), "异常指标.csv");
    }

    @RequestMapping("/detail/eci")
    public Map<String, Object> getDetial(long date, long cellInput) {
//        return this.uuTranslator.translate(this.uuIndicatorService.getCellDates(date, cellInput));
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("head", service.getTableHeaders().getDateCell());
        result.put("data", service.getCellDates(date, cellInput));
        return result;
    }
}
