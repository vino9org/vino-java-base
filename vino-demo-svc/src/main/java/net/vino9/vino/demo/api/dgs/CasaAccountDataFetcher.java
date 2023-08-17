package net.vino9.vino.demo.api.dgs;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import net.vino9.vino.demo.generated.types.CasaAccount;

@DgsComponent
@Slf4j
public class CasaAccountDataFetcher {

    @DgsQuery(field = "CasaAccount")
    public CasaAccount getCasaAccountDetail(@InputArgument String accountId) {
        var account = new CasaAccount();
        account.setAccountId(accountId);
        account.setCustomerId("111");
        account.setCurrency("USD");
        account.setBalance(BigDecimal.valueOf(1000.00));
        return account;
    }
}

// DELETE_IF: cookiecutter.api_type != 'graphql'
