//Quandl
import com.jimmoores.quandl.*;
import com.jimmoores.quandl.classic.ClassicQuandlSession;

//AlphaVantage

import java.time.format.DateTimeFormatter;

/**
 * Classe principal que mostra como obter a cotação de empresas da bolsa de valores
 * utilizando 3 serviços diferentes: Yahoo Finance, AlphaVantage e Quandl.
 * Os métodos implementados tem o código para utilizar as bibliotecas
 * que implementam o acesso a tais serviços.
 * Mas como podem ver, o código dos 3 métodos é totalmente diferente um do outro.
 * Ou seja, a forma de usar cada uma das bibliotecas é diferente.
 * Por isso, é preciso criar um adapter para padronizar a utilização das bibliotecas
 * e permitir trocar uma pela outra sem alterar o código do projeto.
 *
 * <p>
 * Observe que os métodos {@link #cotacaoUsandoYahooFinance(String)},
 * {@link #cotacaoUsandoAlphaVantage(String)} e
 * {@link #cotacaoUsandoQuandl(String)} não estão retornando nada, pois
 * isto é apenas um exemplo.
 * Se formos usar esta implementação em uma aplicação com interface gráfica (e não console),
 * o usuário não vai ver os prints inseridos.
 * Por isso neste caso, os método pra serem úteis para qualquer tipo de app (web, mobile, desktop, console, etc),
 * precisam retornar algum dado. Se tivermos uma app web, por exemplo, podemos então pegar estes dados e exibir
 * em uma página HTML.
 * Como você irá remodelar o código para aplicar o projeto, você precisa fazer estas alterações.
 * </p>
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        
        ServicoCotacao servico = new YahooAdapter();
        System.out.println(servico.getCotacao("MGLU3.SA"));
        
        
        ServicoCotacao servico2 = new AlphaVantageAdapter();
        System.out.println(servico2.getCotacao("MGLU3.SA"));
        
        //cotacaoUsandoYahooFinance("MGLU3.SA"); //MGLU3 = Magazine Luiza
        //cotacaoUsandoAlphaVantage("INTL"); //INTL = Intel
        //cotacaoUsandoQuandl("WIKI/AAPL"); //AAPL = Apple
    }

   

    
    
    private static void cotacaoUsandoQuandl(String codigoEmpresa) {
        System.out.printf("Cotação da Empresa %s pelo serviço Quandl: http://quandl.com/%n", codigoEmpresa);
        var session = ClassicQuandlSession.create();
        var request = DataSetRequest.Builder
                                        .of(codigoEmpresa)
                                        .withMaxRows(1)
                                        .build();
        var tabularResult = session.getDataSet(request);
        if (tabularResult.size() == 0)
            System.err.printf("Não foi possível obter a cotação para a empresa %s%n", codigoEmpresa);
        else {
            Row row = tabularResult.get(0);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String date = formatter.format(row.getLocalDate("Date"));
            System.out.printf("Data: %s Preço: %s%n", date, row.getDouble("Close"));
            //System.out.println(result.toPrettyPrintedString());
        }
        System.out.println("---------------------------------------------------------------------------------");
    }
}
