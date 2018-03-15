package com.hgicreate.rno.xdr.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hgicreate.rno.xdr.backend.domain.Uu;
import com.hgicreate.rno.xdr.backend.service.IndicatorService;
import com.hgicreate.rno.xdr.backend.web.rest.cond.IndicatorCond;
import io.github.jhipster.web.util.ResponseUtil;
import netscape.javascript.JSObject;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * REST controller for managing Uu.
 */
@RestController
@RequestMapping("/api/indicator")
public class IndicatorResource {

    private final Logger log = LoggerFactory.getLogger(IndicatorResource.class);

    private final IndicatorService indicatorService;

    public IndicatorResource(IndicatorService indicatorService) {
        this.indicatorService = indicatorService;
    }

    /**
     * GET  /:interfaceType/:cellType : get the indicator.
     *
     * @param interfaceType the type of the indicator
     * @param cellType      the id of the indicator
     * @return the ResponseEntity with status 200 (OK) and with body the indicator, or with status 404 (Not Found)
     */
    @GetMapping("/{interfaceType}/{gradingType}/{cellType}")
    @Timed
    public ResponseEntity<Object> getIndicator(@PathVariable String interfaceType, @PathVariable String gradingType, @PathVariable String cellType, IndicatorCond indicatorCond) {
        log.debug("REST request to get Indicator : {},{},{},{}", interfaceType, gradingType, cellType, indicatorCond);
        Object result = null;
        switch (interfaceType) {
            case "mr":
                result = indicatorService.findMr(gradingType, cellType, indicatorCond);
                break;
            case "uu":
                result = indicatorService.findUu(gradingType, cellType, indicatorCond);
                break;
            case "x2":
                result = indicatorService.findX2(gradingType, cellType, indicatorCond);
                break;
            case "brd31":
                result = indicatorService.findBrd31(gradingType, cellType, indicatorCond);
                break;
            case "brd39":
                result = indicatorService.findBrd39(gradingType, cellType, indicatorCond);
                break;
            default:
                break;
        }
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(result));
    }

    /**
     * GET  /:interfaceType/:cellType : get the indicator.
     *
     * @param interfaceType the type of the indicator
     * @param cellType      the id of the indicator
     * @return the ResponseEntity with status 200 (OK) and with body the indicator, or with status 404 (Not Found)
     */
    @GetMapping("/detail/download/{interfaceType}/{cellType}")
    @Timed
    public ResponseEntity<Object> downloadIndicator(@PathVariable String interfaceType, @PathVariable String cellType, IndicatorCond indicatorCond) {
        log.debug("REST request to download Indicator : {},{},{}", interfaceType, cellType, indicatorCond);
       Object result=getResult(interfaceType,cellType,indicatorCond);
        log.debug(""+result);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(result));
    }

    private Object getResult(String interfaceType, String cellType, IndicatorCond indicatorCond){
        Object result =null;
        switch (interfaceType) {
            case "mr":
                result = indicatorService.downloadMr(cellType, indicatorCond);
                break;
            case "uu":
                result = indicatorService.downloadUu(cellType, indicatorCond);
                break;
            case "x2":
                result = indicatorService.downloadX2(cellType, indicatorCond);
                break;
            case "brd31":
                result = indicatorService.downloadBrd31(cellType, indicatorCond);
                break;
            case "brd39":
                result = indicatorService.downloadBrd39(cellType, indicatorCond);
                break;
            default:
                break;
        }
        return result;
    }

    @GetMapping("/mobile/detail/download/{interfaceType}/{cellType}")
    @CrossOrigin
    @Timed
    @SuppressWarnings("unused")
    public void downloadMobileIndicator(@PathVariable String interfaceType,
                                        @PathVariable String cellType,
                                        IndicatorCond indicatorCond,
                                        HttpServletResponse response) throws JSONException, NoSuchFieldException, IllegalAccessException {
        log.debug("REST request to download Indicator : {},{},{}", interfaceType, cellType, indicatorCond);
        Object result=getResult(interfaceType,cellType,indicatorCond);
        String fileName = interfaceType+"指标提取结果.xlsx";
        try {
            fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  // 为了解决中文名称乱码问题
        }

        response.setContentType("application/x.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        Map<String, List> res = new LinkedHashMap<>();
        res.put("data",(List)result);
         createExcel(response,res);
    }

    private  boolean createExcel(HttpServletResponse response, Map<String, List> data) throws JSONException, NoSuchFieldException, IllegalAccessException {
        log.debug("------------------------------------"+data);
        OutputStream os = null;
        try {
            os = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row;
        Cell cell;
        int n = 0;

        for (String s : data.keySet()) {
            int titleIndex = 0, rowIndex = 0;
            if (n > 0) {
                sheet = workbook.createSheet();
            }
            workbook.setSheetName(n, s);
            n++;

            for (Object obj:  data.get(s)) {
                int valueIndex = 0;
                if (rowIndex == 0) {
                    row = sheet.createRow(0);
                    log.debug("-----------------------------------------"+obj.toString());

                    for (Field field : obj.getClass().getDeclaredFields()) {
                        field.setAccessible(true);
                        if(!field.getName().equals("serialVersionUID")&&!field.getName().equals("id")){
                            switch (field.getName()) {
                                case "pdate":
                                    cell = row.createCell(titleIndex++);
                                    cell.setCellValue("日期");
                                    break;
                                case "phour":
                                    cell = row.createCell(titleIndex++);
                                    cell.setCellValue("小时");
                                    break;
                                default:
                                    cell = row.createCell(titleIndex++);
                                    cell.setCellValue(field.getName());
                                    break;
                            }
                        }

                    }
                }
                row = sheet.createRow(++rowIndex);
                for (Field field : obj.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    if(!field.getName().equals("serialVersionUID") && !field.getName().equals("id")){
                        cell = row.createCell(valueIndex++);
                        cell.setCellValue(field.get(obj)+"");
                    }
                }
            }
        }
        try {
            workbook.write(os);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.getMessage();
        }
        return true;
    }
}
