import { Injectable } from '@angular/core';
import { GetJsonHttpService } from '../common/getJsonHttp.service';
import { Condition, UuLonLat } from './track-present';
import { DateParseService } from '../common/date-parse.service';

@Injectable()
export class TrackPresentService {

  constructor(private _getJsonService: GetJsonHttpService) { }

  public getData(c: Condition): Promise<Map<number, UuLonLat[]>> {
    const beginTime = DateParseService.getTimestamp2(
      new Date(c.date.date.year, c.date.date.month, c.date.date.day, c.beginTime));
    const endTime = DateParseService.getTimestamp2(
      new Date(c.date.date.year, c.date.date.month, c.date.date.day, c.endTime));
    const uri = `/api/tracks/findByTimeAndImsiAndIndicatorType?beginTime=${beginTime}
    &endTime=${endTime}&imsi=${c.imsi}&indicatorType=${c.indicatorId}`;
    return this._getJsonService.getJsonPromise(uri).then(data => {
      return this.combind(data);
    });
  }

  private combind(data: UuLonLat[]): Map<number, UuLonLat[]> {
    // console.log(data);
    const result = new Map<number, UuLonLat[]>();
    data.map(v => {
      if (result.get(v.cell)) {
        result.get(v.cell).push(v);
      } else {
        result.set(v.cell, [v]);
      }
    });
    return result;
  }
}
