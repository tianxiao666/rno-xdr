import { Injectable } from '@angular/core';
import { JhiLanguageService } from 'ng-jhipster';

import { AuthenticationService, Principal } from '../auth';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class LoginService {

    constructor(
        private languageService: JhiLanguageService,
        private principal: Principal,
        private authenticationService: AuthenticationService,
    ) {}

    login(credentials, callback?): Promise<any> {
        const cb = callback || function() {};

        return new Promise((resolve, reject) => {
            this.authenticationService.login(credentials).subscribe((data) => {
                this.principal.identity(true).then((account) => {
                    // After the login the language will be changed to
                    // the language selected by the user during his registration
                    if (account !== null) {
                        this.languageService.changeLanguage(account.langKey);
                    }
                    resolve(data);
                });
                return cb();
            }, (err) => {
                this.logout();
                reject(err);
                return cb(err);
            });
        });
    }

    loginWithToken(jwt, rememberMe) {
        return this.authenticationService.loginWithToken(jwt, rememberMe);
    }

    logout() {
        this.authenticationService.logout().subscribe();
        this.principal.authenticate(null);
    }
}
