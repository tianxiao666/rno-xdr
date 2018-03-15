package com.hgicreate.rno.xdr.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hgicreate.rno.xdr.backend.domain.Interfere;
import com.hgicreate.rno.xdr.backend.domain.Record;
import com.hgicreate.rno.xdr.backend.domain.Task;
import com.hgicreate.rno.xdr.backend.repository.InterfereRepository;
import com.hgicreate.rno.xdr.backend.repository.RecordRepository;
import com.hgicreate.rno.xdr.backend.repository.TaskRepository;
import com.hgicreate.rno.xdr.backend.service.TrainService;
import com.hgicreate.rno.xdr.backend.web.rest.util.PaginationUtil;
import io.swagger.annotations.ApiParam;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
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
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api")
public class TrainResource {
    private final Logger log = LoggerFactory.getLogger(TrainResource.class);

    private final TrainService trainService;

    private final TaskRepository taskRepository;

    private final RecordRepository recordRepository;

    private final InterfereRepository interfereRepository;

    public TrainResource(TrainService trainService,
                         TaskRepository taskRepository,
                         RecordRepository recordRepository,
                         InterfereRepository interfereRepository){
        this.trainService = trainService;
        this.taskRepository = taskRepository;
        this.recordRepository = recordRepository;
        this.interfereRepository = interfereRepository;
    }

    @GetMapping("/searchTrainSample")
    public ResponseEntity<List<String>> getSampleType(){
        List<Record> recordList= trainService.findByType("训练");
        List<String> typeList = new ArrayList<>();
        for(Record record: recordList){
            typeList.add(record.getType());
        }
        return new ResponseEntity<List<String>>(typeList,HttpStatus.OK);
    }

