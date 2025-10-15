public class Frazione implements Operando {
    private int numeratore;
    private int denominatore;

    public Frazione(){  //costruttore default
        numeratore=0;
        denominatore=1;
    }

//costruttore con parametri
    public Frazione(int n,int d)throws EccezioneDenominatoreNullo{
        if(d==0){
            throw new EccezioneDenominatoreNullo();
        }
        if(d<0){
            n=-n;
            d=-d;
        }
        numeratore = n;
        denominatore = d;
    }
    @Override
    public void stampa() {
     System.out.println(toString());
    }

    public String toString(){
        return "La frazione è " + (numeratore) + "/" + (denominatore) + "\n(valore reale di essa : " + (calcola()) +")";
    }

    @Override
    public double calcola() {
        return (double)numeratore/denominatore;
    }
//somma
    public Frazione add(Frazione f) throws EccezioneDenominatoreNullo {
        int n = numeratore * f.denominatore + f.numeratore * denominatore;
        int d = denominatore * f.denominatore;
        return new Frazione(n, d).semplifica();
    }
    //sottrazione
    public Frazione sub(Frazione f)throws EccezioneDenominatoreNullo {
        int n=numeratore * f.denominatore - f.numeratore * denominatore;
        int d = denominatore * f.denominatore;
        return new Frazione(n, d).semplifica();
    }
    //moltiplicazione
    public Frazione mul(Frazione f) throws EccezioneDenominatoreNullo{
        int n = numeratore * f.numeratore;
        int d = denominatore * f.denominatore;
        return new Frazione(n, d).semplifica();
    }
//divisione
    public Frazione div(Frazione f) throws EccezioneDenominatoreNullo {
        if(f.numeratore == 0){ // controllo se la frazione da dividere è zero
            throw new EccezioneDenominatoreNullo();
        }
        int n = numeratore * f.denominatore;
        int d = denominatore * f.numeratore;
        return new Frazione(n, d).semplifica();
    }
 //per avere il valore minimo della frazione, lo uso in ogni occasione perche si
    public Frazione semplifica() throws EccezioneDenominatoreNullo{if(numeratore==0){
        throw new EccezioneDenominatoreNullo();
    }
        int a = Math.abs(numeratore);
        int b = Math.abs(denominatore);
        int mcd = gcd(a,b);
        return new Frazione(numeratore / mcd, denominatore / mcd);
    }


    //metodo inverti ,se il numeratore è 0 non si potrà fare
    public Frazione inv()throws  EccezioneDenominatoreNullo{
        if(numeratore==0){
            throw new EccezioneDenominatoreNullo();
        }

        return new Frazione(denominatore,numeratore);
    }
    //calcolo MCD
    private int gcd(int a,int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    }

