# Angular Interview Questions/Topics

## Questions
- What is Angular?
- What is Angular Material?
- What is `directive` and different types of directives?
- What are the building blocks of Angular?
- What is `Dependency Injection` (DI)?
- What is Data Binding? How many ways it can be done?
- Could you explain the various types of filters in Angular?
- What is `ViewEncapsulation` and how many ways are there to do it in Angular?
- Why prioritise TypeScript over JavaScript in Angular?
- What do you understand By `RouterOutlet` and `RouterLink`?
- Angular Component Constructor Vs OnInit
- What happens when you use the `script` tag within a template?
- What is `ViewChild` and you will want to use `{static: false}`?
- Angular Lifecycle Hooks
- What is `AOT` compilation? What are the advantages of `AOT`?
- Explain `"sourceMap": true` in angular.
- Promise vs Observable
- What are Template and Reactive forms?
- Why Use TypeScript?
- `Forroot` vs `childroot`
- Handling Multiple http request using RxJs
- `Map` vs `mergeMap` vs `switchMap` vs `concatMap` vs `exhaustMap`
- What are class decorators?
- What is the Component `Decorator` in Angular?
- In comparison to JIT, a compilation in AOT
- How to prevent `cross-site scripting` (XSS)?
- How to improve website performance?
- Bundle Analysis
- When to Use `Put` and When `Patch`?
- What is purpose of the `angular.json`?
- Angular 17 new features
- What are some of the differences between a standard Angular component and a standalone component?
- bootstrapModule
- Angular testing framework: `Karma`, `Jasmine`
- Can we call api from constructor as well
- pre-fetch your data by using Resolvers
- Explain `Guard` in angular
- Host binding and Host listening
- Explain `Polyfill` in Angular
- Explain Router outlet in angular
- Can we use multiple router outlet?
- Can you write a component without constructor?
- Pure pipe vs Impure pipe
- Formbuilder vs Formgroup in angular



## Answers

### What is Angular?
- Angular is a popular open-source framework developed and maintained by Google for building dynamic web applications.
- Angular framework is used to create `single-page-applications` (SPA).
- It utilizes `TypeScript` for building robust and scalable applications
- Provides tools and libraries for features like `data binding`, `dependency injection`, `routing`, and more. 
- Angular follows the `Model-View-Controller` (MVC) architectural pattern
- Some features:
  - Component-Based Architecture
  - Data Binding
  - Dependency Injection
  - Modules
  - Routing
  - Directives
  - Pipes
  - Guards
  - Interceptors
  - Forms
  - HTTP Client
  - Internationalization (i18n) and Accessibility
  - Testing
  - Change detection, lazy loading, route reuse

### What is Angular Material?
- Angular Material is a UI component library developed by the Angular team at Google. 
- It provides a set of pre-built and customizable UI components for Angular applications
- Follows the Material Design principles established by Google. 
- These components include items such as buttons, cards, forms, navigation components, and more.
- Angular Material simplifies the process of creating modern and visually appealing user interfaces by offering ready-to-use components. 
- Developers can easily incorporate these components into their Angular applications.

Import Angular Material and it's dependencies
```bash
ng add @angular/material
```
Create a new component using Angular CLI
```bash
ng generate component toolbar
```
Import Angular Material modules in `app.module.ts`
```typescript
import { ToolbarComponent } from './toolbar/toolbar.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';

@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```
Use Material components in `toolbar.component.html`
```html
<mat-toolbar color="accent">
  <span>Angular Material Toolbar</span>
  <button mat-button color="primary">Click me!</button>
</mat-toolbar>
```

#### Create Custom Theme


### What is `directive` and different types of directives?
- Directives add behavior to their host elements.
- Directives are used to extend the behavior of HTML elements or attributes in Angular applications. 
- It allows to attach behavior to elements or manipulate the DOM in various ways.

There are three types of directives in Angular:

**1. Component Directives:**
- Components are the most common type of directive in Angular.
- They are used to create custom HTML elements and encapsulate their behavior and presentation logic.
- Components have their own templates, styles, and behavior, making them self-contained building blocks of Angular applications.

