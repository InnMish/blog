import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ArticleListPageComponent} from "./article-list-page/article-list-page.component";
import {ArticleSavePageComponent} from "./article-save-page/article-save-page.component";
import {ArticleDetailsPageComponent} from "./article-details-page/article-details-page.component";

const routes: Routes = [
  {
    path: '',
    component: ArticleListPageComponent
  },
  {
    path: 'create',
    component: ArticleSavePageComponent
  },
  {
    path: ':userId',
    component: ArticleDetailsPageComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ArticlePageRoutingModule {
}
