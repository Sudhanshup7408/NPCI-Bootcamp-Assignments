import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListEmpComponent } from './components/list-emp/list-emp.component';
import { ListDeptComponent } from './components/list-dept/list-dept.component';

@NgModule({
  declarations: [
    AppComponent,
    ListEmpComponent,
    ListDeptComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
