import { Component, OnInit } from '@angular/core';
import {Paragraph} from "../model/paragraph";
import {ParagraphService} from "../service/paragraph.service";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-paragraph-list',
  templateUrl: './paragraph-list.component.html',
  styleUrls: ['./paragraph-list.component.scss']
})
export class ParagraphListComponent implements OnInit {

  paragraphs: Paragraph[];

  constructor(private paragraphService: ParagraphService,
              private route: ActivatedRoute) {

  }

  ngOnInit() {
    this.route.paramMap.subscribe((paramMap: ParamMap) => {
      if (paramMap.has('article.id')) {
        const idAsString = paramMap.get('article.id');
        this.paragraphService.findParagraphsByArticleId(Number.parseInt(idAsString)).subscribe(data => {
          this.paragraphs = data;
        })
      }
    });
  }
}
