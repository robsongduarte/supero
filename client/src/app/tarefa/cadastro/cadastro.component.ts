import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {TarefaService} from '../tarefa.service';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {switchMap} from 'rxjs/internal/operators';
import {Tarefa} from '../../model/tarefa';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  form: FormGroup;
  title: string = 'Cadastro de Tarefas';

  constructor(private fb: FormBuilder,
              private service: TarefaService,
              private router: Router,
              private route: ActivatedRoute) {

    this._createForm();
  }

  ngOnInit() {
  }

  _createForm() {
    this.form = this.fb
      .group({
        titulo: ['', Validators.required],
        status: ['TODO', Validators.required],
        descricao: ['', Validators.required]
      });
  }

  submit() {
    this.service.create(this.form.value)
      .subscribe(
        (result) => {
          this.router.navigate(['/']);
        },
        error => console.log(error)
      );
  }

}
