import java.util.ArrayList;

public class Jangada implements IAdicionar, IRemover {
    ArrayList<Personagem> jangada = new ArrayList<>();
    private Margem margemDaJangada;

    public Jangada() {
        margemDaJangada = new Margem();
    }

    @Override
    public Personagem adicionar(Personagem personagem) throws JangadaCheiaException, PersonagemNaoExisteException {
        if (personagem != null) {
            if (this.jangada.size() <= 2) {
                this.jangada.add(personagem);
                return personagem;
            } else {
                throw new JangadaCheiaException();
            }
        }
        throw new PersonagemNaoExisteException();
    }

    @Override
    public void remover(Personagem personagem) throws PersonagemNaoExisteException {
        if (personagem != null) {
            this.jangada.remove(personagem);
            return;
        }
        throw new PersonagemNaoExisteException();
    }

    public void remover(ArrayList<Personagem>personagens) throws PersonagemNaoExisteException {
        if (personagens != null) {
            this.jangada.removeAll(personagens);
            return;
        }
        throw new PersonagemNaoExisteException();
    }

    public Margem getMargemDaJangada() {
        return margemDaJangada;
    }

    public void setMargemDaJangada(Margem margemDaJangada) {
        this.margemDaJangada = margemDaJangada;
    }
}


