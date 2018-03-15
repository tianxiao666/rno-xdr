import { BaseEntity } from './../../shared';

export class Record implements BaseEntity {
    constructor(
        public id?: number,
        public area?: string,
        public date?: any,
        public userId?: number,
        public title?: string,
        public type?: string,
        public size?: string,
        public records?: number,
        public ids?: BaseEntity[],
    ) {
    }
}
