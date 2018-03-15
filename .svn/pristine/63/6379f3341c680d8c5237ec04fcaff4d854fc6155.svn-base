package com.hgicreate.rno.service.indicator;

import com.hgicreate.rno.domain.indicator.InterfaceName;
import com.hgicreate.rno.repository.*;
import com.hgicreate.rno.repository.io.CsvResponseWriter;
import com.hgicreate.rno.repository.io.IndicatorNamesReader;
import com.hgicreate.rno.repository.io.MappedColumnCsv;
import com.hgicreate.rno.service.HelperServer;
import com.hgicreate.rno.service.indicator.indicatornames.TableHeaders;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by hadoop on 2017/1/17.
 */
public abstract class IndicatorServiceAbstract<
        CellDate extends ICellDateRepository,
        CellHour extends ICellHourRepository,
        NetDate extends INetDateRepository,
        NetHour extends INetHourRepository,
        UserDate extends IUserDateRepository,
        UserHour extends IUserHourRepository
        > {
    private HelperServer helperServer;
    private IndicatorNamesReader indicatorNamesReader;
    private TableHeaders tableHeaders;

    private CellDate cellDate;
    private CellHour cellHour;
    private NetDate netDate;
    private NetHour netHour;
    private UserDate userDate;
    private UserHour userHour;


    protected abstract String getInterfaceName();

    public IndicatorServiceAbstract(HelperServer helperServer,
                                    IndicatorNamesReader indicatorNamesReader,
                                    CellDate cellDate,
                                    CellHour cellHour,
                                    NetDate netDate,
                                    NetHour netHour,
                                    UserDate userDate,
                                    UserHour userHour
    ) {
        this.helperServer = helperServer;
        this.indicatorNamesReader = indicatorNamesReader;
        this.cellDate = cellDate;
        this.cellHour = cellHour;
        this.netDate = netDate;
        this.netHour = netHour;
        this.userDate=userDate;
        this.userHour=userHour;
        InterfaceName interfaceName=this.indicatorNamesReader.getInterfaceName(getInterfaceName());
        if (interfaceName==null)
            throw new NullPointerException("interfaceName is null");
        this.tableHeaders = new TableHeaders(interfaceName.getIndicators());
    }

    public List<?> getCellHours(long cellid, long date) {
        return this.cellHour.findByDateAndCellid(date, cellid);
    }

    public List<?> getCellDates(long date) {
        return this.cellDate.findByDate(date);
    }

    public List<?> getCellDates(long date, long cellid) {
        return this.cellDate.findByDateAndCellid(date, cellid);
    }

    public List<?> getCellDates(long beginDate, long endDate, long cellid) {
        return this.cellDate.findByDateBetweenAndCellid(beginDate, endDate, cellid);
    }

    public List<?> getNetHours(long date) {
        return this.netHour.findByDate(date);
    }

    public List<?> getNetDates(long date) {
        return this.netDate.findByDate(date);
    }

    public List<?> getNetDates(long beginDate, long endDate) {
        return this.netDate.findByDateBetween(beginDate, endDate);
    }

    public List<?> getUserHours(long imsi, long date) {
        return this.userHour.findByDateAndImsi(date, imsi);
    }

    public List<?> getUserDates(long date) {
        return this.cellDate.findByDate(date);
    }

    public List<?> getUserDates(long date, long imsi) {
        return this.userDate.findByDateAndImsi(date, imsi);
    }

    public List<?> getUserDates(long beginDate, long endDate, long imsi) {
        return this.userDate.findByDateBetweenAndImsi(beginDate, endDate, imsi);
    }

    public TableHeaders getTableHeaders() {
        return this.tableHeaders;
    }

    public void downloadCsvFile(HttpServletResponse response, List<?> data, String fileName) throws IOException {
        MappedColumnCsv csvWriter = new MappedColumnCsv(
                new CsvResponseWriter(response, fileName));

        csvWriter.write(this.getTableHeaders().getDateCell(),
                data,
                (key, value) -> {
                    if (key == "date" && value != null) {
                        return this.helperServer.getDate((Long) value);
                    } else return value;
                });
    }

}
