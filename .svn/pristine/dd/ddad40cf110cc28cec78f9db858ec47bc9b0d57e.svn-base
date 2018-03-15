package com.hgicreate.rno.xdr.backend.web.rest.cond;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataImportCond {
    private String area;
    private Long date1;
    private Long date2;
    private String importType;

    public DataImportCond() {
    }

    public String getArea() {
        return area;
    }

    public Long getDate1() {
        return date1;
    }

    public Long getDate2() {
        return date2;
    }

    public String getImportType() {
        return importType;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setDate1(Long date1) {
        this.date1 = date1;
    }

    public void setDate2(Long date2) {
        this.date2 = date2;
    }

    public void setImportType(String importType) {
        this.importType = importType;
    }

    @Override
    public String toString() {
        return "DataImportCond{" +
            "area='" + area + '\'' +
            ", date1=" + date1 +
            ", date2=" + date2 +
            ", importType='" + importType + '\'' +
            '}';
    }

    public String buildSql() {
        Date date1 = new Date(this.date1);
        Date date2 = new Date(this.date2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String where = "where area = '" + area + "'" + " and file_type = '" + importType + "'" + " and import_time >= '" + sdf.format(date1) + "'" + " and import_time <= '"+ sdf.format(date2) + "'" ;
        String sql = "select import_time, area, user_id, file_name, file_type, file_count, state "
            +"from rno_uir_import_record " + where;
        return sql;
    }
}
