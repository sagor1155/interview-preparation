import {Directive, ElementRef, HostBinding, HostListener, Renderer2} from '@angular/core';

@Directive({
  selector: '[appCustomDirective]'
})
export class CustomDirective {

  @HostBinding('style.backgroundColor') background!: string;
  @HostBinding('attr.role') role!: string;
  @HostBinding('style.width.px') width!: number;
  @HostBinding('disabled') disabled!: boolean;

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
