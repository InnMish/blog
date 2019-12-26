import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArticleListComponent } from './article-list/article-list.component';
import {HttpClientModule} from '@angular/common/http';
import { ParagraphListComponent } from './paragraph-list/paragraph-list.component';
import { ArticleFormComponent } from './article-form/article-form.component';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatStepperModule} from "@angular/material/stepper";
import {MatSelectModule} from "@angular/material/select";
import {MatButtonModule} from "@angular/material/button";
import {AngularEditorModule} from "@kolkov/angular-editor";

@NgModule({
  declarations: [
    AppComponent,
    ArticleListComponent,
    ParagraphListComponent,
    ArticleFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatStepperModule,
    MatSelectModule,
    MatButtonModule,
    AngularEditorModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
