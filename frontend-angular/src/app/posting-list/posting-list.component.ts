import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Posting } from '../_model/posting';
import { DataService } from '../_service/data.service';
import { PostingService } from '../_service/posting.service';

@Component({
  selector: 'app-posting-list',
  templateUrl: './posting-list.component.html',
  styleUrls: ['./posting-list.component.css']
})
export class PostingListComponent implements OnInit {
	
	postings: Posting[];
	postingToEdit: Posting;

	constructor(public dataService: DataService, private router: Router, private postingService: PostingService) {
	}

	ngOnInit() {
		this.postingToEdit = new Posting();
		this.postingToEdit.id = -1;
		this.postingService.findAll().subscribe(data => {
			this.postings = data;
		});
  	}
  	
  	ngOnDestroy() {
		this.dataService.editPosting = this.postingToEdit;
	}
  	
  	public deletePosting(postingId: number) {
		this.postingService.delete(postingId).subscribe();
		location.reload();
	}
	
	public editPosting(posting: Posting) {
		this.postingToEdit = posting;
		this.router.navigateByUrl('/postings/edit');
		return;
	}
}
