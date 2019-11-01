import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import { ArticleDetailsComponent } from './article-details/article-details.component';
import {AngularMaterialModule} from "../../_shared/angular-material.module";
import {SharedModule} from "../../_shared/shared.module";

@NgModule({
  declarations: [
    ArticleDetailsComponent
  ],

  exports: [
    ArticleDetailsComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,

    AngularMaterialModule,
    RouterModule,
    SharedModule
  ]
})
export class ArticlesModule {
}
