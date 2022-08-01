import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private routes : Router) { }

  ngOnInit(): void {
  }
  productDetails(){
    this.routes.navigateByUrl("/products")
  }
  categoryDetails(){
    this.routes.navigateByUrl("/categories")
  }
  addProducts(){
    this.routes.navigateByUrl("/addProducts")
  }
  saveProduct(){
    this.routes.navigateByUrl("/products")
  }

}
