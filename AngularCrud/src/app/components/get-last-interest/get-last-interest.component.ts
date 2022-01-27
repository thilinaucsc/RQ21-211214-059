import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {CommonRequest} from "../../model/commonRequest";
import {InterestData} from "../../model/interestData";
import {ActivatedRoute, Router} from "@angular/router";
import {TutorialService} from "../../services/tutorial.service";

@Component({
  selector: 'app-get-last-interest',
  templateUrl: './get-last-interest.component.html',
  styleUrls: ['./get-last-interest.component.css']
})
export class GetLastInterestComponent implements OnInit {
  allInterestData: Observable<InterestData[]> | undefined;
  commonRequest: CommonRequest = new CommonRequest;

  constructor(private route: ActivatedRoute,private router: Router, private tutorialService: TutorialService) { }

  ngOnInit(): void {
  }

  getData() {
    this.tutorialService.getLast10Interest(this.commonRequest)
      .subscribe(data => {
        console.log(data);
        this.allInterestData = data;
      }, error => console.log(error));
  }

  onSubmit() {
    this.getData();
  }
}
