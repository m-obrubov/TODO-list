import { Component } from '@angular/core';
import { ModalController } from 'ionic-angular'; 
import { AddPage } from '../add/add';

@Component({
  selector: 'page-list',
  templateUrl: 'list.html'
})
export class ListPage {

  constructor(public modalCtrl: ModalController) {

  }

  public presentAddModal() {
    let addModal = this.modalCtrl.create(AddPage);
    addModal.present();
  }

}
