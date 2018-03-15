package com.hgicreate.rno.service.indicator;

import com.hgicreate.rno.repository.indicator.brd39.*;
import com.hgicreate.rno.repository.io.IndicatorNamesReader;
import com.hgicreate.rno.service.HelperServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hadoop on 16-12-23.
 */
@Component
public class Brd39IndicatorService extends
        IndicatorServiceAbstract<
            Brd39CellDateRepository,
            Brd39CellHourRepository,
            Brd39NetDateRepository,
            Brd39NetHourRepository,
            Brd39UserDateRepository,
            Brd39UserHourRepository
                > {

    @Autowired
    public Brd39IndicatorService(HelperServer helperServer,
                                 IndicatorNamesReader indicatorNamesReader,
                                 Brd39CellDateRepository cellDateRepository,
                                 Brd39CellHourRepository cellHourRepository,
                                 Brd39NetDateRepository netDateRepository,
                                 Brd39NetHourRepository netHourRepository,
                                 Brd39UserDateRepository userDateRepository,
                                 Brd39UserHourRepository userHourRepository
    ) {
        super(helperServer, indicatorNamesReader,
                cellDateRepository,
                cellHourRepository,
                netDateRepository,
                netHourRepository,
                userDateRepository,
                userHourRepository
                );
    }

    @Override
    protected String getInterfaceName() {
        return "brd39";
    }
}
