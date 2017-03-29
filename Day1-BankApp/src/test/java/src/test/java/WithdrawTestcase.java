package src.test.java;

import static org.junit.Assert.*;

import org.cap.dao.AccountDao;
import org.cap.dto.Account;
import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.exception.InsufficientBalanceException;
import org.cap.service.AcccountService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class WithdrawTestcase {
	@Mock
	AccountDao accountDao;
	private AcccountService accountService;

	@Test
	public void test_withdraw_with_mock() throws InsufficientBalanceException {
		
		Account account=new Account();
		account.setAccountNo(1005);
		account.setAmount(10000);
		Customer customer=new Customer();
		customer.setCustName("Riya");
		customer.setCustAddress(new Address());
		account.setCustomer(customer);
		//declaration
		Mockito.when(accountDao.findAccountById(1005)).thenReturn(account);
		
		//Actual Method Call
		Account actualAccount= accountService.withdraw(1005,1000);
		
		
		Mockito.verify(accountDao).findAccountById(1005);
		
		assertEquals(9000, actualAccount.getAmount(),0.0); 
		}
	}
	
	
	
	
			
	

