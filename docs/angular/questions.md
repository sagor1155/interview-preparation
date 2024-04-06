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
- What are Template-driven forms and Reactive forms?
- `forRoot` vs `forChild`
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

### 1. What is Angular?
- Angular is a popular open-source framework developed and maintained by Google for building dynamic web applications.
- Angular framework is used to create `single-page-applications` (SPA).
- It utilizes `TypeScript` for building robust and scalable applications
- Provides tools and libraries for features like `data binding`, `dependency injection`, `routing`, and more. 
- Angular follows the `Model-View-Controller` (MVC) architectural pattern
- Some features:
  - Modules
  - Components
  - Templates
  - Services
  - Dependency Injection
  - Data Binding (Interpolation, Property binding, Event binding)
  - Change detection strategy (Default, OnPush)
  - Module loading strategy (Lazy loading, Eager loading)
  - Route reuse strategy
  - Routing
  - Directives
  - Pipes
  - Guards
  - Interceptors
  - Forms
  - Internationalization (i18n) and Accessibility

### 2. What is Angular Material?
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


### 3. What is `directive` and different types of directives?
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
- Examples of built-in attribute directives in Angular includes `ngStyle` and `ngClass` (BrowserModule).

**3. Structural Directives:**
- Structural directives changes the structure of the DOM by adding, removing, or manipulating elements.
- They usually have a star * before their name
- DOM un-friendly
- Examples of built-in structural directives in Angular includes `*ngIf`, `*ngFor`, and `*ngSwitch` (BrowserModule).

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

### 4. What are the building blocks of Angular?
- Modules
- Components
- Templates
- Services
- Dependency Injection
- Data Binding (Interpolation, Property binding, Event binding)
- Change detection strategy (Default, OnPush)
- Module loading strategy (Lazy loading, Eager loading)
- Route reuse strategy
- Routing
- Directives
- Pipes
- Guards
- Interceptors
- Forms
- Internationalization (i18n) and Accessibility

### 5. What is `Dependency Injection` (DI)?
- Dependency Injection (DI) is a design pattern 
- Enables the creation and management of objects and their dependencies within an application. 
- Provides necessary dependencies (services/objects) to a component/service rather than having the component/service create them directly.

Example:

UserService
```typescript
@Injectable({
  providedIn: 'root'
})
export class UserService {
  getUsers() {
    // Simulate fetching user data from a server
    return ['User 1', 'User 2', 'User 3'];
  }
}
```
UserListComponent
```typescript
@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users: string[];
  constructor(private userService: UserService) { }
  ngOnInit() {
    // Use the UserService to fetch users
    this.users = this.userService.getUsers();
  }
}
```
AppModule
```typescript
@NgModule({
  declarations: [
    UserListComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [UserService], // Provide UserService at the module level
  bootstrap: [UserListComponent]
})
export class AppModule { }
```


### 6. What is Data Binding? How many ways it can be done?
Data binding in Angular refers to the synchronization of data between the component's model (business logic) and the view (HTML template). 
It allows you to dynamically update the view whenever the model changes, and vice versa.

There are 4 types of data binding supported in Angular:
#### Interpolation
Interpolation is the simplest form of data binding in Angular. 
It allows you to bind a component's property to the view by enclosing it within double curly braces `{{ }}`.

Component
```typescript
message = 'Hello, Angular!';
```
Template
```html
<p>{{ message }}</p>
```

#### Property Binding
Property binding allows you to set an HTML attribute or property to the value of a component's property.

Component
```typescript
imageUrl = 'https://example.com/image.jpg';
```
Template
```html
<img [src]="imageUrl">
```

#### Event Binding
Event binding allows you to listen for events raised by DOM elements or child components.

Child Component
```typescript
@Component({
  selector: 'app-child',
  template: `
     <button (click)="emitEvent()">Send Data</button>
   `
})
export class ChildComponent {
  @Output() messageEvent = new EventEmitter<string>();

  emitEvent() {
    this.messageEvent.emit('Hello from Child!');
  }
}
```
Parent Component
```typescript
@Component({
  selector: 'app-parent',
  template: `
     <app-child (messageEvent)="handleMessage($event)"></app-child>
     <p>Message from Child: {{ message }}</p>
   `
})
export class ParentComponent {
  message = '';
  handleMessage(message: string) {
    this.message = message;
  }
}
```

#### Two-way Binding
Two-way binding allows you to both set and get the value of an input element. 
It's achieved using the `ngModel` directive, which combines `property binding` and `event binding` under the hood. 
It's commonly used with `form` elements like `input`, `select`, and `textarea`.

Component
```typescript
@Component({
  selector: 'app-root',
  template: `
     <input type="text" [(ngModel)]="name" placeholder="Enter your name">
     <p>Hello, {{ name }}!</p>
   `
})
export class AppComponent {
  name = 'John Doe';
}
```

### 7. Could you explain the various types of filters in Angular?
Angular provides filters to transform data:
- `currency` - Format a number to a currency format.
- `date` - Format a date to a specified format.
- `filter` - Select a subset of items from an array.
- `json` - Format an object to a JSON string.
- `limitTo` - Limits an array/string, into a specified number of elements/characters.
- `lowercase` - Format a string to lower case.
- `uppercase` - Format a string to upper case.
- `number` - Format a number to a string.
- `orderBy` - Orders an array by an expression.

Example
```html
<p>{{ today | date : "dd.MM.yyyy" }}</p>
<p> Price: {{ product.price | currency:'USD':2 }} </p>
<ul>
  <li *ngFor="let item of items | orderBy:'name'">{{item.name}}</li>
</ul>
```

