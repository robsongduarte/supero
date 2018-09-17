import {Routes, RouterModule} from '@angular/router';
import {ListaComponent} from './tarefa/lista/lista.component';
import {CadastroComponent} from './tarefa/cadastro/cadastro.component';
import {EditarComponent} from './tarefa/editar/editar.component';

const routes: Routes = [
  {
    path: '',
    component: ListaComponent
  },
  {
    path: 'novo',
    component: CadastroComponent
  },
  {
    path: 'editar/:id',
    component: EditarComponent
  },
  {
    path: '**',
    component: ListaComponent
  }
];

export const appRoutes: any = RouterModule.forRoot(routes);
