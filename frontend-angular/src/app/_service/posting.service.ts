import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Posting } from '../_model/posting';
import { Observable } from 'rxjs';

@Injectable()
export class PostingService {

	private postingsUrl: string;

  constructor(private http: HttpClient) {
	  this.postingsUrl = "/api/postings";
  }
  
  public findAll(): Observable<Posting[]> {
	  return this.http.get<Posting[]>(this.postingsUrl);
  }
  
  public save(posting: Posting) {
	  return this.http.post<Posting>(this.postingsUrl, posting);
  }
  
  public update(posting: Posting) {
	  return this.http.put<Posting>(this.postingsUrl+"/"+posting.id, posting);
  }
  
  public delete(id: number): Observable<any> {
	  return this.http.delete(`${this.postingsUrl}/${id}`);
  }
}
