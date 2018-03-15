import { Object } from '../common/Object';

export class FinalSearchValue {
  constructor(public city: string,
              public trainName: string,
              public trainStatus: string,
              public dateFrom: Object,
              public dateTo: Object,
              public rowsOnPage: number,
              public activePage: number,
              public operateType: string,
              ) {
  }
}
