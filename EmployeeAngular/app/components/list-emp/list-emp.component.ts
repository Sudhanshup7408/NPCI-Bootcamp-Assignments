import { Component, OnInit } from '@angular/core';
import { EmpmgmtserviceService } from 'src/app/services/empmgmtservice.service';
import { Employee } from 'src/app/common/employee';

@Component({
  selector: 'app-list-emp',
  templateUrl: './list-emp.component.html',
  styleUrls: ['./list-emp.component.css']
})
export class ListEmpComponent implements OnInit {

  constructor(private service :EmpmgmtserviceService) { }
  employees : Employee[];
  ngOnInit(): void {
    this.listofEmployees()
  }
  
  listofEmployees(){
    this.service.getAllEmployee().subscribe(data=>{
      console.log(data)
      this.employees = data;
    })
  }

}
