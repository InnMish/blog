import {Observable} from "rxjs";
import {ConfirmationDialogComponent} from "./confirmation-dialog/confirmation-dialog.component";
import {MatDialog} from "@angular/material";
import {ChangeDataDialogModel} from "./_models/change-data-dialog.model";
import {ChangeDataDialogComponent} from "./change-data-dialog/change-data-dialog.component";
import {ErrorMessage} from "./_models/error-message.model";
import {ErrorDialogComponent} from "./error-dialog/error-dialog.component";
import {Injectable} from "@angular/core";

@Injectable()
export class DialogsService {

  constructor(private dialog: MatDialog) {
  }

  openConfirmationDialog(message: string): Observable<boolean> {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: 'Do you want to ' + message
    });

    return dialogRef.afterClosed();
  }

  openChangeDataDialog(data: ChangeDataDialogModel): Observable<boolean> {
    const dialogRef = this.dialog.open(ChangeDataDialogComponent, {
      data
    });

    return dialogRef.afterClosed();
  }

  openErrorDialog(data: ErrorMessage[]): Observable<boolean> {
    const dialogRef = this.dialog.open(ErrorDialogComponent, {
      data
    });

    return dialogRef.afterClosed();
  }
}
