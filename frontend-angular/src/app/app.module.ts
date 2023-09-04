import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { PostingService } from './_service/posting.service';
import { PostingListComponent } from './posting-list/posting-list.component';
import { PostingFormComponent } from './posting-form/posting-form.component';
import { DataService } from './_service/data.service';


@NgModule({
  declarations: [
    AppComponent,
    PostingListComponent,
    PostingFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PostingService,DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
