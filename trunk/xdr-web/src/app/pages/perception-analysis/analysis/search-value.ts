import { IMultiSelectOption } from 'angular-2-dropdown-multiselect';
import { Object } from '../../common/Object';

export class SearchValue {
  constructor(public date1: Object,
              public cellType: string,
              public cellInput: string,
              public interfaceType: string,
              public indicatorSelectItems: IMultiSelectOption[],
              public indicatorSelectItemIds: string[]) {
  }
}
