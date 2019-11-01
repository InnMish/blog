import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClientModule} from "@angular/common/http";
import { ArticleListPageComponent } from './pages/article-pages/article-list-page/article-list-page.component';
import { ConfirmationDialogComponent } from './_shared/dialogs/confirmation-dialog/confirmation-dialog.component';
import { ChangeDataDialogComponent } from './_shared/dialogs/change-data-dialog/change-data-dialog.component';
import { ErrorDialogComponent } from './_shared/dialogs/error-dialog/error-dialog.component';
import { HeaderComponent } from './core/header/header.component';


@NgModule({
  declarations: [
    AppComponent,
    ArticleListPageComponent,
    ConfirmationDialogComponent,
    ChangeDataDialogComponent,
    ErrorDialogComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
