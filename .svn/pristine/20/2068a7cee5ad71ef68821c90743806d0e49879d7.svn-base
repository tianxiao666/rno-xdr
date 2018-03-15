package com.hgicreate.rno.service.indicator;

import com.hgicreate.rno.repository.indicator.mr.*;
import com.hgicreate.rno.repository.io.IndicatorNamesReader;
import com.hgicreate.rno.service.HelperServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hadoop on 16-12-23.
 */
@Component
public class MrIndicatorService extends
        IndicatorServiceAbstract<
            MrCellDateRepository,
            MrCellHourRepository,
            MrNetDateRepository,
            MrNetHourRepository,
            MrUserDateRepository,
            MrUserHourRepository
                > {

    @Autowired
    public MrIndicatorService(HelperServer helperServer,
                              IndicatorNamesReader indicatorNamesReader,
                              MrCellDateRepository cellDateRepository,
                              MrCellHourRepository cellHourRepository,
                              MrNetDateRepository netDateRepository,
                              MrNetHourRepository netHourRepository,
                              MrUserDateRepository userDateRepository,
                              MrUserHourRepository userHourRepository
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
        return "mr";
    }
}
