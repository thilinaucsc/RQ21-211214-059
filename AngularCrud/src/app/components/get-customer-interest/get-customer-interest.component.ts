import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CommonRequest} from "../../model/commonRequest";
import {TutorialService} from "../../services/tutorial.service";
import {Observable} from "rxjs";
import {AllInterest} from "../../model/allInterest";

@Component({
  selector: 'app-get-customer-interest',
  templateUrl: './get-customer-interest.component.html',
  styleUrls: ['./get-customer-interest.component.css']
})
export class GetCustomerInterestComponent implements OnInit {
  allInterest: Observable<AllInterest[]> | undefined;
  commonRequest: CommonRequest = new CommonRequest;

  constructor(private route: ActivatedRoute,private router: Router, private tutorialService: TutorialService) { }

  ngOnInit(): void {
  }

  getData() {
    this.tutorialService.getCustomerInterest(this.commonRequest)
      .subscribe(data => {
        console.log(data);
        this.allInterest = data;
      }, error => console.log(error));
  }

  onSubmit() {
    this.getData();
  }

}
