/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ESEIT.OCP.controller;

import com.ESEIT.OCP.service.CalculadoraImpuesto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/impuestos")
public class ImpuestoController {
     private final CalculadoraImpuesto calculadora;

    public ImpuestoController(CalculadoraImpuesto calculadora) {
        this.calculadora = calculadora;
    }
    
    @GetMapping("/hola")
    public String hola(){
    return "hola mundo";
    }

    @GetMapping("/{tipo}/{monto}")
    public double calcular(@PathVariable String tipo, @PathVariable double monto) {
        return calculadora.calcular(tipo, monto);
    }
}


package com.ESEIT.OCP.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraImpuesto_OCP {
     public double calcular(String tipo, double monto) {
        if ("IVA".equalsIgnoreCase(tipo)) {
            return monto * 0.19;
        } else if ("ICA".equalsIgnoreCase(tipo)) {
            return monto * 0.10;
        } else {
            throw new IllegalArgumentException("Tipo de impuesto no soportado");
        }
    }
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ESEIT.OCP.service;

/**
 *
 * @author Jose Hember
 */
public interface Impuesto {
    public boolean aplica(String tipo);
    public double calcular(double monto);
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ESEIT.OCP.service;

import org.springframework.stereotype.Service;

@Service
public class ICAService implements Impuesto {

    @Override
    public boolean aplica(String tipo) {
        return "ICA".equalsIgnoreCase(tipo);
    }

    @Override
    public double calcular(double monto) {
        return monto * 0.10;
    }
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ESEIT.OCP.service;

import org.springframework.stereotype.Service;

@Service
public class IVAService implements Impuesto {
     @Override
    public boolean aplica(String tipo) {
        return "IVA".equalsIgnoreCase(tipo);
    }

    @Override
    public double calcular(double monto) {
        return monto * 0.19;
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ESEIT.OCP.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraImpuesto {
     private final List<Impuesto> impuestos;
     
      public CalculadoraImpuesto(List<Impuesto> impuestos) {
        this.impuestos = impuestos;
    }

    public double calcular(String tipo, double monto) {
         // 1. Creamos un Stream de la lista de impuestos
    Stream<Impuesto> streamImpuestos = impuestos.stream();

    // 2. Filtramos el stream para quedarnos solo con los impuestos que aplican
    Stream<Impuesto> impuestosFiltrados = streamImpuestos.filter(i -> i.aplica(tipo));

    // 3. Buscamos el primero que cumpla la condición
    Optional<Impuesto> impuestoEncontrado = impuestosFiltrados.findFirst();

    // 4. Verificamos si existe o lanzamos excepción
    if (impuestoEncontrado.isEmpty()) {
        throw new IllegalArgumentException("Impuesto no soportado");
    }

    // 5. Obtenemos el objeto impuesto válido
    Impuesto impuesto = impuestoEncontrado.get();

    // 6. Finalmente, calculamos el valor del impuesto
    return impuesto.calcular(monto);
    }
     
}
