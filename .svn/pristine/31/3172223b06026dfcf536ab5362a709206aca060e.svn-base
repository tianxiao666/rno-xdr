package com.hgicreate.rno.service.exception;

import com.hgicreate.rno.domain.exception.brd39.Brd39CellDate;
import com.hgicreate.rno.repository.exception.brd39.ExBrd39CellDateRepository;
import com.hgicreate.rno.repository.io.CsvResponseWriter;
import com.hgicreate.rno.repository.io.ExceptionColumnsReader;
import com.hgicreate.rno.repository.io.MappedColumnCsv;
import com.hgicreate.rno.service.HelperServer;
import com.hgicreate.rno.service.exception.exceptionnames.TableHeaders;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by hadoop on 2017/1/20.
 */
@Service
public class ExceptionService {
    private HelperServer helperServer;
//    private MongoOperations mongoOperations;
    private ExceptionColumnsReader columnsReader;
    private ExBrd39CellDateRepository cellDateRepository;
    private TableHeaders tableHeaders;

    @Autowired
    public ExceptionService(HelperServer helperServer, ExceptionColumnsReader columnsReader, ExBrd39CellDateRepository cellDateRepository) {
        this.helperServer = helperServer;
        this.columnsReader = columnsReader;
        this.cellDateRepository = cellDateRepository;
        this.tableHeaders = new TableHeaders(this.columnsReader.getXdrTableColumns("brd39").getColumns());
    }

    public TableHeaders getTableHeaders() {
        return this.tableHeaders;
    }

    public List<?> getCellDates(long date) {
        return cellDateRepository.findByDate(date);
    }

//    public List<?> getDetialWithQuery(long date, String query) throws IOException, ParseException {
//        return cellDateRepository.findByDateAndQuery(date, query);
//    }

    public Page<Brd39CellDate> getDetialWithQuery(String query, Pageable pageable) throws IOException, ParseException {
        return cellDateRepository.findDbByQuery(query,pageable);
    }

    public List<?> getCellDates(long date, long cellid) {
        return cellDateRepository.findByDateAndCellid(date, cellid);
    }

    public List<?> getCellDates(long beginDate, long endDate, long cellid) {
        return cellDateRepository.findByDateBetweenAndCellid(beginDate, endDate, cellid);
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
