import {NgModule} from "@angular/core";
import { ArticleDetailsPageComponent } from './article-details-page/article-details-page.component';
import {ArticleListPageComponent} from "./article-list-page/article-list-page.component";
import { ArticleSavePageComponent } from './article-save-page/article-save-page.component';
import {CommonModule} from "@angular/common";
import {
  MatButtonModule,
  MatIconModule,
  MatMenuModule,
  MatProgressSpinnerModule, MatSortModule, MatTableModule,
  MatTooltipModule
} from "@angular/material";
import {ArticlePageRoutingModule} from "./article-page-routing.module";
import {ArticlesModule} from "../../features/articles/article.module";

@NgModule({
  declarations: [
    ArticleDetailsPageComponent,
    ArticleListPageComponent,
    ArticleSavePageComponent,
  ],
  imports: [
    CommonModule,
    MatProgressSpinnerModule,
    MatIconModule,
    MatTableModule,
    MatSortModule,
    MatTooltipModule,
    MatButtonModule,
    MatMenuModule,

    ArticlePageRoutingModule,
    ArticlesModule,


  ]
})
export class ArticlePageModule {

}
