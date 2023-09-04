import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { PostingService } from '../_service/posting.service';
import { Posting } from '../_model/posting';
import { map } from 'rxjs';
import { DataService } from '../_service/data.service';

@Component({
  selector: 'app-posting-form',
  templateUrl: './posting-form.component.html',
  styleUrls: ['./posting-form.component.css']
})
export class PostingFormComponent implements OnInit {

	posting: Posting;
	mode: String;
    state$: any;
	
	constructor(public dataService: DataService,
				private router: Router, private postingService: PostingService) {
	}
	
	ngOnInit() {
		if(this.dataService.editPosting == null || this.dataService.editPosting.id == -1){
			console.log("url:"+this.router.url.substring(this.router.url.length - 4));
			if(this.router.url.substring(this.router.url.length - 4) == 'edit'){
				this.router.navigate(['/postings/add']);
			}
			this.mode = "Add New Posting";
			this.posting = new Posting();
		}
		else {
			this.mode = "Update Existing Posting";
			this.posting = this.dataService.editPosting;
		}
	}

	onSubmit() {
		if(this.mode == "Add New Posting") {
			this.postingService.save(this.posting).subscribe(() => this.goToPostingList());
		}
		if(this.mode == "Update Existing Posting") {
			this.postingService.update(this.posting).subscribe(() => this.goToPostingList());
		}
	}
	
	goToPostingList() {
		this.router.navigate(['/postings']);
	}
}
