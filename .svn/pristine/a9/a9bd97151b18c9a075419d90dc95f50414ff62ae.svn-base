import { Component, OnInit } from '@angular/core';

import { JhiEventManager } from 'ng-jhipster';

import { GlobalState } from '../../../global.state';
import { LoginService } from '../../../pages/login';
import { Principal } from '../../../pages/auth';

@Component({
  selector: 'ba-page-top',
  templateUrl: './ba-page-top.component.html',
  styleUrls: ['./ba-page-top.component.scss'],
})
export class BaPageTopComponent implements OnInit {

  public isScrolled: boolean = false;
  public isMenuCollapsed: boolean = false;
  account: Account;

  constructor(
    private _state: GlobalState,
    private loginService: LoginService,
    private principal: Principal,
    private eventManager: JhiEventManager,
    ) {}

  ngOnInit(): void {
    this._state.subscribe('menu.isCollapsed', (isCollapsed) => {
      this.isMenuCollapsed = isCollapsed;
    });
    this.principal.identity().then((account) => {
      this.account = account;
    });
    this.registerAuthenticationSuccess();
  }

  registerAuthenticationSuccess() {
    this.eventManager.subscribe('authenticationSuccess', (message) => {
      this.principal.identity().then((account) => {
        this.account = account;
      });
    });
  }

  public toggleMenu() {
    this.isMenuCollapsed = !this.isMenuCollapsed;
    this._state.notifyDataChanged('menu.isCollapsed', this.isMenuCollapsed);
    return false;
  }

  public scrolledChanged(isScrolled) {
    this.isScrolled = isScrolled;
  }

  private logout() {
    this.loginService.logout();
  }
}
