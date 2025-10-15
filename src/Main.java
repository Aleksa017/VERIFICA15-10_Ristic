import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Inserisci numeratore prima frazione: ");
            int num1 = input.nextInt();
            System.out.print("Inserisci denominatore prima frazione: ");
            int denom1 = input.nextInt();
            Frazione f1 = new Frazione(num1, denom1);

            System.out.print("Inserisci numeratore seconda frazione: ");
            int num2 = input.nextInt();
            System.out.print("Inserisci denominatore seconda frazione: ");
            int denom2 = input.nextInt();
            Frazione f2 = new Frazione(num2, denom2);

            int scelta = 0;
            while (scelta != 7) {
                System.out.println("\n1.Somma");
                System.out.println("\n2.Sottrazione");
                System.out.println("\n3.Moltiplicazione");
                System.out.println("\n4.Divisione");
                System.out.println("\n5.Inversa della prima");
                System.out.println("\n6.Inversa della seconda");
                System.out.println("\n7.Esci");
                System.out.print("\nScegli una opzione: ");
                scelta = input.nextInt();

                switch (scelta) {
                    case 1-> {
                        Frazione somma = f1.add(f2);
                        System.out.println("\nSomma : " + somma);
                    }
                    case 2-> {
                        Frazione diff = f1.sub(f2);
                        System.out.println("\nSottrazione : " + diff);
                    }
                    case 3-> {
                        Frazione moltiplica = f1.mul(f2);
                        System.out.println("\nMoltiplicazione : " + moltiplica);
                    }
                    case 4-> {
                        Frazione divisione = f1.div(f2);
                        System.out.println("\nDivisione : " + divisione);
                    }
                    case 5-> {
                        Frazione inv1 = f1.inv();
                        System.out.println("Inversione prima frazione : " + inv1);
                    }
                    case 6->{
                        Frazione inv2 = f2.inv();
                        System.out.println("Inversione seconda frazione : " + inv2);
                    }
                    case 7-> {System.out.println("Uscita dal programma");
                    }
                    default ->{System.out.println("Scelta non valida");
                    }


                }
            }
        } catch (Exception e) {
System.out.println("Eccezione rilevata");
        }finally {
            input.close();
        }
    }
}