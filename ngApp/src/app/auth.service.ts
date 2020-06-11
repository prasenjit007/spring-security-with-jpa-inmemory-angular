import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _registerUrl = "http://localhost:8080/register";
  private _loginUrl = "http://localhost:8080/login";

  constructor(private httpClient: HttpClient) {
    
  }

  /*public generateTokenRequest(request){
    return this.httpClient.post('http://localhost:8080/register', request, {responseType: 'text' as 'json'})
  }*/

  registerUser(user){
    return this.httpClient.post<any>(this._registerUrl, user)
  }
  login(user){
    return this.httpClient.post<any>(this._loginUrl, user)
  }

  loggedIn(){
    return !!localStorage.getItem('token');
  }

  getToken(){
    return localStorage.getItem('token');
  }
}
