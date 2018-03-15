package com.hgicreate.rno.xdr.backend.web.rest.cond;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Condition object for search Exception stats.
 */
public class ExceptionStatsCond {

    private Long date;
    private Long eci;
    private String expressionConnector1;
    private String expressionCondition1;
    private String expressionOperator1;
    private Double expressionValue1;
    private String expressionConnector2;
    private String expressionCondition2;
    private String expressionOperator2;
    private Double expressionValue2;
    private String expressionConnector3;
    private String expressionCondition3;
    private String expressionOperator3;
    private Double expressionValue3;

    public ExceptionStatsCond() {
        // Empty public constructor used by Jackson.
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getEci() {
        return eci;
    }

    public void setEci(Long eci) {
        this.eci = eci;
    }

    public String getExpressionConnector1() {
        return expressionConnector1;
    }

    public void setExpressionConnector1(String expressionConnector1) {
        this.expressionConnector1 = expressionConnector1;
    }

    public String getExpressionCondition1() {
        return expressionCondition1;
    }

    public void setExpressionCondition1(String expressionCondition1) {
        this.expressionCondition1 = expressionCondition1;
    }

    public String getExpressionOperator1() {
        return expressionOperator1;
    }

    public void setExpressionOperator1(String expressionOperator1) {
        this.expressionOperator1 = expressionOperator1;
    }

    public Double getExpressionValue1() {
        return expressionValue1;
    }

    public void setExpressionValue1(Double expressionValue1) {
        this.expressionValue1 = expressionValue1;
    }

    public String getExpressionConnector2() {
        return expressionConnector2;
    }

    public void setExpressionConnector2(String expressionConnector2) {
        this.expressionConnector2 = expressionConnector2;
    }

    public String getExpressionCondition2() {
        return expressionCondition2;
    }

    public void setExpressionCondition2(String expressionCondition2) {
        this.expressionCondition2 = expressionCondition2;
    }

    public String getExpressionOperator2() {
        return expressionOperator2;
    }

    public void setExpressionOperator2(String expressionOperator2) {
        this.expressionOperator2 = expressionOperator2;
    }

    public Double getExpressionValue2() {
        return expressionValue2;
    }

    public void setExpressionValue2(Double expressionValue2) {
        this.expressionValue2 = expressionValue2;
    }

    public String getExpressionConnector3() {
        return expressionConnector3;
    }

    public void setExpressionConnector3(String expressionConnector3) {
        this.expressionConnector3 = expressionConnector3;
    }

    public String getExpressionCondition3() {
        return expressionCondition3;
    }

    public void setExpressionCondition3(String expressionCondition3) {
        this.expressionCondition3 = expressionCondition3;
    }

    public String getExpressionOperator3() {
        return expressionOperator3;
    }

    public void setExpressionOperator3(String expressionOperator3) {
        this.expressionOperator3 = expressionOperator3;
    }

    public Double getExpressionValue3() {
        return expressionValue3;
    }

    public void setExpressionValue3(Double expressionValue3) {
        this.expressionValue3 = expressionValue3;
    }

    @Override
    public String toString() {
        return "ExceptionStatsCond{" +
            "date=" + date +
            ", eci=" + eci +
            ", expressionConnector1='" + expressionConnector1 + '\'' +
            ", expressionCondition1='" + expressionCondition1 + '\'' +
            ", expressionOperator1='" + expressionOperator1 + '\'' +
            ", expressionValue1=" + expressionValue1 +
            ", expressionConnector2='" + expressionConnector2 + '\'' +
            ", expressionCondition2='" + expressionCondition2 + '\'' +
            ", expressionOperator2='" + expressionOperator2 + '\'' +
            ", expressionValue2=" + expressionValue2 +
            ", expressionConnector3='" + expressionConnector3 + '\'' +
            ", expressionCondition3='" + expressionCondition3 + '\'' +
            ", expressionOperator3='" + expressionOperator3 + '\'' +
            ", expressionValue3=" + expressionValue3 +
            '}';
    }

    public String buildSql() {
        Date date = new Date(this.date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String where = "where pdate ='" + sdf.format(date) + "'";
        if (eci != null) {
            where += " and cell = " + eci;
        }
        where += " " + expressionConnector1 + " " + expressionCondition1 + " " + expressionOperator1 + " " + expressionValue1 + " " + expressionConnector2 + " " + expressionCondition2 + " " + expressionOperator2 + " " + expressionValue2 + " " + expressionConnector3 + " " + expressionCondition3 + " " + expressionOperator3 + " " + expressionValue3;
        String sql = "select pdate, cell, imei, imsi, attach_fault_rate, attach_request, attach_fault, service_fault_rate, service_request, service_fault, csfb_fault_rate, csfb_request, csfb_fault, context_activate_fault_rate, context_activate_request, context_activate_fault, pdn_request_fault_rate, pdn_request, pdn_request_fault, tau_fault_rate, tau_request, tau_fault, xho_fault_rate, xho_request, xho_fault, sho_fault_rate, sho_request, sho_fault from exception_stats " + where;
        return sql;
    }
    public String buildSqlMobile() {
        Date date = new Date(this.date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String where = "where pdate ='" + sdf.format(date) + "'";
        if (eci != null) {
            where += " and cell = " + eci;
        }
        where += " " + expressionConnector1 + " " + expressionCondition1 + " " + expressionOperator1 + " " + expressionValue1 + " " + expressionConnector2 + " " + expressionCondition2 + " " + expressionOperator2 + " " + expressionValue2 + " " + expressionConnector3 + " " + expressionCondition3 + " " + expressionOperator3 + " " + expressionValue3;
        String sql = "select id, pdate, cell, imei, imsi, attach_fault_rate, attach_request, attach_fault, service_fault_rate, service_request, service_fault, csfb_fault_rate, csfb_request, csfb_fault, context_activate_fault_rate, context_activate_request, context_activate_fault, pdn_request_fault_rate, pdn_request, pdn_request_fault, tau_fault_rate, tau_request, tau_fault, xho_fault_rate, xho_request, xho_fault, sho_fault_rate, sho_request, sho_fault from exception_stats " + where;
        return sql;
    }
}
