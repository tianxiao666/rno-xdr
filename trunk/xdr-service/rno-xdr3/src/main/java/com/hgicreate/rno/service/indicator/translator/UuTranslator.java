package com.hgicreate.rno.service.indicator.translator;

import com.hgicreate.rno.domain.indicator.IndicatorName;
import com.hgicreate.rno.domain.indicator.InterfaceName;
import com.hgicreate.rno.domain.indicator.uu.UuBase;
import com.hgicreate.rno.domain.indicator.uu.UuCellDate;
import com.hgicreate.rno.repository.io.ClassReader;
import com.hgicreate.rno.repository.io.IndicatorNamesReader;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by hadoop on 2016/12/29.
 */
@Component
public class UuTranslator {
    private IndicatorNamesReader indicatorNamesReader;
    private Map<String, String> translatorMap;
    private ClassReader classReader = new ClassReader();

    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private Timestamp timestamp = new Timestamp(0);

    @Autowired
    public UuTranslator(IndicatorNamesReader indicatorNamesReader) {
        this.indicatorNamesReader = indicatorNamesReader;
        initMap();
    }

    public List<Map<String, Object>> translate(List<UuCellDate> data) {
        List<Map<String, Object>> answer = new LinkedList<>();
        data.forEach(d -> answer.add(this.translate(d)));
        return answer;
    }

    public Map<String, Object> translate(UuCellDate data) {

        LinkedHashMap<String, Object> jsonObject = new LinkedHashMap<>();
        jsonObject.put("日期", this.getDate(data.getDate()));
        jsonObject.put("CellID", data.getCellid());
        jsonObject.putAll(this.classReader.getFatherClassInfo(data));
        jsonObject.remove("id");
        return translateMap(jsonObject);
    }

    public JSONObject translate(UuBase uuBase) {
        return new JSONObject(this.classReader.getClassInfo(uuBase));
    }

    private void initMap() {
        this.translatorMap = new HashMap();
        InterfaceName interfaceName = this.indicatorNamesReader.getInterfaceName("uu");
        for (IndicatorName name : interfaceName.getIndicators()) {
            this.translatorMap.put(name.getEn(), name.getCh());
        }
    }

    private Map<String, Object> translateMap(Map<String, Object> map) {
        Map<String, Object> result = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            result.put(this.translateKey(entry.getKey()), entry.getValue());
        }
        return result;
    }

    private String translateKey(String en) {
        String result = this.translatorMap.get(en);
        if (result == null)
            return en;
        else
            return result;
    }

    private String getDate(long timestamp) {
        this.timestamp.setTime(timestamp);
        return this.dateFormat.format(this.timestamp);
    }
}
