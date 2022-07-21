package calculadora;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest
{
    private Calculadora calc;
    
    @Before
    public void inicializa() {
        this.calc = new Calculadora();
    }
    
    @Test
    public void testSomaDoisNumeros() {
        final int resultadoEsperado = 11;
        final int resultado = this.calc.soma(5, 6);
        Assert.assertEquals((long)resultadoEsperado, (long)resultado);
    }
    
    @Test
    public void testSomaTresNumeros() {
        final int resultadoEsperado = 20;
        int resultado = this.calc.soma(10, 2);
        resultado = this.calc.soma(resultado, 8);
        Assert.assertEquals((long)resultadoEsperado, (long)resultado);
    }
    
    @Test
    public void testSubtraiDoisNumeros() {
        final int a = 10;
        final int b = 8;
        final int resultadoEsperado = 2;
        final int resultado = this.calc.subtracao(a, b);
        Assert.assertEquals((long)resultadoEsperado, (long)resultado);
    }
    
    @Test
    public void testMultiplicacao() {
        final int a = 5;
        final int b = 2;
        final int resultadoEsperado = 10;
        final int resultado = this.calc.multiplicacao(a, b);
        Assert.assertEquals((long)resultadoEsperado, (long)resultado);
    }
    
    @Test
    public void testDivisao() {
        final int a = 64;
        final int b = 8;
        final int resultadoEsperado = 8;
        final int resultado = this.calc.divisao(a, b);
        Assert.assertEquals((long)resultadoEsperado, (long)resultado);
    }
    
    @Test
    public void testDivisaoPorZero() {
        final int a = 50;
        try {
            final int resultado = this.calc.divisao(a, 0);
            Assert.fail("Exce\u00e7\u00e3o n\u00e3o lan\u00e7ada");
        }
        catch (ArithmeticException e) {
            Assert.assertEquals((Object)"/ by zero", (Object)e.getMessage());
        }
    }
    
    @Test
    public void testSomatorio() {
        final int n = 14;
        final int resultadoEsperado = 105;
        final int resultado = this.calc.somatoria(n);
        Assert.assertEquals((long)resultadoEsperado, (long)resultado);
    }
    
    @Test
    public void testNumeroPositivo() {
        final int n = 15;
        Assert.assertTrue(this.calc.ehPositivo(n));
    }
    
    public void testNumeroNegativo() {
        final int n = -20;
        Assert.assertFalse(this.calc.ehPositivo(n));
    }
    
    @Test
    public void testComparaNumerosIguais() {
        final int a = 10;
        final int b = 10;
        final int resultadoEsperado = 0;
        final int resultado = this.calc.compara(a, b);
        Assert.assertEquals((long)resultadoEsperado, (long)resultado);
    }
    
    @Test
    public void testComparaNumerosAMaiorQueB() {
        final int a = 20;
        final int b = 10;
        final int resultadoEsperado = 1;
        final int resultado = this.calc.compara(a, b);
        Assert.assertEquals((long)resultadoEsperado, (long)resultado);
    }
    
    @Test
    public void testComparaNumerosAMenorQueB() {
        final int a = -15;
        final int b = 10;
        final int resultadoEsperado = -1;
        final int resultado = this.calc.compara(a, b);
        Assert.assertEquals((long)resultadoEsperado, (long)resultado);
    }
}
