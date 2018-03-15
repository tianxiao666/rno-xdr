import { Object } from '../common/Object';

export class FinalSearchValue {
  constructor(public date1: Object,
              public date2: Object,
              public area: string,
              public interfereType: string,
              public rowsOnPage: number,
              public activePage: number,
              ) {
  }
}
