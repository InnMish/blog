import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Paragraph} from "../model/paragraph";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class ParagraphService {
  /*private paragraphUrl: string;*/

  constructor(private http: HttpClient) {
    /*this.paragraphUrl = 'http://localhost:8080/paragraphs/article/{id}';*/
  }

  public findParagraphsByArticleId(articleId: number): Observable<Paragraph[]> {
    return this.http.get<Paragraph[]>('http://localhost:8080/paragraphs/article/' + articleId)
      .pipe(map((paragraphData: Paragraph[]) => {
          return paragraphData;
        })
      );
  }
}
