import { BaseEntity } from './../../shared';

export class Mr implements BaseEntity {
    constructor(
        public id?: number,
        public pdate?: any,
        public phour?: number,
        public cell?: string,
        public imei?: string,
        public imsi?: string,
        public rsrpSum?: number,
        public rsrpCount?: number,
        public rsrpAvg?: number,
        public rsrqSum?: number,
        public rsrqCount?: number,
        public rsrqAvg?: number,
        public ulsinrSum?: number,
        public ulsinrCount?: number,
        public ulsinrAvg?: number,
        public phrSum?: number,
        public phrCount?: number,
        public phrAvg?: number,
        public erpSum?: number,
        public erpCount?: number,
        public erpAvg?: number,
        public taSum?: number,
        public taCount?: number,
        public taAvg?: number,
        public overlapSum?: number,
        public overlapCount?: number,
        public overlapAvg?: number,
    ) {
    }
}
