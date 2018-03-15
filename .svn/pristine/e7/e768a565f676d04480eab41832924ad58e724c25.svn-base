package com.hgicreate.rno.xdr.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hgicreate.rno.xdr.backend.domain.Record;
import com.hgicreate.rno.xdr.backend.domain.Task;
import com.hgicreate.rno.xdr.backend.repository.InterfereRepository;
import com.hgicreate.rno.xdr.backend.repository.RecordRepository;
import com.hgicreate.rno.xdr.backend.repository.TaskRepository;
import com.hgicreate.rno.xdr.backend.service.TrainService;
import com.hgicreate.rno.xdr.backend.web.rest.util.PaginationUtil;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestResource {
    private final Logger log = LoggerFactory.getLogger(TestResource.class);

    private final TaskRepository taskRepository;

    private final RecordRepository recordRepository;

    private final InterfereRepository interfereRepository;

    private final TrainService trainService;

    public TestResource(TaskRepository taskRepository,
                        RecordRepository recordRepository,
                        InterfereRepository interfereRepository,
                        TrainService trainService){
        this.taskRepository = taskRepository;
        this.recordRepository = recordRepository;
        this.interfereRepository = interfereRepository;
        this.trainService = trainService;
    }

    @GetMapping("/searchTestSample")
    public ResponseEntity<List<String>> getTestSampleType(){
        List<Record> recordList= trainService.findByType("测试");
        List<String> typeList = new ArrayList<>();
        for(Record record: recordList){
            typeList.add(record.getType());
        }
        return new ResponseEntity<>(typeList, HttpStatus.OK);
    }

    @GetMapping("/searchTest")
    @Timed
    public ResponseEntity<List<Task>> searchTest(@RequestParam Long beginTime,
                                                  @RequestParam Long endTime,
                                                  @RequestParam String name,
                                                  @RequestParam String status,
                                                  @RequestParam String city,
                                                  @ApiParam Pageable pageable){
        log.debug("进入查询测试记录方法beginTime={},endTime={},name={},status={},city={}",beginTime,endTime, name, status, city);
        Date dateFrom = new Date(beginTime);
        Date dateTo = new Date(endTime);
        Page<Task> taskPage = trainService.findByNameAndStatusAndTime(name,status,dateFrom.toInstant(),dateTo.toInstant(),"测试",pageable);
        HttpHeaders httpHeaders = PaginationUtil.generatePaginationHttpHeaders(taskPage,"/api/searchTest");
        return new ResponseEntity<>(taskPage.getContent(),httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/addTestTask")
    @ResponseBody
    public String addTestTask(@RequestParam String sampleName,
                               @RequestParam String sampleExplain,
                               @RequestParam String sampleResource){
        Task task = new Task();
        task.setName(sampleName);
        task.setDescription(sampleExplain);
        //task.setFileId(recordRepository.findByTitle(sampleResource).getId());
        task.setStartTime(new Date().toInstant());
        task.setType("干扰数据测试样本");
        String urlNameString ="solve";
        String result="";
       /* CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost =new HttpPost(urlNameString);
        CloseableHttpResponse response=null;
        try {
            List<NameValuePair> nvps = new ArrayList<>();
            nvps.add(new BasicNameValuePair("id","1"));
            nvps.add(new BasicNameValuePair("data",""));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            response = httpClient.execute(httpPost);
            InputStream inputStream =response.getEntity().getContent();
        } catch (IOException e) {
            e.printStackTrace();
            return "添加测试任务失败";
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        taskRepository.save(task);
        return "添加测试任务成功";
    }
}
