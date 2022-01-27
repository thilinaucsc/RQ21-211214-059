package com.example.genarateinterest.serviceImpl;

import com.example.genarateinterest.dto.AllInterest;
import com.example.genarateinterest.dto.CommonRequest;
import com.example.genarateinterest.dto.InterestData;
import com.example.genarateinterest.entity.Account;
import com.example.genarateinterest.entity.Customer;
import com.example.genarateinterest.entity.Transaction;
import com.example.genarateinterest.repository.AccountRepository;
import com.example.genarateinterest.repository.CustomerRepository;
import com.example.genarateinterest.repository.TransactionRepository;
import com.example.genarateinterest.service.MainService;
import com.example.genarateinterest.util.Convert;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.genarateinterest.util.Constant.RATE;

@Service
public class MainServiceImpl implements MainService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;
    private final Convert convert = new Convert();

    public MainServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public AllInterest getAllInterest() {
        Optional<List<Account>> optionalAccountList = accountRepository.getAllByTerminatedDateIsNull();
        String accountBalance = "0";
        if(optionalAccountList.isPresent()) {
            for (Account a : optionalAccountList.get()) {
                accountBalance = convert.stringAdd(accountBalance, a.getBalance());
            }
        }
        return new AllInterest(generateInterest(accountBalance, "1"));
    }

    @Override
    public List<AllInterest> getCustomerInterest(CommonRequest commonRequest) {
        List<AllInterest> allInterests = new ArrayList<>();
        Optional<Customer> customerOptional = customerRepository.findById(Long.valueOf(commonRequest.getCustomerId()));
        String accountBalance = "0";
        if(customerOptional.isPresent()) {
            Optional<List<Account>> optionalAccountList =
                    accountRepository.getAllByTerminatedDateIsNullAndAccountNoAndCustomer(commonRequest.getAccountNo(),
                            customerOptional.get());
            if(optionalAccountList.isPresent()) {
                for (Account a : optionalAccountList.get()) {
                    accountBalance = convert.stringAdd(accountBalance, a.getBalance());
                    allInterests.add(new AllInterest(generateInterest(accountBalance, "1"), a.getAccountNo()));
                }
            }
        }
        return allInterests;
    }

    @Override
    public List<InterestData> getLast10Interest(CommonRequest commonRequest) {
        List<InterestData> interestData = new ArrayList<>();
        Optional<List<Transaction>> optionalTransactions = transactionRepository.findFirst10ByAccount_AccountNoAndAccount_Customer_Id(commonRequest.getAccountNo(), Integer.parseInt(commonRequest.getCustomerId()));
        if(optionalTransactions.isPresent()) {
            for (Transaction transaction: optionalTransactions.get()) {
                interestData.add(new InterestData(transaction.getTransactionAmount(), transaction.getCreatedDate().toString(), transaction.getTransactionType()));
            }
        }
        return interestData;
    }

    private String generateInterest(String principal, String days) {
//        Simple Interest = (P × R × T)/100

//        P is the Principal amount.
//        R is the rate per annum.
//        T is time in years.
        return convert.stringDivide(convert.stringMultiply(convert.stringMultiply(principal, RATE),
                convert.stringDivide(days, "365")), "100");
    }
}
