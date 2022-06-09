
import io.github.mainstringargs.yahooFinance.YahooFinanceModules;
import io.github.mainstringargs.yahooFinance.YahooFinanceRequest;
import io.github.mainstringargs.yahooFinance.YahooFinanceUrlBuilder;


public 
        
        class YahooAdapter implements ServicoCotacao {

    @Override
    public Cotacao getCotacao(String codEmpresa) {

        var builder
                = new YahooFinanceUrlBuilder().modules(YahooFinanceModules.values()).symbol(codEmpresa);

        var request = new YahooFinanceRequest();
        var financeData = request.getFinanceData(request.invoke(builder));

        var financialData = financeData.getFinancialData();
        
        if (financialData == null) {
            return new Cotacao();
        }

        return new Cotacao(
                codEmpresa,
                financialData.getFinancialCurrency(),
                financialData.getCurrentPrice().getRaw().doubleValue()
        );
    }

}