### 8. What is `ViewEncapsulation` and how many ways are there to do it in Angular?
- `ViewEncapsulation`  allows you to control how styles are `scoped` to Angular components. 
- It determines whether styles defined in a component's CSS files affect only that component's view 
  or are applied globally across the entire application.

The 3 states of view encapsulation in Angular are:

**1. None:**
- With `None` encapsulation, Angular disables encapsulation for the component. 
- Styles defined in the component's CSS files will be applied globally and will affect the entire application.

**2. Emulated:**
- Emulated encapsulation is the default behavior in Angular.
- With emulated encapsulation, Angular emulates the shadow DOM by adding unique attributes to the HTML elements within the component's template. 
- This ensures that the component's styles are scoped to that component's view and don't affect other components.
- Emulated encapsulation provides style isolation without relying on the browser's native shadow DOM implementation, making it compatible with a wider range of browsers.

**3. ShadowDom:**
- With shadow DOM encapsulation, Angular uses the browser's native shadow DOM to isolate the component's styles.
- Styles defined in the component's CSS files are encapsulated within the component's shadow DOM, ensuring that they don't leak out to other parts of the application and are scoped to that component's view.
- Shadow DOM encapsulation provides the most strict style isolation, but it requires support for the native shadow DOM API, which may not be available in older browsers.


  _Extra Note: Shadow DOM refers to the ability of the browser to include a subtree of
  DOM elements into the rendering of a document, but not into the main
  document DOM tree.
  The Shadow DOM is simply saying that some part of the page, has
  its own DOM within it. Styles and scripting can be scoped within that
  element so what runs in it only executes in that boundary.
  The scoped subtree is called a shadow tree.
  The element it's attached to is its shadow host._ 

Example: 
```typescript
@Component({
    template: '<p class="box"></p>',
    styles: [` .box { height: 100px; width: 100px; } `],
    encapsulation: ViewEncapsulation.ShadowDom
    // encapsulation: ViewEncapsulation.None
    // encapsulation: ViewEncapsulation.Emulated // default
})
export class AppComponent {}
```

### 9. Why prioritise `TypeScript` over `JavaScript` in Angular? / Why Use TypeScript?

- **Static Typing:** TypeScript offers static typing, which means you define the data types of variables and function parameters. 
  This allows the compiler to catch errors early in the development process, preventing runtime issues caused by incorrect data types.
- **Enhanced Tooling Support:** TypeScript provides rich tooling support with features such as code navigation, auto-completion, 
  refactoring tools, and intelligent code suggestions.
- **Modern JavaScript Features:** TypeScript allows developers to use modern JavaScript features like arrow functions, classes, modules, and async/await syntax.
- **Decorator Support:** TypeScript supports decorators, which are a powerful feature used extensively in Angular for defining metadata, 
  such as component annotations, dependency injection, routing configurations, and more.
- **Angular Framework Integration:** TypeScript is the recommended language for developing Angular applications by the Angular team. 
  As a result, the Angular framework and its ecosystem are designed with TypeScript in mind.

### 10. What do you understand By `RouterOutlet` and `RouterLink`?
#### RouterOutlet:
- RouterOutlet is a directive that acts as a placeholder in the Angular application where the routed component views will be displayed.
- It is typically used in the root component or within the template of a component to define the location where the routed component should be rendered.
- When a user navigates to a specific route, Angular's router replaces the content of the RouterOutlet with the component associated with that route.

Example:
```html
<router-outlet></router-outlet>
```

#### RouterLink:
- `RouterLink` is a directive used to create navigation links in Angular applications.
- It allows you to navigate to different routes in the application by specifying the route path as a string or an array of path segments.
- When a user clicks on an element with a `RouterLink` directive, Angular's router navigates to the specified route without reloading the entire page.

Example:
```html
<a routerLink="/home">Home</a>
<a [routerLink]="['/users', userId]">User Details</a>
```

### 11. Angular Component Constructor Vs OnInit

### 12. What happens when you use the `script` tag within a template?

### 13. What is `ViewChild` and you will want to use `{static: false}`?

### 14. Angular Lifecycle Hooks

### 15. What is `AOT` compilation? What are the advantages of `AOT`?

### 16. Explain `"sourceMap": true` in angular.

### 17. Promise vs Observable

### 18. "hot" observables vs "cold" observables

### 19. What are Template-driven forms and Reactive forms?

### 20. `forRoot` vs `forChild`

### 21. Handling Multiple http request using RxJs

### 22. `Map` vs `mergeMap` vs `switchMap` vs `concatMap` vs `exhaustMap`

### 23. What are class decorators?

### 24. What is the Component `Decorator` in Angular?

### 25. In comparison to JIT, a compilation in AOT

### 26. How to prevent `cross-site scripting` (XSS)?

### 27. How to improve website performance?

### 28. Bundle Analysis

### 29. When to Use `Put` and When `Patch`?

### 30. What is purpose of the `angular.json`?

### 31. Angular 17 new features

### 32. What are some of the differences between a standard Angular component and a standalone component?

### 33. bootstrapModule

### 34. Angular testing framework: `Karma`, `Jasmine`

### 35. Can we call api from constructor as well

### 36. pre-fetch your data by using Resolvers

### 37. Explain `Guard` in angular

### 38. Host binding and Host listening

### 39. Explain `Polyfill` in Angular

### 40. Explain Router outlet in angular

### 41. Can we use multiple router outlet?

### 42. Can you write a component without constructor?

### 43. Pure pipe vs Impure pipe

### 44. Formbuilder vs Formgroup in angular