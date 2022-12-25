import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

const httpOptions = {
  headers: {
    'Content-Type': 'application/json',
    'Accept': 'application/json',
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Methods': '*',
    'Access-Control-Allow-Headers': '*',
  }
};



export class RadarService {

  constructor(private http: HttpClient) {
  }

  public getRadars():any {
    return this.http.get(environment.radarQueriesBaseUrl + 'getAllRadars', httpOptions);
  }


}
