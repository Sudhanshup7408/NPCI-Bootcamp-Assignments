import { Component, OnInit } from '@angular/core';
import { ProductClass } from 'src/app/common/product-class';
import { ProductServiceService } from 'src/app/services/product-service.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  constructor(private service: ProductServiceService) { }
  formModel: ProductClass = new ProductClass(0,"","","",0,"",0,"","","")
  products : ProductClass[]
  ngOnInit(): void {
    console.log(this.formModel)
    this.listOfProducts()
  }

  listOfProducts(){
    this.service.getAllProducts().subscribe(data=>{
      console.log(data)
      this.products = data
    })
}
onSubmit():void{
  this.products.push(this.formModel)
}
}