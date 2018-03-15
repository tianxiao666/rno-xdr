package com.hgicreate.rno.xdr.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hgicreate.rno.xdr.backend.service.ExceptionStatsService;
import com.hgicreate.rno.xdr.backend.web.rest.cond.ExceptionStatsCond;
import com.hgicreate.rno.xdr.backend.web.rest.util.HeaderUtil;
import com.hgicreate.rno.xdr.backend.web.rest.util.PaginationUtil;
import com.hgicreate.rno.xdr.backend.service.dto.ExceptionStatsDTO;
import io.swagger.annotations.ApiParam;
import io.github.jhipster.web.util.ResponseUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.*;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing ExceptionStats.
 */
@RestController
@RequestMapping("/api")
public class ExceptionStatsResource {

    private final Logger log = LoggerFactory.getLogger(ExceptionStatsResource.class);

    private static final String ENTITY_NAME = "exceptionStats";

    private final ExceptionStatsService exceptionStatsService;

    public ExceptionStatsResource(ExceptionStatsService exceptionStatsService) {
        this.exceptionStatsService = exceptionStatsService;
    }

    /**
     * POST  /exception-stats : Create a new exceptionStats.
     *
     * @param exceptionStatsDTO the exceptionStatsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new exceptionStatsDTO, or with status 400 (Bad Request) if the exceptionStats has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/exception-stats")
    @Timed
    public ResponseEntity<ExceptionStatsDTO> createExceptionStats(@Valid @RequestBody ExceptionStatsDTO exceptionStatsDTO) throws URISyntaxException {
        log.debug("REST request to save ExceptionStats : {}", exceptionStatsDTO);
        if (exceptionStatsDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new exceptionStats cannot already have an ID")).body(null);
        }
        ExceptionStatsDTO result = exceptionStatsService.save(exceptionStatsDTO);
        return ResponseEntity.created(new URI("/api/exception-stats/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /exception-stats : Updates an existing exceptionStats.
     *
     * @param exceptionStatsDTO the exceptionStatsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated exceptionStatsDTO,
     * or with status 400 (Bad Request) if the exceptionStatsDTO is not valid,
     * or with status 500 (Internal Server Error) if the exceptionStatsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/exception-stats")
    @Timed
    public ResponseEntity<ExceptionStatsDTO> updateExceptionStats(@Valid @RequestBody ExceptionStatsDTO exceptionStatsDTO) throws URISyntaxException {
        log.debug("REST request to update ExceptionStats : {}", exceptionStatsDTO);
        if (exceptionStatsDTO.getId() == null) {
            return createExceptionStats(exceptionStatsDTO);
        }
        ExceptionStatsDTO result = exceptionStatsService.save(exceptionStatsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, exceptionStatsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /exception-stats : get all the exceptionStats.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of exceptionStats in body
     */
    @GetMapping("/exception-stats")
    @Timed
    public ResponseEntity<List<ExceptionStatsDTO>> getAllExceptionStats(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of ExceptionStats");
        Page<ExceptionStatsDTO> page = exceptionStatsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/exception-stats");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /exception-stats/:id : get the "id" exceptionStats.
     *
     * @param id the id of the exceptionStatsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the exceptionStatsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/exception-stats/{id}")
    @Timed
    public ResponseEntity<ExceptionStatsDTO> getExceptionStats(@PathVariable Long id) {
        log.debug("REST request to get ExceptionStats : {}", id);
        ExceptionStatsDTO exceptionStatsDTO = exceptionStatsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(exceptionStatsDTO));
    }

