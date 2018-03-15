import { TestBed, inject } from '@angular/core/testing';

import { UserSettingService } from './user-setting.service';

describe('UserSettingService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserSettingService]
    });
  });

  it('should be created', inject([UserSettingService], (service: UserSettingService) => {
    expect(service).toBeTruthy();
  }));
});
