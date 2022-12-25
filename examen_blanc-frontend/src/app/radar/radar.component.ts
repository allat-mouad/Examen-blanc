import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-radar',
  templateUrl: './radars.component.html',
  styleUrls: ['./radars.component.css']
})
export class RadarComponent implements OnInit {
  tadars :any;
  constructor(private http:HttpClient,private router: Router) { }

  ngOnInit(): void {
    this.http.get("http://localhost:8080/radar")
      .subscribe({
        next : (data)=>{
          this.radars=data;
        },
        error : (err)=>{}
      });
  }

}
