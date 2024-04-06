# Angular

- [ ] Bootstrap sequence
- [ ] Input/Output binding
- [ ] Lifecycle hooks
- [ ] Directive & Pipes
- [ ] Testing
- [ ] Lazy loading in Angular
- [ ] Difference between `constructor` and `ngOnInit`
- [ ] Dependency Injection
- [ ] Tree-Shaking
- [ ] What are AOT and JIT? Which one is better and why?
- [ ] Ivy vs View Renderer Engine
- [ ] What are `@ViewChild` and `@ViewContent`
- [ ] Difference between interface and type
- [ ] Why don’t we use constructor for assignment?
- [ ] proxy pattern, factory
- [ ] What is signals? Why do we use it?
- [ ] What do you understand by preprocessor?
- [ ] Performance optimization in Angular.
- [ ] Why would you use reactive extensions? Talk about some operators
- [ ] Angular Ivy, Angular Elements, Standalone Components, JS Expressions, Angular Expressions, Server Side Rendering
- [ ] Differences and how to unit test, integration test, end to end test 
- [ ] Unit Testing using `Karma` and `Jasmine`

## Lazy loading in Angular

Loading modules and their associated components on-demand, rather than loading everything upfront when the application starts. It's a key strategy for optimizing performance and user experience in large-scale Angular applications.

<b>Module Configuration:</b>

Instead of directly importing modules in the root module (AppModule), you configure lazy-loaded modules in the routing configuration using the `loadChildren` property:

```typescript
const routes: Routes = [
  { path: 'users', loadChildren: () => import('./users/users.module').then(m => m.UsersModule) }
];
```

<b>On-Demand Loading:</b>

When a user navigates to a route associated with a lazy-loaded module, Angular dynamically fetches the module's code and its dependencies.
This code is fetched in separate bundles, separate from the initial application bundle.

<b>Module Initialization:</b>

Once the module's code is loaded, Angular initializes the module and its components.
This includes creating component instances, injecting dependencies, and rendering the components' views.

<b>Benefits of Lazy Loading:</b>

- Improved Initial Load Time
- Bundle Size Reduce
- Faster Subsequent Navigation
- Better Code Organization
- Optimized Code Splitting

<b>Best Practices:</b>
- Use lazy loading for feature modules that are not immediately required on application startup.
- Consider the trade-offs between lazy loading and code splitting complexity.
- Monitor network performance to ensure lazy loading is beneficial for your application.


## AOT vs JIT
Both AOT (Ahead-of-Time) and JIT (Just-in-Time) compilation are strategies used in Angular to convert your code into a format browsers can understand. 
However, they approach this conversion with different perspectives, resulting in distinct pros and cons:

### AOT (Ahead-of-Time):

**Compilation:** Code is pre-compiled during the build process, before deployment.

**Performance:**
- Faster loading times: Pre-compiled code eliminates the need for runtime compilation, leading to quicker application startup.
- Smaller bundle size: Removes the need for the compiler to be included in the application bundle, making it smaller and faster to download.
- Improved security: Static analysis during compilation can catch certain errors and vulnerabilities earlier.

**Development Experience:**
- Slower build times: Pre-compilation adds an extra step to the build process, increasing build times.
- Limited debugging: Source maps are required for debugging, and changes require rebuilding the application.

### JIT (Just-in-Time):

**Compilation:** Code is compiled just before execution, directly in the browser.

**Performance:**
- Slower startup times: Requires runtime compilation, potentially impacting initial page load.
- Larger bundle size: Includes the compiler in the application bundle, increasing download size.

**Development Experience:**
- Faster build times: No pre-compilation step needed, allowing for quicker development cycles.
- Easier debugging: Source maps are not required, and changes take effect immediately without rebuilding.

### Choosing between AOT and JIT:

- AOT is generally preferred for production environments: Its performance benefits (faster loading, smaller size) outweigh the slower build times.
- JIT is more suitable for development environments: Quicker build times and simpler debugging offer advantages during the development process.
- Hybrid approaches are also possible: Some developers use AOT for production builds and JIT for development builds.

## Ivy vs View Engine