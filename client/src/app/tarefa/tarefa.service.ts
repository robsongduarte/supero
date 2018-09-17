import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Tarefa} from '../model/tarefa';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class TarefaService {

  constructor(private http: HttpClient) {
  }

  list(): Observable<Tarefa[]> {
    return this.http.get<Tarefa[]>('rest/tarefas');
  }

  find(id: number): Observable<Tarefa> {
    return this.http.get<Tarefa>('rest/tarefas/' + id);
  }

  create(tarefa: Tarefa): Observable<Tarefa> {
    return this.http
      .post<Tarefa>('rest/tarefas/create', tarefa, httpOptions);
  }

  update(tarefa: Tarefa): Observable<Tarefa> {
    return this.http
      .put<Tarefa>('rest/tarefas/update', tarefa, httpOptions);
  }

  remove(tarefa: Tarefa): Observable<Tarefa> {
    return this.http
      .delete<Tarefa>('rest/tarefas/delete/' + tarefa.id, httpOptions);
  }

}
