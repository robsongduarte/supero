import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MaterialModule} from './app.material.module';
import {CadastroComponent} from './tarefa/cadastro/cadastro.component';
import {ListaComponent} from './tarefa/lista/lista.component';
import {appRoutes} from './app.routes';
import {TarefaService} from './tarefa/tarefa.service';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import { EditarComponent } from './tarefa/editar/editar.component';
import { ModalConfirmacaoComponent } from './modal-confirmacao/modal-confirmacao.component';

@NgModule({
  declarations: [
    AppComponent,
    CadastroComponent,
    ListaComponent,
    EditarComponent,
    ModalConfirmacaoComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    ReactiveFormsModule,
    appRoutes
  ],
  entryComponents: [
    ModalConfirmacaoComponent
  ],
  providers: [TarefaService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
