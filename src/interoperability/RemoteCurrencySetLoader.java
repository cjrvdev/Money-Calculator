package interoperability;

import model.CurrencySet;
import persistence.CurrencySetLoader;

public class RemoteCurrencySetLoader  implements CurrencySetLoader{

    private final CurrencySetParser parser;
    private static final String FREE_API_URL = "http://www.freecurrencyconverterapi.com/api/v2/currencies";

    public RemoteCurrencySetLoader(CurrencySetParser parser) {
        this.parser = parser;
    }
        
    @Override
    public CurrencySet load() {
        String encodeCurrencySet = new JSONHttpGet().getJsonFromUrl(FREE_API_URL);
        return parser.decodeCurrencySet(encodeCurrencySet);        
    }
    
}
