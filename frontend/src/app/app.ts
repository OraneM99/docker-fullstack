import { Component, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

interface Car {
  id?: number;
  brand: string;
  model: string;
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  private readonly http = inject(HttpClient);

  cars: Car[] = [];

  brand = '';
  model = '';

  constructor() {
    this.loadCars();
  }

  loadCars(): void {
    this.http.get<Car[]>('/api/cars').subscribe({
      next: cars => this.cars = cars,
      error: error => console.error('Erreur API :', error)
    });
  }

  addCar(): void {
    if (!this.brand || !this.model) {
      return;
    }

    const car: Car = {
      brand: this.brand,
      model: this.model
    };

    this.http.post<Car>('/api/cars', car).subscribe({
      next: () => {
        this.brand = '';
        this.model = '';
        this.loadCars();
      },
      error: error => console.error('Erreur API :', error)
    });
  }
}