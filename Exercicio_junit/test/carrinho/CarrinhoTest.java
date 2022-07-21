package carrinho;

import produto.ProdutoNaoEncontradoException;
import produto.Produto;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class CarrinhoTest
{
    private Carrinho kart;
    
    @Before
    public void inicializaCarrinho() {
        this.kart = new Carrinho();
    }
    
    @Test
    public void testVerificaCarrinhoVazio() {
        Assert.assertEquals(0L, (long)this.kart.getQtdeItems());
    }
    
    @Test
    public void testAdicionaItem() {
        final Produto product = new Produto("Prancha de cabelo", 250.0);
        this.kart.addItem(product);
        Assert.assertEquals(1L, (long)this.kart.getQtdeItems());
    }
    
    @Test
    public void testVerificaValorTotal() {
        for (int i = 1; i <= 3; ++i) {
            final double preco = 100.0 + i * 50.0;
            final Produto product = new Produto("Amazon kindle versão " + i, preco);
            this.kart.addItem(product);
        }
        Assert.assertTrue(600.0 == this.kart.getValorTotal());
    }
    
    @Test
    public void testEsvaziaCarrinho() {
        final Produto product1 = new Produto("Alexa Echo Dot", 320.0);
        final Produto product2 = new Produto("Chinelo Havaianas", 20.0);
        final Produto product3 = new Produto("Cafeteira", 400.0);
        this.kart.addItem(product1);
        this.kart.addItem(product2);
        this.kart.addItem(product3);
        Assert.assertEquals(3L, (long)this.kart.getQtdeItems());
        this.kart.esvazia();
        Assert.assertEquals(0L, (long)this.kart.getQtdeItems());
    }
    
    @Test
    public void testRemoveItem() throws ProdutoNaoEncontradoException {
        final Produto product = new Produto("Alexa Echo Dot", 320.0);
        this.kart.addItem(product);
        this.kart.removeItem(product);
        Assert.assertEquals(0L, (long)this.kart.getQtdeItems());
    }
    
    @Test
    public void testRemoveItemInexistente() {
        final Produto product = new Produto("Toalha de banho", 30.0);
        try {
            this.kart.removeItem(product);
            Assert.fail("Exceção não lançada");
        }
        catch (ProdutoNaoEncontradoException e) {
            Assert.assertEquals((Object)"Item não encontrado", (Object)e.getMessage());
        }
    }
}