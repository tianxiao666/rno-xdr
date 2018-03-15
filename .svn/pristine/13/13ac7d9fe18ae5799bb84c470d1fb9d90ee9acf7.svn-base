package com.hgicreate.rno.service.indicator;

import com.hgicreate.rno.repository.indicator.x2.*;
import com.hgicreate.rno.repository.io.IndicatorNamesReader;
import com.hgicreate.rno.service.HelperServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hadoop on 16-12-23.
 */
@Component
public class X2IndicatorService
        extends IndicatorServiceAbstract<
    X2CellDateRepository,
    X2CellHourRepository,
    X2NetDateRepository,
    X2NetHourRepository,
    X2UserDateRepository,
    X2UserHourRepository
        > {

    @Autowired
    public X2IndicatorService(HelperServer helperServer,
                              IndicatorNamesReader indicatorNamesReader,
                              X2CellDateRepository cellDateRepository,
                              X2CellHourRepository cellHourRepository,
                              X2NetDateRepository netDateRepository,
                              X2NetHourRepository netHourRepository,
                              X2UserDateRepository userDateRepository,
                              X2UserHourRepository userHourRepository
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
        return "x2";
    }
}
