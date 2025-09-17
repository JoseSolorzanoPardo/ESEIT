//  Esta clase VIOLA el Principio OCP
public class CalculadoraMal {
    /*
     * Este método calcula el descuento según el tipo de cliente.
     * Tiene lógica condicional rígida (if-else) para cada tipo.
     * Si se necesita agregar un nuevo tipo (Ej: ESTUDIANTE), hay que MODIFICAR esta clase,
     * lo cual rompe el principio de "cerrado para modificación, abierto para extensión".
     */
    public double calcular(String tipo, double monto) {
        if (tipo.equals("ESTANDAR")) return monto * 0.05;
        else if (tipo.equals("PREMIUM")) return monto * 0.10;
        else if (tipo.equals("VIP")) return monto * 0.20;
        else return 0;
    }
}

//  Esta interfaz define el contrato para aplicar el principio OCP.
// Cada tipo de descuento se representará como una implementación de esta interfaz.
interface Descuento {
    double calcularDescuento(double montoTotal);
}

// Implementación concreta para clientes Estándar
//  Si se desea modificar el comportamiento, se puede extender/modificar esta clase sin tocar otras.
public class DescuentoEstandar implements Descuento {
    @Override
    public double calcularDescuento(double montoTotal) {
         return montoTotal * 0.05; // 5% de descuento
    }
}

// Implementación concreta para clientes Premium
public class DescuentoPremium implements Descuento {
    @Override
    public double calcularDescuento(double montoTotal) {
         return montoTotal * 0.10; // 10% de descuento
    }
}

// Implementación concreta para clientes VIP
public class DescuentoVIP implements Descuento {
    @Override
    public double calcularDescuento(double montoTotal) {
      return montoTotal * 0.20; // 20% de descuento
    } 
}

// Clase que representa la lógica de negocio para procesar descuentos.
//  Esta clase no depende de ninguna implementación concreta (Estandar, Premium o VIP).
// Solo conoce la interfaz Descuento, cumpliendo así el Principio de Inversión de Dependencias (DIP) también.
public class CalculadoraDescuentos {

    /*
     * Este método recibe cualquier implementación de Descuento
     * y aplica la lógica para mostrar el resultado del descuento.
     * 
     * Gracias a esto, si se agrega una nueva clase como DescuentoEstudiante,
     * no se necesita modificar esta clase.
     */
    public void procesarDescuento(Descuento descuento, double monto) {
        double valor = descuento.calcularDescuento(monto);
        System.out.println("Descuento aplicado: $" + valor);
        System.out.println("Total a pagar: $" + (monto - valor));
    }
}

// Clase principal con método main, simula un escenario donde se aplican los descuentos.
// Aquí se instancia manualmente cada tipo de descuento y se pasa a la calculadora.
public class ComEjemploOcpPlaneacion {

    /**
     * Método main para probar las implementaciones de descuento aplicando OCP.
     */
    public static void main(String[] args) {
        double monto = 1000.0;

        // Se crean distintas implementaciones de Descuento
        Descuento descuentoEstandar = new DescuentoEstandar();
        Descuento descuentoPremium = new DescuentoPremium();
        Descuento descuentoVIP = new DescuentoVIP();

        // Se instancia la calculadora que usará la estrategia de descuento inyectada
        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();

        // Se aplican los descuentos según el tipo de cliente
        System.out.println("Cliente Estándar:");
        calculadora.procesarDescuento(descuentoEstandar, monto);

        System.out.println("\nCliente Premium:");
        calculadora.procesarDescuento(descuentoPremium, monto);

        System.out.println("\nCliente VIP:");
        calculadora.procesarDescuento(descuentoVIP, monto);
    }
} 