    /**
     * DELETE  /exception-stats/:id : delete the "id" exceptionStats.
     *
     * @param id the id of the exceptionStatsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/exception-stats/{id}")
    @Timed
    public ResponseEntity<Void> deleteExceptionStats(@PathVariable Long id) {
        log.debug("REST request to delete ExceptionStats : {}", id);
        exceptionStatsService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/exception-stats?query=:query : search for the exceptionStats corresponding
     * to the query.
     *
     * @param query the query of the exceptionStats search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/exception-stats")
    @Timed
    public ResponseEntity<List<ExceptionStatsDTO>> searchExceptionStats(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of ExceptionStats for query {}", query);
        Page<ExceptionStatsDTO> page = exceptionStatsService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/exception-stats");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /exception-stats/findByCond : get exception-stats by condition.
     *
     * @param cond the condition of the exceptionStatsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and the list of exception-stats in body
     */
    @GetMapping("/exception-stats/findByCond")
    @Timed
    public ResponseEntity<List<ExceptionStatsDTO>> findByCond(@ApiParam ExceptionStatsCond cond, @ApiParam Pageable pageable) {
        log.debug("REST request to get a page of exception-stats : cond = {}, pageable = {}", cond, pageable);
        Page<ExceptionStatsDTO> page = exceptionStatsService.findByCond(cond, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/exception-stats/findByCond");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /exception-stats/downloadByCond : download exception-stats by condition.
     *
     * @param cond the condition of the exceptionStatsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and the list of exception-stats in body
     */
    @GetMapping("/exception-stats/downloadByCond")
    @Timed
    public ResponseEntity<List<ExceptionStatsDTO>> downloadByCond(@ApiParam ExceptionStatsCond cond) {
        log.debug("REST request to get a page of exception-stats : cond = {}", cond);
        List<ExceptionStatsDTO> list = exceptionStatsService.downloadByCond(cond);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(list));
    }

    @GetMapping("/exception-stats/mobile/downloadByCond")
    @Timed
    @CrossOrigin
    public void downloadByCond(@RequestParam Long date,Long eci
        ,String expressionConnector1,String expressionCondition1,String expressionOperator1,Double expressionValue1
        ,String expressionConnector2,String expressionCondition2,String expressionOperator2,Double expressionValue2
        ,String expressionConnector3,String expressionCondition3,String expressionOperator3,Double expressionValue3,
                               HttpServletResponse response) throws IllegalAccessException, NoSuchFieldException, JSONException {
//        log.debug("REST request to get a page of exception-stats : cond = {}", cond);
        //List<ExceptionStatsDTO> list = exceptionStatsService.downloadByCondMobile(cond);
        log.debug("date={},eci={},",date,eci);
        log.debug("expressionConnector1={},expressionCondition1={},expressionOperator1={},expressionValue1={}",expressionConnector1,expressionCondition1,expressionOperator1,expressionValue1);
        log.debug("expressionConnector2={},expressionCondition2={},expressionOperator2={},expressionValue2={}",expressionConnector2,expressionCondition2,expressionOperator2,expressionValue2);
        log.debug("expressionConnector3={},expressionCondition3={},expressionOperator3={},expressionValue3={}",expressionConnector3,expressionCondition3,expressionOperator3,expressionValue3);
        ExceptionStatsCond cond=new ExceptionStatsCond();
        cond.setDate(date);
        cond.setEci(eci);
        cond.setExpressionConnector1(expressionConnector1);
        cond.setExpressionCondition1(expressionCondition1);
        cond.setExpressionOperator1(expressionOperator1);
        cond.setExpressionValue1(expressionValue1);

        cond.setExpressionConnector2(expressionConnector2);
        cond.setExpressionCondition2(expressionCondition2);
        cond.setExpressionOperator2(expressionOperator2);
        cond.setExpressionValue2(expressionValue2);

        cond.setExpressionConnector3(expressionConnector3);
        cond.setExpressionCondition3(expressionCondition3);
        cond.setExpressionOperator3(expressionOperator3);
        cond.setExpressionValue3(expressionValue3);
        List<ExceptionStatsDTO> list = exceptionStatsService.downloadByCondMobile(cond);
        String fileName = "小区指标异常统计.xlsx";
        try {
            fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  // 为了解决中文名称乱码问题
        }

        response.setContentType("application/x.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);

        Map<String, List<ExceptionStatsDTO>> res = new LinkedHashMap<>();
        res.put("data", list);
        createExcel(response,res);
    }
    private  boolean createExcel(HttpServletResponse response, Map<String, List<ExceptionStatsDTO>> data) throws JSONException, NoSuchFieldException, IllegalAccessException {
        log.debug("------------------1------------------"+data);
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
                    // log.debug("-----------------------------------------"+obj.toString());
                    for (Field field : obj.getClass().getDeclaredFields()) {
                        field.setAccessible(true);
                        if(!field.getName().equals("serialVersionUID")&&!field.getName().equals("id")){
                            cell = row.createCell(titleIndex++);
                            cell.setCellValue(transferEngToChinese(field.getName()));
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

    private String transferEngToChinese(String eng){
        Map<String,String> map= new HashMap<>();
        map.put("pdate","日期");
        map.put("cell","CellId");
        map.put("imei","imei");
        map.put("imsi","imsi");
        map.put("attachFaultRate","Attach失败率");
        map.put("attachRequest","Attach请求次数");
        map.put("attachFault","Attach失败次数");
        map.put("serviceFaultRate","SERVICE失败率");
        map.put("serviceRequest","SERVICE请求次数");
        map.put("serviceFault","SERVICE失败次数");
        map.put("csfbFaultRate","Extended Service失败率（for CSFB");
        map.put("csfbRequest","Extended Service请求次数（for CSFB");
        map.put("csfbFault","Extended Service失败次数（for CSFB");
        map.put("contextActivateFaultRate","默认承载激活失败率");
        map.put("contextActivateRequest","默认承载激活请求次数");
        map.put("contextActivateFault","默认承载激活失败");
        map.put("pdnRequestFaultRate","UE请求PDN连接失败率");
        map.put("pdnRequest","UE请求PDN连接请求次数");
        map.put("pdnRequestFault","UE请求PDN连接失败次数");
        map.put("tauFaultRate","TAU失败率");
        map.put("tauRequest","TAU请求次数");
        map.put("tauFault","TAU失败次数");
        map.put("xhoFaultRate","X2接口切换失败率");
        map.put("xhoRequest","X2接口切换尝试数");
        map.put("xhoFault","X2接口切换失败次数");
        map.put("shoFaultRate","S1接口切换失败率");
        map.put("shoRequest","S1接口切换请求次数");
        map.put("shoFault","S1接口切换失败次数");
        return map.get(eng);
    }
}
