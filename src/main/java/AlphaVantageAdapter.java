
import io.github.mainstringargs.alphavantagescraper.AlphaVantageConnector;
import io.github.mainstringargs.alphavantagescraper.StockQuotes;
import java.time.format.DateTimeFormatter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class AlphaVantageAdapter implements ServicoCotacao {

    @Override
    public Cotacao getCotacao(String codEmpresa) {
        
       
        final String s = System.getenv("ALPHAVANTAGE_APIKEY");
        final String apiKey = s == null ? "50M3AP1K3Y" : s;
        final int timeout = 3000;
        var apiConnector = new AlphaVantageConnector(apiKey, timeout);

        //Permite obter a cotação (quotes) de ações (stocks).
        var stockQuotes = new StockQuotes(apiConnector);

     
            var response = stockQuotes.quote(codEmpresa);
            var stockQuote = response.getStockQuote();
            var dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return new Cotacao(
                    codEmpresa,
                    stockQuote.getLatestTradingDay(),
                    stockQuote.getPrice());
            
     
        
        
    }
    
}
