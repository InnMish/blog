import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from "@angular/material";
import {ChangeDataDialogModel} from "../_models/change-data-dialog.model";

@Component({
  selector: 'app-change-data-dialog',
  templateUrl: './change-data-dialog.component.html',
  styleUrls: ['./change-data-dialog.component.scss']
})
export class ChangeDataDialogComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: ChangeDataDialogModel) { }

  ngOnInit() {
  }

}
