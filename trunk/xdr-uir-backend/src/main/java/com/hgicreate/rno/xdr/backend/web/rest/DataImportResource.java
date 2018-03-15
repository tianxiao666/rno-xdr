package com.hgicreate.rno.xdr.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hgicreate.rno.xdr.backend.domain.DataImport;

import com.hgicreate.rno.xdr.backend.repository.DataImportRepository;
import com.hgicreate.rno.xdr.backend.repository.search.DataImportSearchRepository;
import com.hgicreate.rno.xdr.backend.service.DataImportService;
import com.hgicreate.rno.xdr.backend.web.rest.cond.DataImportCond;
import com.hgicreate.rno.xdr.backend.web.rest.util.HeaderUtil;
import com.hgicreate.rno.xdr.backend.web.rest.util.PaginationUtil;
import com.hgicreate.rno.xdr.backend.service.dto.DataImportDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.DataImportMapper;
import io.swagger.annotations.ApiParam;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.MultipartConfigElement;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * REST controller for managing DataImport.
 */
@RestController
@RequestMapping("/api")
public class DataImportResource {

    private final Logger log = LoggerFactory.getLogger(DataImportResource.class);

    private static final String ENTITY_NAME = "dataImport";

    private final DataImportRepository dataImportRepository;

    private final DataImportMapper dataImportMapper;

    private final DataImportSearchRepository dataImportSearchRepository;

    private final DataImportService dataImportService;

    private String importArea ;
    private String importType ;
    private String importAuthor ;
    private String importDate ;

    @Autowired
    private MultipartConfigElement multipartConfigElement;

    public DataImportResource(DataImportRepository dataImportRepository, DataImportMapper dataImportMapper,
                              DataImportSearchRepository dataImportSearchRepository,DataImportService dataImportService) {
        this.dataImportRepository = dataImportRepository;
        this.dataImportMapper = dataImportMapper;
        this.dataImportSearchRepository = dataImportSearchRepository;
        this.dataImportService = dataImportService;
    }

    /**
     * POST  /data-imports : Create a new dataImport.
     *
     * @param dataImportDTO the dataImportDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new dataImportDTO, or with status 400 (Bad Request) if the dataImport has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/data-imports")
    @Timed
    public ResponseEntity<DataImportDTO> createDataImport(@RequestBody DataImportDTO dataImportDTO) throws URISyntaxException {
        log.debug("REST request to save DataImport : {}", dataImportDTO);
        if (dataImportDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new dataImport cannot already have an ID")).body(null);
        }
        DataImport dataImport = dataImportMapper.toEntity(dataImportDTO);
        dataImport = dataImportRepository.save(dataImport);
        DataImportDTO result = dataImportMapper.toDto(dataImport);
        dataImportSearchRepository.save(dataImport);
        return ResponseEntity.created(new URI("/api/data-imports/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /data-imports : Updates an existing dataImport.
     *
     * @param dataImportDTO the dataImportDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated dataImportDTO,
     * or with status 400 (Bad Request) if the dataImportDTO is not valid,
     * or with status 500 (Internal Server Error) if the dataImportDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/data-imports")
    @Timed
    public ResponseEntity<DataImportDTO> updateDataImport(@RequestBody DataImportDTO dataImportDTO) throws URISyntaxException {
        log.debug("REST request to update DataImport : {}", dataImportDTO);
        if (dataImportDTO.getId() == null) {
            return createDataImport(dataImportDTO);
        }
        DataImport dataImport = dataImportMapper.toEntity(dataImportDTO);
        dataImport = dataImportRepository.save(dataImport);
        DataImportDTO result = dataImportMapper.toDto(dataImport);
        dataImportSearchRepository.save(dataImport);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, dataImportDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /data-imports : get all the dataImports.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of dataImports in body
     */
    @GetMapping("/data-imports")
    @Timed
    public ResponseEntity<List<DataImportDTO>> getAllDataImports(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of DataImports");
        Page<DataImport> page = dataImportRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/data-imports");
        return new ResponseEntity<>(dataImportMapper.toDto(page.getContent()), headers, HttpStatus.OK);
    }

    /**
     * GET  /data-imports/:id : get the "id" dataImport.
     *
     * @param id the id of the dataImportDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the dataImportDTO, or with status 404 (Not Found)
     */
    @GetMapping("/data-imports/{id}")
    @Timed
    public ResponseEntity<DataImportDTO> getDataImport(@PathVariable Long id) {
        log.debug("REST request to get DataImport : {}", id);
        DataImport dataImport = dataImportRepository.findOne(id);
        DataImportDTO dataImportDTO = dataImportMapper.toDto(dataImport);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(dataImportDTO));
    }

    /**
     * DELETE  /data-imports/:id : delete the "id" dataImport.
     *
     * @param id the id of the dataImportDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/data-imports/{id}")
    @Timed
    public ResponseEntity<Void> deleteDataImport(@PathVariable Long id) {
        log.debug("REST request to delete DataImport : {}", id);
        dataImportRepository.delete(id);
        dataImportSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/data-imports?query=:query : search for the dataImport corresponding
     * to the query.
     *
     * @param cond the query array of the dataImport search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/data-imports")
    @Timed
    public ResponseEntity<List<DataImportDTO>> searchDataImports(@ApiParam DataImportCond cond, @ApiParam Pageable pageable) {
        log.debug("REST request to get a page of data-imports : cond = {}, pageable = {}", cond, pageable);
        Page<DataImportDTO> page = dataImportService.findByCond(cond, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/_search/data-imports");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/_import/data-imports")
    @ResponseBody
    public ResponseEntity<String> uploadFile(MultipartHttpServletRequest request) {
        log.debug("正在上传文件");
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf;
        while (itr.hasNext()) {
            try {
                mpf = request.getFile(itr.next());
                String fileName = mpf.getOriginalFilename();
                Path filePath = Paths.get(multipartConfigElement.getLocation(), fileName);
                File testFile = new File(filePath.toString());
                if(testFile.exists()){
                    log.info("删除已存在的文件 :{}", testFile.getName());
                    testFile.delete();
                }
                mpf.transferTo(filePath.toFile());
                log.info("文件上传完成 :{}", fileName);
                new Thread() {
                    public void run() {
                        dataImportService.runImoportTask(filePath.toString(),fileName,importArea,importType,importAuthor,importDate);
                    }
                }.start();
            } catch (Exception e) {
                log.debug("上传出错");
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/_import/data-imports-message")
    public void uploadFileMessage(@RequestBody Object query) {
        String arr = query.toString().replaceAll("[\\{\\}]", "");
        importArea = arr.split(",")[0].split("=")[1];
        importType = arr.split(",")[1].split("=")[1];
        importAuthor = arr.split(",")[2].split("=")[1];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        importDate = sdf.format(new Date());
    }
}
