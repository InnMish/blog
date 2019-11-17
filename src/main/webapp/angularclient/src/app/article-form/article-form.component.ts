import { Component, OnInit } from '@angular/core';
import {Article} from "../model/article";
import { ActivatedRoute, Router } from '@angular/router';
import {ArticleService} from "../service/article.service";

@Component({
  selector: 'app-article-form',
  templateUrl: './article-form.component.html',
  styleUrls: ['./article-form.component.scss']
})
export class ArticleFormComponent implements OnInit {

  article: Article;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private articleService: ArticleService) {
    this.article = new Article();
  }

  onSubmit() {
    this.articleService.save(this.article).subscribe(result => this.goToArticleList());
  }

  goToArticleList() {
    this.router.navigate(['/articles']);
  }
  ngOnInit() {
  }

}
