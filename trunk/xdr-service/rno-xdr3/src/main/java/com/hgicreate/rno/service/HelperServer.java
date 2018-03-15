package com.hgicreate.rno.service;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by hadoop on 2017/1/18.
 */
@Service
public class HelperServer {
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private java.sql.Timestamp timestamp = new java.sql.Timestamp(0);

    public String getDate(long timestamp) {
        this.timestamp.setTime(timestamp);
        return this.dateFormat.format(this.timestamp);
    }
}
