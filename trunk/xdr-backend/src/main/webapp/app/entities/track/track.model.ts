import { BaseEntity } from './../../shared';

export class Track implements BaseEntity {
    constructor(
        public id?: number,
        public pdate?: any,
        public startTime?: number,
        public endTime?: number,
        public cell?: number,
        public imei?: number,
        public imsi?: number,
        public msisdn?: number,
        public lon?: number,
        public lat?: number,
        public indicatorType?: string,
        public status?: number,
    ) {
    }
}
