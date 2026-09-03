import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        // ========================================
        // ARRAY DE CLIENTES
        // ========================================

        Banco[] clientes = new Banco[10];


        // ========================================
        // CLIENTES INICIALES
        // ========================================

        clientes[0] = new Banco("Hugo", 10, 1);
        clientes[1] = new Banco("Laura", 500, 2);
        clientes[2] = new Banco("Tomasa", 1000, 3);
        clientes[3] = new Banco("Corey", 750, 4);
        clientes[4] = new Banco("Yaretzi", 250, 5);


        int opcion = 0;


        // ========================================
        // MENÚ PRINCIPAL
        // ========================================

        while (opcion != 8) {

            System.out.println("""
                    
                    ╔══════════════════════════════════╗
                    ║          🏦 BANCO HUGO           ║
                    ╠══════════════════════════════════╣
                    ║                                  ║
                    ║  1. Ver clientes                 ║
                    ║  2. Crear cliente                ║
                    ║  3. Depositar                    ║
                    ║  4. Retirar                      ║
                    ║  5. Consultar saldo              ║
                    ║  6. Transferir dinero            ║
                    ║  7. Eliminar cliente             ║
                    ║  8. Salir                        ║
                    ║                                  ║
                    ╚══════════════════════════════════╝
                    """);

            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();


            // ====================================
            // SWITCH
            // ====================================

            switch (opcion) {


                // =================================
                // 1. VER CLIENTES
                // =================================

                case 1:

                    System.out.println("\n========== CLIENTES ==========");

                    for (int i = 0; i < clientes.length; i++) {

                        if (clientes[i] != null) {

                            System.out.println(
                                    "Cuenta: " +
                                            clientes[i].getNoCuenta() +
                                            " | Titular: " +
                                            clientes[i].getTitular() +
                                            " | Saldo: $" +
                                            clientes[i].getSaldo()
                            );
                        }
                    }

                    break;


                // =================================
                // 2. CREAR CLIENTE
                // =================================

                case 2:

                    crearCliente(clientes, scanner);

                    break;


                // =================================
                // 3. DEPOSITAR
                // =================================

                case 3:

                    System.out.print("Número de cuenta: ");
                    int cuentaDeposito = scanner.nextInt();

                    Banco clienteDeposito =
                            buscarCliente(clientes, cuentaDeposito);


                    if (clienteDeposito != null) {

                        System.out.print("Cantidad a depositar: ");
                        double cantidad = scanner.nextDouble();

                        clienteDeposito.depositar(cantidad);

                    } else {

                        System.out.println("❌ Cuenta no encontrada.");
                    }

                    break;


                // =================================
                // 4. RETIRAR
                // =================================

                case 4:

                    System.out.print("Número de cuenta: ");
                    int cuentaRetiro = scanner.nextInt();

                    Banco clienteRetiro =
                            buscarCliente(clientes, cuentaRetiro);


                    if (clienteRetiro != null) {

                        System.out.print("Cantidad a retirar: ");
                        double cantidad = scanner.nextDouble();


                        boolean retiro =
                                clienteRetiro.retirar(cantidad);


                        if (retiro) {

                            System.out.println(
                                    "Retiro realizado correctamente."
                            );

                            System.out.println(
                                    "Nuevo saldo: $" +
                                            clienteRetiro.getSaldo()
                            );

                        } else {

                            System.out.println(
                                    "❌ No tienes saldo suficiente."
                            );
                        }

                    } else {

                        System.out.println("❌ Cuenta no encontrada.");
                    }

                    break;


                // =================================
                // 5. CONSULTAR SALDO
                // =================================

                case 5:

                    System.out.print("Número de cuenta: ");
                    int cuentaConsulta = scanner.nextInt();


                    Banco clienteConsulta =
                            buscarCliente(clientes, cuentaConsulta);


                    if (clienteConsulta != null) {

                        clienteConsulta.consultar();

                    } else {

                        System.out.println(
                                "❌ Cuenta no encontrada."
                        );
                    }

                    break;


                // =================================
                // 6. TRANSFERIR
                // =================================

                case 6:

                    System.out.print(
                            "Número de cuenta origen: "
                    );

                    int cuentaOrigen = scanner.nextInt();


                    System.out.print(
                            "Número de cuenta destino: "
                    );

                    int cuentaDestino = scanner.nextInt();


                    // Buscar origen
                    Banco origen =
                            buscarCliente(clientes, cuentaOrigen);


                    // Buscar destino
                    Banco destino =
                            buscarCliente(clientes, cuentaDestino);


                    if (origen == null) {

                        System.out.println(
                                "❌ La cuenta origen no existe."
                        );

                    } else if (destino == null) {

                        System.out.println(
                                "❌ La cuenta destino no existe."
                        );

                    } else if (origen == destino) {

                        System.out.println(
                                "❌ No puedes transferirte a ti mismo."
                        );

                    } else {

                        System.out.print(
                                "Cantidad a transferir: "
                        );

                        double cantidad =
                                scanner.nextDouble();


                        boolean retiro =
                                origen.retirar(cantidad);


                        if (retiro) {

                            destino.depositar(cantidad);

                            System.out.println(
                                    "✅ Transferencia realizada."
                            );

                            System.out.println(
                                    "Saldo de " +
                                            origen.getTitular() +
                                            ": $" +
                                            origen.getSaldo()
                            );

                            System.out.println(
                                    "Saldo de " +
                                            destino.getTitular() +
                                            ": $" +
                                            destino.getSaldo()
                            );

                        } else {

                            System.out.println(
                                    "❌ El cliente no tiene suficiente saldo."
                            );
                        }
                    }

                    break;


                // =================================
                // 7. ELIMINAR CLIENTE
                // =================================

                case 7:

                    System.out.print(
                            "Número de cuenta a eliminar: "
                    );

                    int cuentaEliminar =
                            scanner.nextInt();


                    boolean eliminado =
                            eliminarCliente(
                                    clientes,
                                    cuentaEliminar
                            );


                    if (eliminado) {

                        System.out.println(
                                "✅ Cliente eliminado correctamente."
                        );

                    } else {

                        System.out.println(
                                "❌ Cuenta no encontrada."
                        );
                    }

                    break;


                // =================================
                // 8. SALIR
                // =================================

                case 8:

                    System.out.println("""
                            
                            ==================================
                            Gracias por utilizar Banco Hugo 🏦
                            ¡Hasta pronto!
                            ==================================
                            """);

                    break;


                // =================================
                // OPCIÓN INCORRECTA
                // =================================

                default:

                    System.out.println(
                            "❌ Opción no válida."
                    );
            }
        }

        scanner.close();
    }


    // ==================================================
    // MÉTODO PARA CREAR CLIENTE
    // ==================================================

    public static void crearCliente(
            Banco[] clientes,
            Scanner scanner) {


        // Buscar espacio vacío
        for (int i = 0; i < clientes.length; i++) {

            if (clientes[i] == null) {

                scanner.nextLine();

                System.out.print(
                        "Nombre del nuevo cliente: "
                );

                String nombre =
                        scanner.nextLine();


                System.out.print(
                        "Saldo inicial: "
                );

                double saldo =
                        scanner.nextDouble();


                if (saldo < 0) {

                    System.out.println(
                            "❌ El saldo no puede ser negativo."
                    );

                    return;
                }


                // Número de cuenta
                int numeroCuenta = i + 1;


                // Crear objeto
                clientes[i] =
                        new Banco(
                                nombre,
                                saldo,
                                numeroCuenta
                        );


                System.out.println(
                        "\n✅ Cliente creado correctamente."
                );

                System.out.println(
                        "Titular: " +
                                nombre
                );

                System.out.println(
                        "Número de cuenta: " +
                                numeroCuenta
                );

                return;
            }
        }


        // Si no encontró espacio
        System.out.println(
                "❌ No hay espacio para más clientes."
        );
    }


    // ==================================================
    // MÉTODO BUSCAR CLIENTE
    // ==================================================

    public static Banco buscarCliente(
            Banco[] clientes,
            int numeroCuenta) {


        for (int i = 0; i < clientes.length; i++) {

            if (
                    clientes[i] != null &&
                            clientes[i].getNoCuenta() == numeroCuenta
            ) {

                return clientes[i];
            }
        }


        return null;
    }


    // ==================================================
    // MÉTODO ELIMINAR CLIENTE
    // ==================================================

    public static boolean eliminarCliente(
            Banco[] clientes,
            int numeroCuenta) {


        for (int i = 0; i < clientes.length; i++) {

            if (
                    clientes[i] != null &&
                            clientes[i].getNoCuenta() == numeroCuenta
            ) {

                clientes[i] = null;

                return true;
            }
        }


        return false;
    }
}