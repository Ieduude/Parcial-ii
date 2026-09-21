import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        HashSet<String> placasRegistradas = new HashSet<>();
        HashMap<String, Double> totalesPorTipo = new HashMap<>();

        int opcion = 0;

        do {

            System.out.println("\n================================");
            System.out.println("      ESTACIONAMIENTO");
            System.out.println("================================");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Mostrar todos los vehículos");
            System.out.println("3. Buscar vehículo por placa");
            System.out.println("4. Mostrar vehículo con mayor costo");
            System.out.println("5. Mostrar total general recaudado");
            System.out.println("6. Mostrar total recaudado por tipo");
            System.out.println("7. Salir");
            System.out.println("================================");

            try {

                System.out.print("Seleccione una opción: ");
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {

                    // =========================================
                    // 1. REGISTRAR VEHÍCULO
                    // =========================================

                    case 1:

                        System.out.println("\n===== REGISTRAR VEHÍCULO =====");

                        System.out.print("Ingrese la placa: ");
                        String placa = teclado.nextLine().trim();

                        if (placa.isEmpty()) {
                            System.out.println("La placa no puede estar vacía.");
                            break;
                        }

                        if (placasRegistradas.contains(placa)) {
                            System.out.println(
                                    "Error: ya existe un vehículo registrado con esa placa."
                            );
                            break;
                        }

                        System.out.print("Ingrese el propietario: ");
                        String propietario = teclado.nextLine().trim();

                        if (propietario.isEmpty()) {
                            System.out.println(
                                    "El propietario no puede estar vacío."
                            );
                            break;
                        }

                        System.out.print("Ingrese la hora de ingreso: ");
                        String horaIngreso = teclado.nextLine().trim();

                        if (horaIngreso.isEmpty()) {
                            System.out.println(
                                    "La hora de ingreso no puede estar vacía."
                            );
                            break;
                        }

                        int horasUtilizadas;

                        try {

                            System.out.print("Ingrese las horas utilizadas: ");
                            horasUtilizadas = teclado.nextInt();
                            teclado.nextLine();

                            if (horasUtilizadas <= 0) {
                                System.out.println(
                                        "Las horas utilizadas deben ser mayores que cero."
                                );
                                break;
                            }

                        } catch (Exception e) {

                            System.out.println(
                                    "Error: debe ingresar un número entero para las horas."
                            );

                            teclado.nextLine();
                            break;

                        } finally {

                            System.out.println(
                                    "Proceso de lectura de horas finalizado."
                            );
                        }

                        System.out.println("\nTipo de vehículo:");
                        System.out.println("1. Automóvil");
                        System.out.println("2. Motocicleta");

                        int tipo;

                        try {

                            System.out.print("Seleccione el tipo: ");
                            tipo = teclado.nextInt();
                            teclado.nextLine();

                        } catch (Exception e) {

                            System.out.println(
                                    "Error: debe ingresar 1 o 2."
                            );

                            teclado.nextLine();
                            break;

                        } finally {

                            System.out.println(
                                    "Proceso de selección de tipo finalizado."
                            );
                        }

                        Vehiculo vehiculo;

                        if (tipo == 1) {

                            vehiculo = new Automovil(
                                    placa,
                                    propietario,
                                    horaIngreso,
                                    horasUtilizadas
                            );

                        } else if (tipo == 2) {

                            vehiculo = new Motocicleta(
                                    placa,
                                    propietario,
                                    horaIngreso,
                                    horasUtilizadas
                            );

                        } else {

                            System.out.println(
                                    "Tipo de vehículo inválido."
                            );

                            break;
                        }

                        vehiculos.add(vehiculo);
                        placasRegistradas.add(placa);

                        System.out.println(
                                "\nVehículo registrado correctamente."
                        );

                        System.out.printf(
                                "Costo calculado: Q%.2f%n",
                                vehiculo.calcularCosto()
                        );

                        break;

                    // =========================================
                    // 2. MOSTRAR TODOS LOS VEHÍCULOS
                    // =========================================

                    case 2:

                        System.out.println(
                                "\n===== VEHÍCULOS REGISTRADOS ====="
                        );

                        if (vehiculos.isEmpty()) {

                            System.out.println(
                                    "No hay vehículos registrados."
                            );

                            break;
                        }

                        for (Vehiculo v : vehiculos) {

                            v.mostrarInformacion();

                            if (v instanceof Automovil) {

                                System.out.println(
                                        "Tipo: Automóvil"
                                );

                            } else if (v instanceof Motocicleta) {

                                System.out.println(
                                        "Tipo: Motocicleta"
                                );
                            }

                            System.out.printf(
                                    "Costo: Q%.2f%n",
                                    v.calcularCosto()
                            );

                            System.out.println(
                                    "-------------------------------"
                            );
                        }

                        break;

                    // =========================================
                    // 3. BUSCAR POR PLACA
                    // =========================================

                    case 3:

                        System.out.println(
                                "\n===== BUSCAR VEHÍCULO ====="
                        );

                        System.out.print("Ingrese la placa: ");
                        String placaBuscar = teclado.nextLine().trim();

                        if (placaBuscar.isEmpty()) {

                            System.out.println(
                                    "La placa no puede estar vacía."
                            );

                            break;
                        }

                        boolean encontrado = false;

                        for (Vehiculo v : vehiculos) {

                            if (v.getPlaca().equalsIgnoreCase(placaBuscar)) {

                                v.mostrarInformacion();

                                if (v instanceof Automovil) {

                                    System.out.println(
                                            "Tipo: Automóvil"
                                    );

                                } else if (v instanceof Motocicleta) {

                                    System.out.println(
                                            "Tipo: Motocicleta"
                                    );
                                }

                                System.out.printf(
                                        "Costo: Q%.2f%n",
                                        v.calcularCosto()
                                );

                                encontrado = true;

                                break;
                            }
                        }

                        if (!encontrado) {

                            System.out.println(
                                    "No se encontró un vehículo con esa placa."
                            );
                        }

                        break;

                    // =========================================
                    // 4. MAYOR COSTO
                    // =========================================

                    case 4:

                        System.out.println(
                                "\n===== VEHÍCULO CON MAYOR COSTO ====="
                        );

                        if (vehiculos.isEmpty()) {

                            System.out.println(
                                    "No hay vehículos registrados."
                            );

                            break;
                        }

                        Vehiculo mayorCosto = vehiculos.get(0);

                        for (Vehiculo v : vehiculos) {

                            if (v.calcularCosto()
                                    > mayorCosto.calcularCosto()) {

                                mayorCosto = v;
                            }
                        }

                        mayorCosto.mostrarInformacion();

                        if (mayorCosto instanceof Automovil) {

                            System.out.println(
                                    "Tipo: Automóvil"
                            );

                        } else if (mayorCosto instanceof Motocicleta) {

                            System.out.println(
                                    "Tipo: Motocicleta"
                            );
                        }

                        System.out.printf(
                                "Costo: Q%.2f%n",
                                mayorCosto.calcularCosto()
                        );

                        break;

                    // =========================================
                    // 5. TOTAL GENERAL
                    // =========================================

                    case 5:

                        System.out.println(
                                "\n===== TOTAL GENERAL RECAUDADO ====="
                        );

                        double totalGeneral = 0;

                        for (Vehiculo v : vehiculos) {

                            totalGeneral += v.calcularCosto();
                        }

                        System.out.printf(
                                "Total recaudado: Q%.2f%n",
                                totalGeneral
                        );

                        break;

                    // =========================================
                    // 6. TOTAL POR TIPO
                    // =========================================

                    case 6:

                        System.out.println(
                                "\n===== TOTAL RECAUDADO POR TIPO ====="
                        );

                        double totalAutomoviles = 0;
                        double totalMotocicletas = 0;

                        for (Vehiculo v : vehiculos) {

                            if (v instanceof Automovil) {

                                totalAutomoviles +=
                                        v.calcularCosto();

                            } else if (v instanceof Motocicleta) {

                                totalMotocicletas +=
                                        v.calcularCosto();
                            }
                        }

                        totalesPorTipo.clear();

                        totalesPorTipo.put(
                                "Automóvil",
                                totalAutomoviles
                        );

                        totalesPorTipo.put(
                                "Motocicleta",
                                totalMotocicletas
                        );

                        for (String tipoVehiculo
                                : totalesPorTipo.keySet()) {

                            System.out.printf(
                                    "%s: Q%.2f%n",
                                    tipoVehiculo,
                                    totalesPorTipo.get(tipoVehiculo)
                            );
                        }

                        break;

                    // =========================================
                    // 7. SALIR
                    // =========================================

                    case 7:

                        System.out.println(
                                "\nGracias por utilizar el sistema."
                        );

                        break;

                    // =========================================
                    // OPCIÓN INVÁLIDA
                    // =========================================

                    default:

                        System.out.println(
                                "Opción inválida. Seleccione del 1 al 7."
                        );
                }

            } catch (Exception e) {

                System.out.println(
                        "Error: debe ingresar un número válido."
                );

                teclado.nextLine();

            } finally {

                System.out.println(
                        "Operación del menú finalizada."
                );
            }

        } while (opcion != 7);

        teclado.close();
    }
}