package produto;

public class ProdutoNaoEncontradoException extends Exception{
	
	public ProdutoNaoEncontradoException() {
		super("Item n�o encontrado");
	}

}