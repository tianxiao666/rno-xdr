import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { StateStorageService } from '../../pages/auth/state-storage.service';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(
    private router: Router,
    private stateStorageService: StateStorageService,
    ) { }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    // authenticationToken
    if (localStorage.getItem('authenticationToken') || sessionStorage.getItem('authenticationToken')) {
      // logged in so return true
      return true;
    }

    // not logged in so redirect to login page with the return url
    this.stateStorageService.storeUrl(state.url);
    this.router.navigate(['/login']).catch(error => console.error(error));
    return false;
  }
}