    @GetMapping("/searchTrain")
    @Timed
    public ResponseEntity<List<Task>> searchTrain(@RequestParam Long beginTime,
                                                @RequestParam Long endTime,
                                                @RequestParam String name,
                                                @RequestParam String status,
                                                @RequestParam String city,
                                                @ApiParam Pageable pageable){
        log.debug("进入查询训练记录方法beginTime={},endTime={},name={},status={},city={}",beginTime,endTime, name, status, city);
        Date dateFrom = new Date(beginTime);
        Date dateTo = new Date(endTime);
        Page<Task> taskPage = trainService.findByNameAndStatusAndTime(name,status,dateFrom.toInstant(),dateTo.toInstant(),"训练",pageable);
        HttpHeaders httpHeaders = PaginationUtil.generatePaginationHttpHeaders(taskPage,"/api/searchTrain");
        return new ResponseEntity<>(taskPage.getContent(),httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/addTrainTask")
    @ResponseBody
    public String addTrainTask(@RequestParam String sampleName,
                               @RequestParam String sampleExplain,
                               @RequestParam String sampleResource){
        Task task = new Task();
        task.setName(sampleName);
        task.setDescription(sampleExplain);
        Long fileId = recordRepository.findByTitle(sampleResource).getId();
        task.setFileId(fileId);
        task.setStartTime(new Date().toInstant());
        task.setType("干扰数据训练样本");
        taskRepository.save(task);
        List<Interfere> interferes=interfereRepository.findByFileId(fileId);
        String[][] prbArr = new String [interferes.size()][101];
        StringBuilder sb = new StringBuilder();
        for(int i= 0; i < prbArr.length ; i++){
            prbArr[i][0] = interferes.get(i).getPrb0().toString();
            prbArr[i][1] = interferes.get(i).getPrb1().toString();
            prbArr[i][2] = interferes.get(i).getPrb2().toString();
            prbArr[i][3] = interferes.get(i).getPrb3().toString();
            prbArr[i][4] = interferes.get(i).getPrb4().toString();
            prbArr[i][5] = interferes.get(i).getPrb5().toString();
            prbArr[i][6] = interferes.get(i).getPrb6().toString();
            prbArr[i][7] = interferes.get(i).getPrb7().toString();
            prbArr[i][8] = interferes.get(i).getPrb8().toString();
            prbArr[i][9] = interferes.get(i).getPrb9().toString();
            prbArr[i][10] = interferes.get(i).getPrb10().toString();
            prbArr[i][11] = interferes.get(i).getPrb11().toString();
            prbArr[i][12] = interferes.get(i).getPrb12().toString();
            prbArr[i][13] = interferes.get(i).getPrb13().toString();
            prbArr[i][14] = interferes.get(i).getPrb14().toString();
            prbArr[i][15] = interferes.get(i).getPrb15().toString();
            prbArr[i][16] = interferes.get(i).getPrb16().toString();
            prbArr[i][17] = interferes.get(i).getPrb17().toString();
            prbArr[i][18] = interferes.get(i).getPrb18().toString();
            prbArr[i][19] = interferes.get(i).getPrb19().toString();
            prbArr[i][20] = interferes.get(i).getPrb20().toString();
            prbArr[i][21] = interferes.get(i).getPrb21().toString();
            prbArr[i][22] = interferes.get(i).getPrb22().toString();
            prbArr[i][23] = interferes.get(i).getPrb23().toString();
            prbArr[i][24] = interferes.get(i).getPrb24().toString();
            prbArr[i][25] = interferes.get(i).getPrb25().toString();
            prbArr[i][26] = interferes.get(i).getPrb26().toString();
            prbArr[i][27] = interferes.get(i).getPrb27().toString();
            prbArr[i][28] = interferes.get(i).getPrb28().toString();
            prbArr[i][29] = interferes.get(i).getPrb29().toString();
            prbArr[i][30] = interferes.get(i).getPrb30().toString();
            prbArr[i][31] = interferes.get(i).getPrb31().toString();
            prbArr[i][32] = interferes.get(i).getPrb32().toString();
            prbArr[i][33] = interferes.get(i).getPrb33().toString();
            prbArr[i][34] = interferes.get(i).getPrb34().toString();
            prbArr[i][35] = interferes.get(i).getPrb35().toString();
            prbArr[i][36] = interferes.get(i).getPrb36().toString();
            prbArr[i][37] = interferes.get(i).getPrb37().toString();
            prbArr[i][38] = interferes.get(i).getPrb38().toString();
            prbArr[i][39] = interferes.get(i).getPrb39().toString();
            prbArr[i][40] = interferes.get(i).getPrb40().toString();
            prbArr[i][41] = interferes.get(i).getPrb41().toString();
            prbArr[i][42] = interferes.get(i).getPrb42().toString();
            prbArr[i][43] = interferes.get(i).getPrb43().toString();
            prbArr[i][44] = interferes.get(i).getPrb44().toString();
            prbArr[i][45] = interferes.get(i).getPrb45().toString();
            prbArr[i][46] = interferes.get(i).getPrb46().toString();
            prbArr[i][47] = interferes.get(i).getPrb47().toString();
            prbArr[i][48] = interferes.get(i).getPrb48().toString();
            prbArr[i][49] = interferes.get(i).getPrb49().toString();
            prbArr[i][50] = interferes.get(i).getPrb50().toString();
            prbArr[i][51] = interferes.get(i).getPrb51().toString();
            prbArr[i][52] = interferes.get(i).getPrb52().toString();
            prbArr[i][53] = interferes.get(i).getPrb53().toString();
            prbArr[i][54] = interferes.get(i).getPrb54().toString();
            prbArr[i][55] = interferes.get(i).getPrb55().toString();
            prbArr[i][56] = interferes.get(i).getPrb56().toString();
            prbArr[i][57] = interferes.get(i).getPrb57().toString();
            prbArr[i][58] = interferes.get(i).getPrb58().toString();
            prbArr[i][59] = interferes.get(i).getPrb59().toString();
            prbArr[i][60] = interferes.get(i).getPrb60().toString();
            prbArr[i][61] = interferes.get(i).getPrb61().toString();
            prbArr[i][62] = interferes.get(i).getPrb62().toString();
            prbArr[i][63] = interferes.get(i).getPrb63().toString();
            prbArr[i][64] = interferes.get(i).getPrb64().toString();
            prbArr[i][65] = interferes.get(i).getPrb65().toString();
            prbArr[i][66] = interferes.get(i).getPrb66().toString();
            prbArr[i][67] = interferes.get(i).getPrb67().toString();
            prbArr[i][68] = interferes.get(i).getPrb68().toString();
            prbArr[i][69] = interferes.get(i).getPrb69().toString();
            prbArr[i][70] = interferes.get(i).getPrb70().toString();
            prbArr[i][71] = interferes.get(i).getPrb71().toString();
            prbArr[i][72] = interferes.get(i).getPrb72().toString();
            prbArr[i][73] = interferes.get(i).getPrb73().toString();
            prbArr[i][74] = interferes.get(i).getPrb74().toString();
            prbArr[i][75] = interferes.get(i).getPrb75().toString();
            prbArr[i][76] = interferes.get(i).getPrb76().toString();
            prbArr[i][77] = interferes.get(i).getPrb77().toString();
            prbArr[i][78] = interferes.get(i).getPrb78().toString();
            prbArr[i][79] = interferes.get(i).getPrb79().toString();
            prbArr[i][80] = interferes.get(i).getPrb80().toString();
            prbArr[i][81] = interferes.get(i).getPrb81().toString();
            prbArr[i][82] = interferes.get(i).getPrb82().toString();
            prbArr[i][83] = interferes.get(i).getPrb83().toString();
            prbArr[i][84] = interferes.get(i).getPrb84().toString();
            prbArr[i][85] = interferes.get(i).getPrb85().toString();
            prbArr[i][86] = interferes.get(i).getPrb86().toString();
            prbArr[i][87] = interferes.get(i).getPrb87().toString();
            prbArr[i][88] = interferes.get(i).getPrb88().toString();
            prbArr[i][89] = interferes.get(i).getPrb89().toString();
            prbArr[i][90] = interferes.get(i).getPrb90().toString();
            prbArr[i][91] = interferes.get(i).getPrb91().toString();
            prbArr[i][92] = interferes.get(i).getPrb92().toString();
            prbArr[i][93] = interferes.get(i).getPrb93().toString();
            prbArr[i][94] = interferes.get(i).getPrb94().toString();
            prbArr[i][95] = interferes.get(i).getPrb95().toString();
            prbArr[i][96] = interferes.get(i).getPrb96().toString();
            prbArr[i][97] = interferes.get(i).getPrb97().toString();
            prbArr[i][98] = interferes.get(i).getPrb98().toString();
            prbArr[i][99] = interferes.get(i).getPrb99().toString();
            switch (interferes.get(i).getInterfereGrade()){
                case "无干扰":
                    prbArr[i][100] = "0";
                    break;
                case "弱干扰":
                    prbArr[i][100] = "1";
                    break;
                case "一般干扰":
                    prbArr[i][100] = "2";
                    break;
                case "强干扰":
                    prbArr[i][100] = "3";
                    break;
                case "超强干扰":
                    prbArr[i][100] = "4";
                    break;
                case "特强干扰":
                    prbArr[i][100] = "5";
            }
        }
        String urlNameString ="train";
        String result="";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost =new HttpPost(urlNameString);
        CloseableHttpResponse response=null;
        try {
            List<NameValuePair> nvps = new ArrayList<>();
            nvps.add(new BasicNameValuePair("id",task.getId().toString()));
            nvps.add(new BasicNameValuePair("data",Arrays.deepToString(prbArr)));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            response = httpClient.execute(httpPost);
            HttpEntity httpEntity =response.getEntity();
            task.setStatus(EntityUtils.toString(httpEntity));
            taskRepository.save(task);
            return EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
            return "添加训练任务失败";
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @PostMapping("/aiResult")
    public void getAiResult(@RequestParam String id,
                            @RequestParam String type,
                            @RequestParam Double confidence,
                            @RequestParam int [] data,
                            HttpServletResponse response){
        if(type.equals("train")){
            Task idTask = taskRepository.findOne(Long.parseLong(id));
            idTask.setConfidence(confidence);
            taskRepository.save(idTask);
        }else{
            List<Interfere> interfereList = new ArrayList<>();
             interfereList=   interfereRepository.findByTaskId(Long.parseLong(id));
             if(data.length == interfereList.size() ){
                 for(int i =0; i< data.length; i++){
                     Interfere interfere = new Interfere();
                    switch (data[i]) {
                        case 0:
                             interfere=interfereRepository.findOne(interfereList.get(i).getId());
                                interfere.setSolveType("无干扰");
                        case 1:
                             interfere=interfereRepository.findOne(interfereList.get(i).getId());
                            interfere.setSolveType("互调干扰");
                        case 2:
                             interfere=interfereRepository.findOne(interfereList.get(i).getId());
                            interfere.setSolveType("谐波干扰");
                        case 3:
                             interfere=interfereRepository.findOne(interfereList.get(i).getId());
                            interfere.setSolveType("杂散干扰");
                        case 4:
                             interfere=interfereRepository.findOne(interfereList.get(i).getId());
                            interfere.setSolveType("阻塞干扰");
                        case 5:
                             interfere=interfereRepository.findOne(interfereList.get(i).getId());
                            interfere.setSolveType("外部干扰器干扰");
                    }
                     interfereRepository.save(interfere);
                 }
             }
        }

    }

}
