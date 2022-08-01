import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProductServiceService } from 'src/app/services/product-service.service';
import { Department } from 'src/app/common/department';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  constructor(private service: ProductServiceService) { }
  formModel: Department = new Department(0,"")
  categories : Department[]
  ngOnInit(): void {
    this.listOfCategory()
  }

  listOfCategory(){
    this.service.getAllCategory().subscribe(data=>{
      console.log(data)
      this.categories = data
    })
  }
  onSubmit():void{
    this.categories.push(this.formModel)
  }

}
