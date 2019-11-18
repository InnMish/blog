import {Component, OnInit} from '@angular/core';
import {Article} from "../model/article";
import {ActivatedRoute, Router} from '@angular/router';
import {ArticleService} from "../service/article.service";
import {CategoryService} from "../service/category.service";
import {Category} from "../model/category";

@Component({
  selector: 'app-article-form',
  templateUrl: './article-form.component.html',
  styleUrls: ['./article-form.component.scss']
})
export class ArticleFormComponent implements OnInit {

  article: Article;
  categories: Category[];
  category: Category;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private articleService: ArticleService,
              private categoryService: CategoryService) {
    this.article = new Article();
    this.category = new Category();
  }

  onArticleSubmit() {
    this.articleService.save(this.article).subscribe(result => this.goToArticleList());
  }

  goToArticleList() {
    this.router.navigate(['/articles']);
  }

  onCategorySubmit() {
    this.categoryService.save(this.category).subscribe(result => this.categories.push(result));
  }

  ngOnInit() {
    this.categoryService.findAll().subscribe(data => {
        this.categories = data;
      }
    )
  }

}
