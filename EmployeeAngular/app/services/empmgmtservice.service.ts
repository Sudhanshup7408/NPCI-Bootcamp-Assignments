import { Injectable } from '@angular/core';
import { Employee } from '../common/employee';
import { HttpClient } from '@angular/common/http';
import {Observable, map} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class EmpmgmtserviceService {
  empurl = "http://localhost:8080/api/emp"
  constructor(private httpClient : HttpClient) { }

  getAllEmployee() : Observable<Employee[]>{
    return this.httpClient.get<getEmployeeResponse>(this.empurl).pipe(map(response => response._embedded.employees))
  }
}

interface getEmployeeResponse{
  _embedded :{
    employees : Employee[]
  }
}
