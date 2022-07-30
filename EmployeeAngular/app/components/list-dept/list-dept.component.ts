import { Component, OnInit } from '@angular/core';
import { EmpmgmtserviceService } from 'src/app/services/empmgmtservice.service';
import { Department } from 'src/app/common/department';

@Component({
  selector: 'app-list-dept',
  templateUrl: './list-dept.component.html',
  styleUrls: ['./list-dept.component.css']
})
export class ListDeptComponent implements OnInit {

  constructor(private service :EmpmgmtserviceService) { }
  departments : Department[];
  ngOnInit(): void {
    this.listofDepartment()
  }
  
  listofDepartment(){
    this.service.getAllDepartment().subscribe(data=>{
      console.log(data)
      this.departments = data;
    })
  }

}
