import { Component, OnInit } from '@angular/core';
import {CommonRequest} from "../../model/commonRequest";
import {AuthenticationService} from "../../services/authentication.service";
import {Observable} from "rxjs";
import {LoginUser} from "../../model/loginUser";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  commonRequest: CommonRequest = new CommonRequest;
  loginuser!: Observable<LoginUser>;

  constructor(private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
  }

  login() {
    this.authenticationService.login(this.commonRequest)
      .subscribe(data => {
        console.log(data);
        this.loginuser = data;
      }, error => console.log(error));
  }

  onSubmit() {
    this.login();
  }

}
