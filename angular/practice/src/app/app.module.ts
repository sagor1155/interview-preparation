import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { RouterOutlet } from "@angular/router";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { CustomDirective } from './custom.directive';

@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    CustomDirective
  ],
    imports: [
        BrowserModule,
        RouterOutlet,
        BrowserAnimationsModule,
        MatToolbarModule,
        MatButtonModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
