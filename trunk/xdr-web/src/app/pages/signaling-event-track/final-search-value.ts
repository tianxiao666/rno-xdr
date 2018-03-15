import { Object } from '../common/Object';

export class FinalSearchValue {
  constructor(public date1: Object,
              public startTime: string,
              public endTime: string,
              public imsi: string,
              public interfaceType: string,
              public rowsOnPage: number,
              public activePage: number,
              public operateType: string,
              ) {
  }
}
