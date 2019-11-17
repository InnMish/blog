import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ArticleListComponent} from "./article-list/article-list.component";
import {ParagraphListComponent} from "./paragraph-list/paragraph-list.component";
import {ArticleFormComponent} from "./article-form/article-form.component";


const routes: Routes = [
  {path: 'articles', component: ArticleListComponent},
  {path: 'articles/:article.id', component: ParagraphListComponent},
  {path: 'create', component: ArticleFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
