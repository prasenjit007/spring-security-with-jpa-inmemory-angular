import { Injectable, Injector } from '@angular/core';
import { HttpInterceptor} from '@angular/common/http';
import { AuthService } from './auth.service';


@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor{

  constructor(private injector: Injector) { }

  intercept(req, next){
    debugger
    let auth = this.injector.get(AuthService);
    console.log(`intercept: Bearer ${auth.getToken()}`)
    let tokenizedRequest = req.clone({
      setHeaders : {
        Authorization: `Bearer ${auth.getToken()}`
      }
    });

    return next.handle(tokenizedRequest);
  }
}
