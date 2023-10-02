public class NaoPodeAtravessarException extends RuntimeException{
    public NaoPodeAtravessarException() {
        super("Sua jangada está vazia ou sem nenhum piloto habilitado");
    }
}
