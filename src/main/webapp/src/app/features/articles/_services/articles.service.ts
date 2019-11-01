import {Article} from "../_models/article.model";
import {Observable, Subject} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Comment} from "../../comments/_models/comment.model";
import {Paragraph} from "../../paragraphs/_models/paragraph.model";
import {Category} from "../../categories/_models/category.model";

const BACKEND_URL = '/';

export class ArticlesService {
  private articles: Article[] = [];
  private articlesUpdated = new Subject<Article[]>();

  constructor(private http: HttpClient,
              private router: Router) {
  }

  getArticles() {
    this.http
      .get<Article[]>(BACKEND_URL)
      .subscribe(transformedArticleData => {
        this.articles = transformedArticleData;
        this.articlesUpdated.next([...this.articles]);
      });
  }

  navigateToArticlesList() {
    this.router.navigate(['/articles']);
  }

  navigateToArticleDetails(id: number) {
    this.router.navigate(['/articles' + id])
  }

  navigateToArticleEditing(id: number) {
    this.router.navigate([`/edit/${id}`]);
  }

  getArticleById(id: number) {
    return this.http.get<Article>('/search/' + id);
  }

  getArticleByName(name: string) {
    return this.http.get<Article>('/search/name/' + name);
  }

  getArticleUpdateListener() {
    return this.articlesUpdated.asObservable();
  }

  getArticlesByCategoryName(categoryName: string): Observable<Article[]> {
    return this.http
      .get<Article[]>('/filter/' + categoryName);
  }

  addArticle(title: string, description: string, comments: Comment[], paragraphs: Paragraph[], category: Category) {

    const newArticle: Article = {
      articleId: -1,
      title,
      description,
      comments,
      paragraphs,
      category
    };

    this.http
      .post('/create', newArticle)
      .subscribe(responseData => {
        // console.log(responseData);
        this.navigateToArticlesList();
      });
  }

  updateArticle(articleId: number, title: string, description: string, comments: Comment[], paragraphs: Paragraph[],
                category: Category) {
    const articleData: Article = {
      articleId,
      title,
      description,
      comments,
      paragraphs,
      category
    };

    this.http
      .put('/edit', articleData)
      .subscribe(responseData => {
        // console.log(responseData);
        this.navigateToArticlesList();
      });
  }

  deleteArticle(articleId: number) {
    return this.http
      .delete('/delete/' + articleId);
  }

}
