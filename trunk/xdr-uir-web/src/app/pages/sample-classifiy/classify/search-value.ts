import { Object } from '../../common/Object';
export class SearchValue {
  constructor(public city: string,
              public classifyName: string,
              public classifyStatus: string,
              public dateFrom: Object,
              public dateTo: Object ) {
  }
}
