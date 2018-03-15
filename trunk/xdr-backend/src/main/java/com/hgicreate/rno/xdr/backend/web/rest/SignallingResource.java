package com.hgicreate.rno.xdr.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hgicreate.rno.xdr.backend.service.SignallingService;
import com.hgicreate.rno.xdr.backend.web.rest.util.HeaderUtil;
import com.hgicreate.rno.xdr.backend.web.rest.util.PaginationUtil;
import com.hgicreate.rno.xdr.backend.service.dto.SignallingDTO;
import io.swagger.annotations.ApiParam;
import io.github.jhipster.web.util.ResponseUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.json.JSONException;
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
 * REST controller for managing Signalling.
 */
@RestController
@RequestMapping("/api")
public class SignallingResource {

    private final Logger log = LoggerFactory.getLogger(SignallingResource.class);

    private static final String ENTITY_NAME = "signalling";

    private final SignallingService signallingService;

    public SignallingResource(SignallingService signallingService) {
        this.signallingService = signallingService;
    }

    /**
     * POST  /signallings : Create a new signalling.
     *
     * @param signallingDTO the signallingDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new signallingDTO, or with status 400 (Bad Request) if the signalling has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/signallings")
    @Timed
    public ResponseEntity<SignallingDTO> createSignalling(@Valid @RequestBody SignallingDTO signallingDTO) throws URISyntaxException {
        log.debug("REST request to save Signalling : {}", signallingDTO);
        if (signallingDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new signalling cannot already have an ID")).body(null);
        }
        SignallingDTO result = signallingService.save(signallingDTO);
        return ResponseEntity.created(new URI("/api/signallings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /signallings : Updates an existing signalling.
     *
     * @param signallingDTO the signallingDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated signallingDTO,
     * or with status 400 (Bad Request) if the signallingDTO is not valid,
     * or with status 500 (Internal Server Error) if the signallingDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/signallings")
    @Timed
    public ResponseEntity<SignallingDTO> updateSignalling(@Valid @RequestBody SignallingDTO signallingDTO) throws URISyntaxException {
        log.debug("REST request to update Signalling : {}", signallingDTO);
        if (signallingDTO.getId() == null) {
            return createSignalling(signallingDTO);
        }
        SignallingDTO result = signallingService.save(signallingDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, signallingDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /signallings : get all the signallings.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of signallings in body
     */
    @GetMapping("/signallings")
    @Timed
    public ResponseEntity<List<SignallingDTO>> getAllSignallings(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Signallings");
        Page<SignallingDTO> page = signallingService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/signallings");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /signallings/:id : get the "id" signalling.
     *
     * @param id the id of the signallingDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the signallingDTO, or with status 404 (Not Found)
     */
    @GetMapping("/signallings/{id}")
    @Timed
    public ResponseEntity<SignallingDTO> getSignalling(@PathVariable Long id) {
        log.debug("REST request to get Signalling : {}", id);
        SignallingDTO signallingDTO = signallingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(signallingDTO));
    }

