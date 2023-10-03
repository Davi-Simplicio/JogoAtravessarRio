public class Objetos {
    Filha filhaA;
    Filha filhaB;
    Filho filhoA;
    Filho filhoB;
    Mae mae;
    Pai pai;
    Policial policial;
    Prisioneira prisioneira;
    Margem margemA;
    Margem margemB;
    Jangada jangada;
    public Objetos() {
        this.filhaA = new Filha("Filha A",1);
        this.filhaB = new Filha("Filha B",2);
        this.filhoA = new Filho("Filho A",3);
        this.filhoB = new Filho("Filho B",4);
        this.mae = new Mae("Mãe",5);
        this.pai = new Pai("Pai",6);
        this.policial = new Policial("Policial",7);
        this.prisioneira = new Prisioneira("Prisioneira",8);
        this.margemA = new Margem();
        this.margemB = new Margem();
        this.jangada = new Jangada();
    }
}
