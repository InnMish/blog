import {Component, OnDestroy, OnInit} from '@angular/core';
import {Article} from "../../../features/articles/_models/article.model";
import {Subscription} from "rxjs";
import {ArticlesService} from "../../../features/articles/_services/articles.service";
import {DialogsService} from "../../../_shared/dialogs/dialogs.service";

@Component({
  selector: 'app-article-list-page',
  templateUrl: './article-list-page.component.html',
  styleUrls: ['./article-list-page.component.scss']
})
export class ArticleListPageComponent implements OnInit, OnDestroy {

  isLoading = false;
  fetchedArticles: Article[] = [];
  displayedColumns: string[] = ['title', 'description'];

  private articleSub = Subscription.EMPTY;

  constructor(private articlesService: ArticlesService,
              private dialogsService: DialogsService) { }

  ngOnInit(): void {
    this.isLoading = true;
    this.articlesService.getArticles();
    this.articleSub = this.articlesService.getArticleUpdateListener()
      .subscribe((articleData: Article[]) => {
          this.isLoading = false;
          this.fetchedArticles = articleData;
        },
        error => {
          this.fetchedArticles = [];
          this.isLoading = false;
        });
  }

  onButtons(action: { action: string, id: number }) {
    switch (action.action) {
      case 'details':
        this.articlesService.navigateToArticleDetails(action.id);
        break;
      case 'edit':
        this.articlesService.navigateToArticleEditing(action.id);
        break;
      case 'delete':
        this.onDelete(action.id);
        break;
    }
  }

  onDelete(articleId: number) {
    this.dialogsService.openConfirmationDialog('delete article?').subscribe(result => {
      if (!result) {
        return;
      }
      this.isLoading = true;
      this.articlesService.deleteArticle(articleId)
        .subscribe(() => {
          this.articlesService.getArticles();
        }, error => {
          this.isLoading = false;
        });
    });
  }

  ngOnDestroy(): void {
    this.articleSub.unsubscribe();
  }

}
