package com.hgicreate.rno.service.indicator;

import com.hgicreate.rno.repository.indicator.brd31.*;
import com.hgicreate.rno.repository.io.IndicatorNamesReader;
import com.hgicreate.rno.service.HelperServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hadoop on 16-12-23.
 */
@Component
public class Brd31IndicatorService extends
    IndicatorServiceAbstract<
            Brd31CellDateRepository,
            Brd31CellHourRepository,
            Brd31NetDateRepository,
            Brd31NetHourRepository,
            Brd31UserDateRepository,
            Brd31UserHourRepository
                > {

    @Autowired
    public Brd31IndicatorService(HelperServer helperServer,
                                 IndicatorNamesReader indicatorNamesReader,
                                 Brd31CellDateRepository cellDateRepository,
                                 Brd31CellHourRepository cellHourRepository,
                                 Brd31NetDateRepository netDateRepository,
                                 Brd31NetHourRepository netHourRepository,
                                 Brd31UserDateRepository userDateRepository,
                                 Brd31UserHourRepository userHourRepository
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
        return "brd31";
    }
}
