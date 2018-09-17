import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {TarefaService} from '../tarefa.service';
import {Tarefa} from '../../model/tarefa';
import {switchMap} from 'rxjs/internal/operators';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {

  form: FormGroup;

  constructor(private fb: FormBuilder,
              private service: TarefaService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this._createForm();

    this.route.params
      .pipe(switchMap((params: Params) => this.service.find(params['id'])))
      .subscribe((tarefa: Tarefa) => {
        console.log(tarefa);

        this.form.patchValue({
          id: tarefa.id,
          titulo: tarefa.titulo,
          status: tarefa.status,
          descricao: tarefa.descricao
        });


      });
  }

  _createForm() {
    this.form = this.fb
      .group({
        id: [null, null],
        titulo: ['', Validators.required],
        status: ['TODO', Validators.required],
        descricao: ['', Validators.required]
      });
  }

  salvar() {
    this.service.update(this.form.value)
      .subscribe(
        (result) => {
          this.router.navigate(['/']);
        },
        error => console.log(error)
      );
  }

}
