import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AccountService, AuthenticationService, Principal, StateStorageService } from './';

@NgModule({
  imports: [
    CommonModule,
  ],
  providers: [
    AccountService,
    AuthenticationService,
    Principal,
    StateStorageService,
  ],
})
export class AuthModule { }
