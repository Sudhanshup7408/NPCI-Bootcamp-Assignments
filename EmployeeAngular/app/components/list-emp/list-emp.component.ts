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
  formModel: Employee = new Employee(0,"","","",0,0,0,0)
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
  onSubmit():void{
    this.employees.push(this.formModel)
  }

}
