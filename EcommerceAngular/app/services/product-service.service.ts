import { Injectable } from '@angular/core';
import { Observable , map} from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ProductClass } from '../common/product-class';
import { Department } from '../common/department';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  prodURL = "http://localhost:8080/api/prod"
  depURL = "http://localhost:8080/api/departments"

  constructor(private httpClient : HttpClient) { }
  getAllProducts() : Observable<ProductClass[]>{
    return this.httpClient.get<getProductResponse>(this.prodURL).pipe(map(response => response._embedded.products))
  }
  getAllCategory() : Observable<Department[]>{
    return this.httpClient.get<getCategoryResponse>(this.depURL).pipe(map(response => response._embedded.categories))
  }

}
interface getProductResponse{
  _embedded : {
    products : ProductClass[]
  }
}
interface getCategoryResponse{
  _embedded : {
    categories : Department[]
  }
}