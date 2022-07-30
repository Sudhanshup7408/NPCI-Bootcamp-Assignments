import { OnInit } from '@angular/core';

export class SalesPerson {
    constructor(
        public firstName:string,
        public lastName:string,
        public email:string,
        public salary:number,
        public salesVolume:string){}
}
