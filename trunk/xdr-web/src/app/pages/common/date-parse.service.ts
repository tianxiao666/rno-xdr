import { Injectable } from '@angular/core';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { Object } from './Object';

const oneDay = 24 * 3600 * 1000;

@Injectable()
export class DateParseService {

  public static getDate(time: NgbDateStruct): Date {
    return new Date(time.year, time.month - 1, time.day);
  }

  public static getDate1(time: Object): Date {
    return new Date(time.date.year, time.date.month - 1, time.date.day);
  }

  public static getTimestamp(date: Date): number {
    return date.setHours(8, 0, 0, 0);
  }

  public static getTimestamp1(date: Date): number {
    return date.setHours(0, 0, 0, 0);
  }

  public static getTimestamp2(date: Date): number {
    return date.setHours(date.getHours() + 8, 0, 0, 0);
  }

  public static getDays1(startTime: Object, endTime: Object): number {
    const bt = DateParseService.getTimestamp(DateParseService.getDate1(startTime));
    const et = DateParseService.getTimestamp(DateParseService.getDate1(endTime));
    return (et - bt) / oneDay;
  }

  constructor() { }

}
