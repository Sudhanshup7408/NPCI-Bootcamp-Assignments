import { Component, OnInit } from '@angular/core';
import { SalesPerson } from '../salesperson';

@Component({
  selector: 'app-sales-person-list',
  templateUrl: './sales-person-list.component.html',
  styleUrls: ['./sales-person-list.component.css']
})
export class SalesPersonListComponent implements OnInit {

  constructor() { }

  salesPersonList: SalesPerson[] =[
    new SalesPerson("Sudhanshu","Pal","sudhanshupal03616@gmail.com",40000,"300"),
    new SalesPerson("Sudhanshu","Pal","arush7007@gmail.com",45000,"300"),
    new SalesPerson("Alok", "Singh","alok123@gmail.com", 35000,"210"),
    new SalesPerson("Shubh", "Shrivastava","ashubh@gmail.com", 45000,"280"),
    new SalesPerson("Aman", "Nigam","nigam@gmail.com", 23000,"160"),
    new SalesPerson("Kashish", "Tripathi","Ktripathi@gmail.com", 54000,"188"),
  ]

  formModel: SalesPerson = new SalesPerson("","","",0,"")

  ngOnInit(): void {
    console.log(this.formModel)

  }
  onSubmit():void{
    this.salesPersonList.push(this.formModel)
  }

}