    /**
     * DELETE  /signallings/:id : delete the "id" signalling.
     *
     * @param id the id of the signallingDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/signallings/{id}")
    @Timed
    public ResponseEntity<Void> deleteSignalling(@PathVariable Long id) {
        log.debug("REST request to delete Signalling : {}", id);
        signallingService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/signallings?query=:query : search for the signalling corresponding
     * to the query.
     *
     * @param query the query of the signalling search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/signallings")
    @Timed
    public ResponseEntity<List<SignallingDTO>> searchSignallings(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of Signallings for query {}", query);
        Page<SignallingDTO> page = signallingService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/signallings");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /signallings/findByTimeAndImsi : get signallings by time and imsi.
     *
     * @param beginTime the begin time of the signallingDTO to retrieve
     * @param endTime   the end time of the signallingDTO to retrieve
     * @param imsi      the imsi of the signallingDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and the list of signallings in body
     */
    @GetMapping("/signallings/findByTimeAndImsi")
    @Timed
    public ResponseEntity<List<SignallingDTO>> findByTimeAndImsi(@RequestParam Long beginTime, @RequestParam Long endTime, @RequestParam Long imsi, @ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Signallings : beginTime = {}, endTime = {}, imsi = {}, pageable = {}", beginTime, endTime, imsi, pageable);
        Page<SignallingDTO> page = signallingService.findByTimeAndImsi(beginTime, endTime, imsi, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/signallings/findByTimeAndImsi");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /signallings/downloadByTimeAndImsi : download signallings by time and imsi.
     *
     * @param beginTime the begin time of the signallingDTO to retrieve
     * @param endTime   the end time of the signallingDTO to retrieve
     * @param imsi      the imsi of the signallingDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and the list of signallings in body
     */
    @GetMapping("/signallings/downloadByTimeAndImsi")
    @Timed
    public ResponseEntity<List<SignallingDTO>> downloadByTimeAndImsi(@RequestParam Long beginTime, @RequestParam Long endTime, @RequestParam Long imsi) {
        log.debug("REST request to get a page of Signallings : beginTime = {}, endTime = {}, imsi = {}", beginTime, endTime, imsi);
        List<SignallingDTO> list = signallingService.downloadByTimeAndImsi(beginTime, endTime, imsi);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(list));
    }

    @GetMapping("/signallings/mobile/downloadByTimeAndImsi")
    @Timed
    @CrossOrigin
    public void downloadSignalling(@RequestParam Long beginTime,
                                   @RequestParam Long endTime,
                                   @RequestParam Long imsi,
                                   HttpServletResponse response) throws IllegalAccessException, NoSuchFieldException, JSONException {
        log.debug("REST request to get a page of Signallings : beginTime = {}, endTime = {}, imsi = {}", beginTime, endTime, imsi);
        List<SignallingDTO> list = signallingService.downloadByTimeAndImsi(beginTime, endTime, imsi);
        String fileName = "用户信令事件回溯提取结果.xlsx";
        try {
            fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  // 为了解决中文名称乱码问题
        }

        response.setContentType("application/x.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);

        Map<String, List> res = new LinkedHashMap<>();
        res.put("data",list);
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
        map.put("startTime","开始时间");
        map.put("endTime","结束时间");
        map.put("interfaceType","接口类型");
        map.put("cell","cell");
        map.put("imei","imei");
        map.put("imsi","imsi");
        map.put("appType","appType");
        map.put("appStatus","appStatus");
        map.put("protocolType","协议类型");
        map.put("appSubType","应用程序子类型");
        map.put("ulData","上行数据流量");
        map.put("dlData","下行数据流量");
        map.put("lastHttpResponseDelay","Http响应延迟");
        map.put("procedureType","程序类型");
        map.put("procedureStatus","程序状态");
        map.put("cause","原因");
        map.put("keyword","关键词");
        map.put("targetCellid","目标小区标识");
        map.put("csfbIndication","csfb指标");
        map.put("reqCauseType","请求原因类型");
        map.put("reqCause","请求原因");
        map.put("failureCauseType","故障原因类型");
        map.put("failureCause","失败原因");
        map.put("errorCauseType","错误原因类型");
        map.put("errorCause","错误原因");
        map.put("hoCancelCauseType","切换取消原因类型");
        map.put("hoCancelCause","切换取消原因");
        map.put("rowCount","匹配MR行数");
        map.put("servingRsrp","服务Rsrp");
        map.put("servingRsrpAvg","服务平均Rsrp");
        map.put("servingRsrpStdDev","服务Rsrp标准差");
        map.put("servingRsrq","服务Rsrq");
        map.put("servingRsrqAvg","服务平均Rsrq");
        map.put("servingRsrqStdDev","服务Rsrq标准差");
        map.put("aoa","aoa");
        map.put("aoaAvg","平均aoa");
        map.put("aoaStdDev","aoa标准差");
        map.put("ta","ta");
        map.put("taAvg","平均ta");
        map.put("taStdDev","ta标准差");
        map.put("ulSinr","ulSinr");
        map.put("ulSinrAvg","平均ulSinr");
        map.put("ulSinrStdDev","ulSinr标准差");
        map.put("enbReceivedPower","enbReceivedPower");
        map.put("enbReceivedPowerAvg","平均enbReceivedPower");
        map.put("enbReceivedPowerStdDev","enbReceivedPower标准差");
        map.put("phr","phr");
        map.put("phrAvg","平均phr");
        map.put("phrStdDev","phr标准差");
        return map.get(eng);
    }
}
