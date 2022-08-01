import { Injectable } from '@angular/core';
import { Observable , map} from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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
  saveProduct(products: ProductClass){
    console.log(products)
    const httpOptions=
    {
      header: new HttpHeaders
      ({
        'Content-type':'application/json',
        'Authorization':'auth-token',
        'Access-Control-Allow-Origin':'*'
      })
    };
    return this.httpClient.post<ProductClass>(this.prodURL,products)
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