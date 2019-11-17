import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Article} from "../model/article";

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  private articleUrl: string;

  constructor(private http: HttpClient) {
    this.articleUrl = 'http://localhost:8080/';
  }

  public findAll(): Observable<Article[]> {
    return this.http.get<Article[]>(this.articleUrl);
  }

  public save(article: Article) {
    return this.http.post<Article>(this.articleUrl, article);
  }
}
