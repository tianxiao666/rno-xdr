package com.hgicreate.rno.xdr.backend.service;

import com.hgicreate.rno.xdr.backend.service.dto.DataImportDTO;
import com.hgicreate.rno.xdr.backend.web.rest.cond.DataImportCond;
import org.apache.poi.ss.usermodel.*;
import com.alibaba.fastjson.JSONObject;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.*;
import java.math.BigInteger;
import java.sql.*;
import java.util.*;

import com.monitorjbl.xlsx.StreamingReader;

@Service
@Transactional
public class DataImportService {

    private final Logger log = LoggerFactory.getLogger(DataImportService.class);

    private final EntityManager entityManager;

    public DataImportService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private String url="jdbc:postgresql://192.168.6.70:5432/uir";
    private String user="xdr";
    private String password = "xdr";
    private Long fileId = (long)1;
    private Boolean successFlag = true;

    @Transactional(readOnly = true)
    public Page<DataImportDTO> findByCond(DataImportCond cond, Pageable pageable) {
        String sql = cond.buildSql();
        String countSql = "select count(*) from (" + sql + ") count_sql";
        Query query = entityManager.createNativeQuery(sql);
        Query countQuery = entityManager.createNativeQuery(countSql);
        if (query == null || countQuery == null) {
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
        Long total = ((BigInteger)countQuery.getSingleResult()).longValue();
        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        List<DataImportDTO> content = total > pageable.getOffset() ? query.getResultList() : Collections.emptyList();
        return new PageImpl<>(content, pageable, total);
    }

    public void runImoportTask(String path,String fileName,String importArea, String importType, String importAuthor, String importDate) {
        List<JSONObject> list = new ArrayList<JSONObject>();
        String areaFlag = "";
        String areaId = "";
        List sheetList = new ArrayList();
        try {
            InputStream is = new FileInputStream(new File(path));
            Workbook workbook = StreamingReader.builder()
            .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
            .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
            .open(is);            // InputStream or File for XLSX file (required)
            for (Sheet sheet : workbook){
                for (Row r : sheet) {
                    JSONObject jsonObject  = new JSONObject();
                    //JSON.toJSONStringZ(jsonObject, SerializeConfig.getGlobalInstance(), SerializerFeature.QuoteFieldNames);
                    if(r.getRowNum() != 0){
                        for (Cell c : r) {
                            if(c.getColumnIndex()==3){
                                if(areaFlag==c.getStringCellValue()){
                                    jsonObject.put(Integer.toString(c.getColumnIndex()),areaId);
                                }else {
                                    areaFlag = c.getStringCellValue();
                                    String sql = "select parent_id from rno_uir_area where name = " + "'" + c.getStringCellValue().replace("\"", "") + "'";
                                    Query queryAreaId = entityManager.createNativeQuery(sql);
                                    areaId = queryAreaId.getSingleResult().toString();
                                    jsonObject.put(Integer.toString(c.getColumnIndex()), areaId);
                                }
                            }else if(c.getColumnIndex()==1||c.getColumnIndex()==2||(c.getColumnIndex()>113&&c.getColumnIndex()<121)){

                            }else if(c.getColumnIndex()==113){
                                jsonObject.put(Integer.toString(c.getColumnIndex()),c.getStringCellValue().replace("\"", ""));
                            }else {
                                if("干扰数据".equals(importType)){
                                    if(c.getColumnIndex()<114){         //过滤掉最后的干扰等级一列
                                        jsonObject.put(Integer.toString(c.getColumnIndex()),c.getStringCellValue());
                                    }
                                }else {
                                    jsonObject.put(Integer.toString(c.getColumnIndex()),c.getStringCellValue());
                                }

                            }
                            jsonObject.put("2",fileId);
                        }
                        list.add(jsonObject);
                    }
                }
                sheetList.add(sheet.getSheetName());
            }
            log.debug("开始写入文件");
            exportFile(list,path,fileId,fileName,importArea,importType,importAuthor,importDate);
            fileId++;
        }catch (Exception e){
            successFlag = false;
            e.printStackTrace();
        }
    }


    public void copyToPg(String filePath, String fileName,Long fileId,Long fileSize,String importArea, String importType, String importAuthor, String importDate){
        Connection conn = null;
        CopyManager copyManager = null;
        FileReader reader = null;
        String importStat = "入库成功";
        String tablename = "";
        try{
            if("干扰数据".equals(importType)){
                tablename = "rno_uir_interfere_data(prb75,prb76,prb97,prb98,prb99,average_interfere,prb77,prb78,prb79,prb80,prb81,prb82,prb83,prb84,latitude,prb85,working_band,prb86,carrier_frequency,prb0,prb1,prb2,prb3,prb4,prb5,prb6,file_time,file_id,area_id,factory,enodeb,cell_name,cell_identifier,cover_type,longitude,prb7,prb8,prb9,prb10,prb11,prb12,prb13,prb14,prb15,prb16,prb17,prb18,prb19,prb20,prb21,prb22,prb23,prb24,prb25,prb26,prb27,prb28,prb29,prb30,prb31,prb32,prb33,prb34,prb35,prb36,prb37,prb38,prb39,prb40,prb41,prb42,prb43,prb44,prb45,prb46,prb47,prb48,prb49,prb50,prb51,prb52,prb53,prb54,prb55,prb56,prb57,prb58,prb59,prb60,prb61,prb62,prb63,prb64,prb65,prb66,prb87,prb88,prb89,prb90,prb91,prb92,prb93,prb67,prb94,prb68,prb95,prb69,prb96,prb70,prb71,prb72,prb73,prb74)";
            }else if("干扰数据测试样本".equals(importType)){
                tablename = "rno_uir_interfere_data_test(prb75,prb76,prb97,prb98,prb99,average_interfere,prb77,prb78,prb79,prb80,prb81,prb82,prb83,prb84,latitude,prb85,working_band,prb86,carrier_frequency,prb0,prb1,prb2,prb3,prb4,prb5,prb6,file_time,interfere_grade,file_id,area_id,factory,enodeb,cell_name,cell_identifier,cover_type,longitude,prb7,prb8,prb9,prb10,prb11,prb12,prb13,prb14,prb15,prb16,prb17,prb18,prb19,prb20,prb21,prb22,prb23,prb24,prb25,prb26,prb27,prb28,prb29,prb30,prb31,prb32,prb33,prb34,prb35,prb36,prb37,prb38,prb39,prb40,prb41,prb42,prb43,prb44,prb45,prb46,prb47,prb48,prb49,prb50,prb51,prb52,prb53,prb54,prb55,prb56,prb57,prb58,prb59,prb60,prb61,prb62,prb63,prb64,prb65,prb66,prb87,prb88,prb89,prb90,prb91,prb92,prb93,prb67,prb94,prb68,prb95,prb69,prb96,prb70,prb71,prb72,prb73,prb74)";
            }else if("干扰数据训练样本".equals(importType)){
                tablename = "rno_uir_interfere_data_train(prb75,prb76,prb97,prb98,prb99,average_interfere,prb77,prb78,prb79,prb80,prb81,prb82,prb83,prb84,latitude,prb85,working_band,prb86,carrier_frequency,prb0,prb1,prb2,prb3,prb4,prb5,prb6,file_time,interfere_grade,file_id,area_id,factory,enodeb,cell_name,cell_identifier,cover_type,longitude,prb7,prb8,prb9,prb10,prb11,prb12,prb13,prb14,prb15,prb16,prb17,prb18,prb19,prb20,prb21,prb22,prb23,prb24,prb25,prb26,prb27,prb28,prb29,prb30,prb31,prb32,prb33,prb34,prb35,prb36,prb37,prb38,prb39,prb40,prb41,prb42,prb43,prb44,prb45,prb46,prb47,prb48,prb49,prb50,prb51,prb52,prb53,prb54,prb55,prb56,prb57,prb58,prb59,prb60,prb61,prb62,prb63,prb64,prb65,prb66,prb87,prb88,prb89,prb90,prb91,prb92,prb93,prb67,prb94,prb68,prb95,prb69,prb96,prb70,prb71,prb72,prb73,prb74)";
            }else {
                log.debug("干扰类型为空！");
            }
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection(url, user, password);
            copyManager = new CopyManager((BaseConnection)conn);
            reader = new FileReader(new File(filePath));
            copyManager.copyIn("copy "+tablename+" from stdin delimiter as ',' NULL as 'null'",reader);
            log.debug("入库完成");
            File testFile = new File(filePath);
            if(testFile.exists()){
                log.info("删除已存在的文件 :{}", testFile.getName());
                testFile.delete();
            }
        }catch(Exception ex){
            log.debug("读取文件出错");
            importStat = "入库失败";
            ex.printStackTrace();
        }finally{
            String sql="select id from jhi_user where login = " + "'" + importAuthor +"'";
            Query queryAuthorId = entityManager.createNativeQuery(sql);
            String authorId = queryAuthorId.getSingleResult().toString();
            Query insert = entityManager.createNativeQuery("insert into rno_uir_import_record ( id,area,import_time,user_id,file_name,file_type,file_count ,state ) values (?, ?, ?, ?, ?, ?, ?, ?)")
                .setParameter(1, fileId)
                .setParameter(2, importArea)
                .setParameter(3, importDate)
                .setParameter(4, Integer.parseInt(authorId))
                .setParameter(5, fileName)
                .setParameter(6, importType)
                .setParameter(7, fileSize)
                .setParameter(8, importStat);
            insert.executeUpdate();
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void exportFile(List<JSONObject> list, String filePath,Long fileId, String fileName,String importArea, String importType, String importAuthor, String importDate){
        String outName = "D://tmp/uridata/" + UUID.randomUUID() + ".xlsx";
        FileWriter out = null;
        Long fileCount= (long)0;
        int length = 0;
        if("干扰数据".equals(importType)){
            length = 113;
        }else {
            length = 114;
        }
        try{
            out = new FileWriter(new File(outName));
            for(int i=0;i<list.size();i++){
                Object[] objs = list.get(i).values().toArray();
                if(objs.length==length){
                    fileCount++;
                    for(int j=0;j<objs.length;j++){
                        out.write(String.valueOf(objs[j]));
                        if(j != objs.length - 1){
                            out.write(",");
                        }
                    }
                    if(i != list.size() - 1){
                        out.write("\n");
                    }
                }
            }
            out.flush();
            File testFile = new File(filePath);
            if(testFile.exists()){
                log.info("删除已存在的文件 :{}", testFile.getName());
                testFile.delete();
            }
            log.debug("开始写入数据库");
            copyToPg(outName,fileName,fileId,fileCount,importArea,importType,importAuthor,importDate);
        }catch(Exception ex){
            log.debug("解析文件出错");
            successFlag = false;
            ex.printStackTrace();
        }finally{
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
