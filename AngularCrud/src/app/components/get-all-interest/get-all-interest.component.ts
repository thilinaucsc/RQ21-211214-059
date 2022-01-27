import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import { AllInterest } from "../../model/allInterest";
import { TutorialService } from "../../services/tutorial.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-get-all-interest',
  templateUrl: './get-all-interest.component.html',
  styleUrls: ['./get-all-interest.component.css']
})
export class GetAllInterestComponent implements OnInit {
  allInterest: Observable<AllInterest[]> | undefined;

  constructor(private tutorialService: TutorialService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.allInterest = this.tutorialService.getAllInterest();
  }

}
