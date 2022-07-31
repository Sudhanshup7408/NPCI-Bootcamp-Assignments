import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { CategoryListComponent } from './components/category-list/category-list.component';
import {FormsModule} from '@angular/forms';
import { HomeComponent } from './components/home/home.component';
import { RouterModule, Routes } from '@angular/router';
const route : Routes =[
  {path : '',component:HomeComponent},
  {path:'products',component:ProductListComponent},
  {path:'categories',component:CategoryListComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    CategoryListComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(route)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