**2. Attribute Directives:**
- Attribute directives changes the appearance or behavior of an element, component, or another directive.
- They are applied to elements as attributes.
- DOM friendly
- Examples of built-in structural directives in Angular include `*ngStyle`, `*ngClass` (BrowserModule).


**3. Structural Directives:**
- Structural directives changes the structure of the DOM by adding, removing, or manipulating elements.
- They usually have a star * before their name
- DOM un-friendly
- Examples of built-in structural directives in Angular include `*ngIf`, `*ngFor`, and `*ngSwitch` (BrowserModule).

#### Host Element
A directive can interact with its host DOM element in the following ways:
- It binds to and updates its properties using `@HostBinding`
- It listens to its events using `@HostListener`

#### Create Custom Directive
Generate Directive
```shell
ng g d custom
```
Custom Directive
```typescript
import {Directive, ElementRef, Renderer2} from '@angular/core';

@Directive({
  selector: '[appCustomDirective]'
})
export class CustomDirective {
    @HostBinding('style.backgroundColor') background: string;
    @HostBinding('value') value: string;
    @HostBinding('attr.role') role: string;
    @HostBinding('style.width.px') width: number;
    @HostBinding('disabled') disabled: boolean;
    
    constructor(private elementRef: ElementRef, private renderer: Renderer2) {}

    ngOnInit() {
      // this.elementRef.nativeElement.style.fontSize = '22px'; // DOM Dependent
      this.renderer.setStyle(this.elementRef.nativeElement, 'font-size', '22px'); // DOM Independent
      this.renderer.setStyle(this.elementRef.nativeElement, 'margin', '22px');
    }

    @HostListener('mouseenter') handleMouseEnter() {
      this.renderer.setStyle(this.elementRef.nativeElement, 'color', 'red');
      this.background = 'gray';
    }
  
    @HostListener('mouseleave') handleMouseLeave() {
      this.renderer.setStyle(this.elementRef.nativeElement, 'color', 'green');
      this.background = 'white';
    }
}
```

#### Why Renderer2?
- We don’t interact with the DOM directly. Angular aims to provide a higher-level API, 
so the native platform, the DOM, will just reflect the state of the Angular application.
- It makes components easier to refactor.
- It allows unit testing most of the behavior of an application without touching the DOM.
- It allows running Angular applications in a web worker, server, or other platforms where a native DOM isn’t present (Server Side Rendering).

### What are the building blocks of Angular?


### What is `Dependency Injection` (DI)?

### What is Data Binding? How many ways it can be done?

### Could you explain the various types of filters in Angular?

### What is `ViewEncapsulation` and how many ways are there to do it in Angular?

### Why prioritise TypeScript over JavaScript in Angular?

### What do you understand By `RouterOutlet` and `RouterLink`?

### Angular Component Constructor Vs OnInit

### What happens when you use the `script` tag within a template?

### What is `ViewChild` and you will want to use `{static: false}`?

### Angular Lifecycle Hooks

### What is `AOT` compilation? What are the advantages of `AOT`?

### Explain `"sourceMap": true` in angular.

### Promise vs Observable

### What are Template and Reactive forms?

### Why Use TypeScript?

### `Forroot` vs `childroot`

### Handling Multiple http request using RxJs

### `Map` vs `mergeMap` vs `switchMap` vs `concatMap` vs `exhaustMap`

### What are class decorators?

### What is the Component `Decorator` in Angular?

### In comparison to JIT, a compilation in AOT

### How to prevent `cross-site scripting` (XSS)?

### How to improve website performance?

### Bundle Analysis

### When to Use `Put` and When `Patch`?

### What is purpose of the `angular.json`?

### Angular 17 new features

### What are some of the differences between a standard Angular component and a standalone component?

### bootstrapModule

### Angular testing framework: `Karma`, `Jasmine`

### Can we call api from constructor as well

### pre-fetch your data by using Resolvers

### Explain `Guard` in angular

### Host binding and Host listening

### Explain `Polyfill` in Angular

### Explain Router outlet in angular

### Can we use multiple router outlet?

### Can you write a component without constructor?

### Pure pipe vs Impure pipe

### Formbuilder vs Formgroup in angular