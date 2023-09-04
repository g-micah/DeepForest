import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostingListComponent } from './posting-list/posting-list.component';
import { PostingFormComponent } from './posting-form/posting-form.component';

const routes: Routes = [
	{ path: 'postings', component: PostingListComponent },
	{ path: 'postings/add', component: PostingFormComponent },
	{ path: 'postings/edit', component: PostingFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
