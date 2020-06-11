import { Component, OnInit } from '@angular/core';
import { AuthService } from './../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loggedUserData = {
    email:'',
    password: ''
  };
  constructor(private auth: AuthService,
    private router: Router) { }

  ngOnInit(): void {
  }

  
  login(){
    debugger
    console.log(this.loggedUserData);
    this.auth.login(this.loggedUserData)
      .subscribe(
        res =>  {
          debugger
          console.log("#################LOGGING RESPONSE#################")
          console.log(res);
          //alert('Login Successful for User : '+res.email)
          localStorage.setItem("token", res.token);
          this.router.navigate(['/special']);
        },
        error => {
          console.log("#################ERROR IN LOGIN USER#################")
          console.log(error)
        }
      )
  }

  cancel(){
    this.loggedUserData =   {
      email:'',
      password: ''
    };
  }

}
