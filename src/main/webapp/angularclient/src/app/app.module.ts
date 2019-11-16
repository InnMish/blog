import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArticleListComponent } from './article-list/article-list.component';
import {HttpClientModule} from '@angular/common/http';
import { ParagraphListComponent } from './paragraph-list/paragraph-list.component';

@NgModule({
  declarations: [
    AppComponent,
    ArticleListComponent,
    ParagraphListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
