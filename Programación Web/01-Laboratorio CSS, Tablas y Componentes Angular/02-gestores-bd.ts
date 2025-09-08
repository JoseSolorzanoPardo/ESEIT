// Importamos el decorador @Component para poder definir un componente en Angular
import { Component } from '@angular/core';

// Importamos CommonModule que contiene directivas comunes como *ngFor, *ngIf
import { CommonModule } from '@angular/common';


// Definimos una interfaz que describe la estructura de un objeto GestorBD
// Cada gestor tendrá un nombre, un tipo (Relacional o No Relacional) y una licencia
interface GestorBD {
  nombre: string;
  tipo: string;
  licencia: string;
}

// Usamos el decorador @Component para indicar que esta clase será un componente Angular
@Component({
  // Nombre del selector para usar el componente en plantillas HTML
  selector: 'app-gestores-bd',

  // Módulos que este componente necesita (en este caso CommonModule para *ngFor)
  imports: [CommonModule],

  // Ruta del archivo HTML que define la vista del componente
  templateUrl: './gestores-bd.html',

  // Ruta del archivo CSS que define los estilos de este componente
  styleUrl: './gestores-bd.css'
})
export class GestoresBd {

  // Definimos un arreglo de gestores de bases de datos
  // Cada elemento sigue la estructura definida en la interfaz GestorBD
  gestores: GestorBD[] = [
    { nombre: 'MySQL', tipo: 'Relacional', licencia: 'GPL / Comercial' },
    { nombre: 'PostgreSQL', tipo: 'Relacional', licencia: 'Open Source' },
    { nombre: 'Oracle Database', tipo: 'Relacional', licencia: 'Comercial' },
    { nombre: 'SQL Server', tipo: 'Relacional', licencia: 'Comercial' },
    { nombre: 'MongoDB', tipo: 'No Relacional', licencia: 'SSPL' },
    { nombre: 'Cassandra', tipo: 'No Relacional', licencia: 'Apache License' },
    { nombre: 'Redis', tipo: 'No Relacional', licencia: 'BSD' },
    { nombre: 'Firebase Firestore', tipo: 'No Relacional', licencia: 'Comercial' }
  ];

}
