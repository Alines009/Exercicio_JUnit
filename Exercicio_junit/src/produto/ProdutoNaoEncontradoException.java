package produto;

public class ProdutoNaoEncontradoException extends Exception{
	
	public ProdutoNaoEncontradoException() {
		super("Item não encontrado");
	}

}