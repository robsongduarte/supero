import {Component, OnInit} from '@angular/core';
import {TarefaService} from '../tarefa.service';
import {Router} from '@angular/router';
import {Tarefa} from '../../model/tarefa';
import {MatDialog} from '@angular/material';
import {ModalConfirmacaoComponent} from '../../modal-confirmacao/modal-confirmacao.component';
import {switchMap} from 'rxjs/internal/operators';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {

  tarefas: Tarefa[] = [];

  constructor(private service: TarefaService,
              private router: Router,
              private confirm: MatDialog) {
  }

  ngOnInit() {
    this._list();
  }

  _list() {
    this.service.list()
      .subscribe(
        tarefas => {
          this.tarefas = tarefas;
        },
        error => console.log(error));
  }

  novo(event: Event) {
    event.preventDefault();
    this.router.navigate(['novo']);
  }

  editar(tarefa: Tarefa) {
    this.router.navigate(['editar', tarefa.id]);
  }

  excluir(tarefa: Tarefa) {
    const modal = this.confirm
      .open(ModalConfirmacaoComponent, {
        data: 'Você tem certeza que deseja excluir a tarefa?',
        hasBackdrop: true
      });

    modal.beforeClose()
      .subscribe(result => {
        if (result) {
          this.service.remove(tarefa)
            .subscribe(() => {
              this._list();
            });
        }
      });

  }
}
