import { Component, OnInit } from '@angular/core';
import { AuthService } from './../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerUserData = {
    email:'',
    password: ''
  };
  constructor(private auth: AuthService,
    private router: Router) { }

  ngOnInit(): void {
  }

  registerUser(){
    console.log(this.registerUserData);
    this.auth.registerUser(this.registerUserData)
      .subscribe(
        res =>  {
          console.log(res);
          //alert('Registration Successful for User : '+res.email)
          localStorage.setItem("token", res.token);
          this.router.navigate(['/special']);
        },
        error => {
          console.log("#################ERROR IN REGISTRING USER#################")
          console.log(error)
        }
      )
  }

}
