import { Component } from '@angular/core';
import { FormGroup, AbstractControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JhiEventManager } from 'ng-jhipster';

import { StateStorageService } from '../auth';
import { LoginService } from './';

@Component({
  selector: 'xdr-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {

  public submitted: boolean = false;

  private authenticationError: boolean = false;
  private form: FormGroup;
  private username: AbstractControl;
  private password: AbstractControl;
  private rememberMe: AbstractControl;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private loginService: LoginService,
    private stateStorageService: StateStorageService,
    private eventManager: JhiEventManager,
  ) {
    this.form = fb.group({
      'username': ['', Validators.compose([Validators.required, Validators.minLength(4), Validators.maxLength(50)])],
      'password': ['', Validators.compose([Validators.required, Validators.minLength(4), Validators.maxLength(100)])],
      'rememberMe': [false],
    });

    this.username = this.form.controls['username'];
    this.password = this.form.controls['password'];
    this.rememberMe = this.form.controls['rememberMe'];
  }

  public onSubmit(values: Object, valid: boolean): void {
    this.submitted = true;
    if (valid) {
      this.login(values);
    }
  }

  login(credentials: Object) {
    this.loginService.login(credentials).then(() => {
      this.authenticationError = false;
      if (this.router.url === '/register' || (/activate/.test(this.router.url)) ||
        this.router.url === '/finishReset' || this.router.url === '/requestReset') {
        this.router.navigate(['']);
      }

      this.eventManager.broadcast({
        name: 'authenticationSuccess',
        content: 'Sending Authentication Success',
      });

      // // previousState was set in the authExpiredInterceptor before being redirected to login modal.
      // // since login is succesful, go to stored previousState and clear previousState
      const redirect = this.stateStorageService.getUrl();
      if (redirect) {
        this.router.navigate([redirect]);
      }
    }).catch(() => {
      this.authenticationError = true;
      this.submitted = false;
    });
  }

  register() {
    this.router.navigate(['/register']);
  }

  requestResetPassword() {
    this.router.navigate(['/reset', 'request']);
  }
}
