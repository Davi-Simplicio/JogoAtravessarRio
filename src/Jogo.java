import java.util.ArrayList;

public class Jogo {
    private final Objetos objetos;

    public Jogo() {
        objetos = new Objetos();
        this.objetos.jangada.setMargemDaJangada(this.objetos.margemA);
        this.objetos.margemA.margem.addAll(Personagem.getPersonagems());
    }

    public boolean verificaPrisioneiroSozinhoComFamilia() {
        Margem margemAtual = margemAtual(this.objetos.prisioneira);
        if (margemAtual != null) {
            if (!(margemAtual.margem.contains(this.objetos.policial))) {
                for (Personagem personagemE : margemAtual.margem) {
                    if (personagemE instanceof Familia) {
                        throw new PrisioneiraSozinhaComAFamiliaException();
                    }
                }
            }
        }
        return false;
    }

    private Margem margemAtual(Personagem personagem) {
        if (this.objetos.margemA.margem.contains(personagem)) {
            return this.objetos.margemA;
        } else if (this.objetos.margemB.margem.contains(personagem)) {
            return this.objetos.margemB;
        }
        return null;
    }

    public boolean verificaFilhosSozinhosComAMaeSemOPai() {
        Margem margemAtual = margemAtual(this.objetos.mae);
        if (margemAtual != null) {
            if (!(margemAtual.margem.contains(this.objetos.pai))) {
                for (Personagem personagemE : margemAtual.margem) {
                    if (personagemE instanceof Filho) {
                        throw new FilhosSozinhosComAMaeSemOPaiException();
                    }
                }
            }
        }
        return false;
    }

    public boolean verificaMaeTransportandoFilhos() {
        Jangada jangada = this.objetos.jangada;
        if (jangada.jangada.contains(this.objetos.mae) && (jangada.jangada.contains(this.objetos.filhoA) || jangada.jangada.contains(this.objetos.filhoB))) {
            throw new MaeTransportandoFilhosExcepiton();
        }
        return false;
    }

    public boolean verificaFilhasSozinhasComOPaiSemAMae() {
        Margem margemAtual = margemAtual(this.objetos.pai);
        if (margemAtual != null) {
            if (!(margemAtual.margem.contains(this.objetos.mae))) {
                for (Personagem personagemE : margemAtual.margem) {
                    if (personagemE instanceof Filha) {
                        throw new PaiSozinhoComAsFilhasSemAMaeException();
                    }
                }
            }
        }
        return false;
    }

    public boolean verificaVitoria() {
        return this.objetos.margemB.margem.size() >= 8;
    }

    public boolean verificaPaiTransportandoFilhas() {
        Jangada jangada = this.objetos.jangada;
        if (jangada.jangada.contains(this.objetos.pai) && (jangada.jangada.contains(this.objetos.filhaA) || jangada.jangada.contains(this.objetos.filhaB))) {
            throw new PaiTransportandoFilhasException();
        }
        return false;
    }

    public boolean atravessar() throws PersonagemNaoExisteException, NaoPodeAtravessarException {
        if (vereficaJogo()) {
            Jangada jangada = this.objetos.jangada;
            if (jangada.jangada.contains(this.objetos.mae) || jangada.jangada.contains(this.objetos.pai) || jangada.jangada.contains(this.objetos.policial)) {
                if (jangada.getMargemDaJangada() == this.objetos.margemA) {
                    jangada.setMargemDaJangada(this.objetos.margemB);
                } else {
                    jangada.setMargemDaJangada(this.objetos.margemA);
                }
                jangada.getMargemDaJangada().adicionar(jangada.jangada);
                jangada.remover(jangada.jangada);
                return verificaVitoria();
            }
            throw new NaoPodeAtravessarException();
        }
        return false;
    }

    public boolean vereficaJogo() {
        verificaFilhasSozinhasComOPaiSemAMae();
        verificaFilhosSozinhosComAMaeSemOPai();
        verificaPrisioneiroSozinhoComFamilia();
        verificaMaeTransportandoFilhos();
        verificaPaiTransportandoFilhas();
        return true;

    }

    public void tiraDaJangadaColocaNaMargem(Personagem personagem) throws PersonagemNaoExisteException {
        System.out.println(personagem);
        this.objetos.jangada.remover(personagem);
        this.objetos.jangada.getMargemDaJangada().adicionar(personagem);
    }

    public void tiraDaMargemColocaNaJangada(Personagem personagem) throws PersonagemNaoExisteException, JangadaCheiaException {
        this.objetos.jangada.adicionar(personagem);
        this.objetos.jangada.getMargemDaJangada().remover(personagem);
    }

    public ArrayList<Personagem> mostrarMargemA() {
        return this.objetos.margemA.mostrarMargem();
    }

    public ArrayList<Personagem> mostrarMargemB() {
        return this.objetos.margemB.mostrarMargem();
    }

    public ArrayList<Personagem> mostrarMargemAtual() {
        return this.objetos.jangada.getMargemDaJangada().mostrarMargem();
    }

    public ArrayList<Personagem> mostrarJangada() {
        return this.objetos.jangada.jangada;
    }

    public Personagem procurarPersonagemNaMargem(int numero) throws PersonagemNaoExisteException {
        for (Personagem personagemE : this.objetos.jangada.getMargemDaJangada().margem) {
            if (personagemE.getId() == numero) {
                return personagemE;
            }
        }
        throw new PersonagemNaoExisteException();
    }
    public Personagem procurarPersonagemNaJangada(int numero) throws PersonagemNaoExisteException {
        for (Personagem personagemE : this.objetos.jangada.jangada) {
            if (personagemE.getId() == numero) {
                return personagemE;
            }
        }
        throw new PersonagemNaoExisteException();
    }
}
