import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { HttpService } from './http-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

    response: string;

    calculateForm = this.formBuilder.group({
      number: ''
    });

    constructor(private formBuilder: FormBuilder, private httpService: HttpService) {

    }


  onSubmit(): void {
    // Process checkout data here
    const num = this.calculateForm.get('number').value;
    const obj = {brackets: num};
    this.httpService.post('/v1/brackets/calculate', obj).subscribe(data => {
      this.response = data;
      console.warn('Response: ', num);
      alert('Valid combinations: ' + this.response);
    });

  }

}
