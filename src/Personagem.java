import java.util.ArrayList;

public abstract class Personagem {
    private String nome;
    private int id;
    private static ArrayList<Personagem>personagems =new ArrayList<>();
    public Personagem(String nome, int id) {
        this.nome = nome;
        this.id = id;
        personagems.add(this);
    }

    public static ArrayList<Personagem> getPersonagems() {
        return personagems;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "["+ id +"]" + nome+"\n";
    }
}
