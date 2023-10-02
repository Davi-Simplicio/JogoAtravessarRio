import java.util.ArrayList;

public class Margem implements IAdicionar,IRemover{
    ArrayList<Personagem> margem;

    public Margem() {
        this.margem = new ArrayList<Personagem>();
    }

    @Override
    public Personagem adicionar(Personagem personagem) throws PersonagemNaoExisteException {
        if (personagem !=null){
            this.margem.add(personagem);
            return personagem;
        }
        throw new PersonagemNaoExisteException();
    }

    @Override
    public void remover(Personagem personagem) throws PersonagemNaoExisteException {
        if (personagem!=null){
            this.margem.remove(personagem);
            return;
        }
        throw new PersonagemNaoExisteException();
    }
}
