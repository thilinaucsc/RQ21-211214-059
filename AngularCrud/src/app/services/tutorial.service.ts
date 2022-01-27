import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const baseUrl = 'http://localhost:8080/api/';

@Injectable({
  providedIn: 'root'
})
export class TutorialService {
  constructor(private http: HttpClient) { }

  getAllInterest(): Observable<any> {
    return this.http.get(baseUrl + 'getAllInterest');
  }

  getCustomerInterest(data: any): Observable<any> {
    return this.http.post(baseUrl + 'getCustomerInterest', data);
  }

  getLast10Interest(data: any): Observable<any> {
    return this.http.post(baseUrl + 'getLast10Interest', data);
  }


}
