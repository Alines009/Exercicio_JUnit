package produto;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class ProdutoTest
{
    private Produto prod;
    
    @Before
    public void inicializa() {
        this.prod = new Produto("cadeira gamer", 3000.0);
    }
    
    @Test
    public void TestVerificaNome() {
        final String nome = this.prod.getNome();
        Assert.assertEquals((Object)nome, (Object)"cadeira gamer");
    }
    
    @Test
    public void TestModificaNome() {
        final String novoNome = "Headset gamer";
        this.prod.setNome(novoNome);
        Assert.assertEquals((Object)novoNome, (Object)this.prod.getNome());
    }
    
    @Test
    public void TestVerificaPreco() {
        final double preco = this.prod.getPreco();
        Assert.assertTrue(3000.0 == preco);
    }
    
    @Test
    public void TestModificaPreco() {
        final double novoPreco = 1500.0;
        this.prod.setPreco(novoPreco);
        final double verificaPreco = this.prod.getPreco();
        Assert.assertTrue(novoPreco == verificaPreco);
    }
    
    @Test
    public void TestComparaProdutosDistintos() {
        final Produto product = new Produto("Mousepad", 250.0);
        Assert.assertFalse(this.prod.equals((Object)product));
    }
}