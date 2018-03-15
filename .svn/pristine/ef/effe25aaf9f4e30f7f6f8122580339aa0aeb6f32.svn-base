package com.hgicreate.rno.service.indicator;

import com.hgicreate.rno.repository.indicator.uu.*;
import com.hgicreate.rno.repository.io.IndicatorNamesReader;
import com.hgicreate.rno.service.HelperServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hadoop on 16-12-23.
 */
@Component
public class UuIndicatorService extends
        IndicatorServiceAbstract<
            UuCellDateRepository,
            UuCellHourRepository,
            UuNetDateRepository,
            UuNetHourRepository,
            UuUserDateRepository,
            UuUserHourRepository
                > {

    @Autowired
    public UuIndicatorService(HelperServer helperServer,
                              IndicatorNamesReader indicatorNamesReader,
                              UuCellDateRepository uuCellDateRepository,
                              UuCellHourRepository uuCellHourRepository,
                              UuNetDateRepository uuNetDateRepository,
                              UuNetHourRepository uuNetHourRepository,
                              UuUserDateRepository uuUserDateRepository,
                              UuUserHourRepository uuUserHourRepository
    ) {
        super(helperServer, indicatorNamesReader,
                uuCellDateRepository,
                uuCellHourRepository,
                uuNetDateRepository,
                uuNetHourRepository,
                uuUserDateRepository,
                uuUserHourRepository
        );
    }

    @Override
    protected String getInterfaceName() {
        return "uu";
    }
}
