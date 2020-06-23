/**
 * This class represents a bank account whose current balance is a nonnegative
 * amount in US dollars.
 */
public class Account {

    private int balance;
	
	/**MAB: An instance for overdraft */
	private Account ParentAccount;
	
	public Account() {
		this.balance = 0;
		this.ParentAccount = null;
	}
	
	
    /** Initialize an account with the given balance. */
    public Account(int balance) {
        this.balance = balance;
		this.ParentAccount = null;
    }
	
	/**MAB: A constructor with balance, and ParentAccount balance*/
	public Account(int balance, Account ParentAccount) {
        this.balance = balance;
		this.ParentAccount = ParentAccount;
    }

    /** Deposits amount into the current account. */
    public void deposit(int amount) {
        if (amount < 0) {
            System.out.println("Cannot deposit negative amount.");
        } else {
            balance += amount;
        }
    }

    /**
     * Subtract amount from the account if possible. If subtracting amount
     * would leave a negative balance, print an error message and leave the
     * balance unchanged.
     */
    public boolean withdraw(int amount) {
        // TODO
        if (amount < 0) {
			return false;
            //System.out.println("Cannot withdraw negative amount.");
        } else if (this.balance < amount) {
			if (this.ParentAccount != null && (this.balance + this.ParentAccount.balance >= amount)) {
				this.ParentAccount.balance = this.ParentAccount.balance - amount + this.balance;
				this.balance = 0;
				return true;
			} else {
			return false;
            //System.out.println("Insufficient funds");
			}
        } else {
            this.balance -= amount;
			return true;
			
        }
    }

    /**
     * Merge account other into this account by removing all money from other
     * and depositing it into this account.
     */
    public void merge(Account other) {
        // TODO
		this.deposit(other.balance);
		other.withdraw(other.balance);
		
    }
	
	public static void main(String[] args) {
    Account christine = new Account(500);
	Account matt = new Account(100, christine);
	matt.withdraw(700);
}
}


