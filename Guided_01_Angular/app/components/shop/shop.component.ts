import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductServiceService } from 'src/app/services/product-service.service';
import { ProductClass } from 'src/app/common/product-class';
import { Department } from 'src/app/common/department';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  products: ProductClass = new ProductClass(0,"","","",0,"",0,"","","")
  categories: Department[]
  constructor(private service :ProductServiceService, private routes: Router) { }
  
  ngOnInit(): void {
    this.listOfCategory()
  }
  listOfCategory(){
    this.service.getAllCategory().subscribe(data=>{
      this.categories = data
    })
  }

  onSubmit(): void{
    this.service.saveProduct(this.products).subscribe(()=>{
      this.routes.navigateByUrl("/products")
    })
  }
}