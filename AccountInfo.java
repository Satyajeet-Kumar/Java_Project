
public class AccountInfo {
	private String accountType;
	private String accountHolderFirstName;
	private String accountHolderLastName;
	private String accountNumber;
	private String mobileNumber;
	private String govtIdNumber;
	private String otpDetails;
	private double accountBalance;
	private String userPassword;

	public AccountInfo() {
		this.accountType = null;
		this.accountHolderFirstName = null;
		this.accountHolderLastName = null;
		this.accountNumber = null;
		this.mobileNumber = null;
		this.govtIdNumber = null;
		this.otpDetails = null;
		this.accountBalance = 0;
		this.userPassword = null;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountHolderFirstName() {
		return accountHolderFirstName;
	}

	public void setAccountHolderFirstName(String accountHolderFirstName) {
		this.accountHolderFirstName = accountHolderFirstName;
	}

	public String getAccountHolderLastName() {
		return accountHolderLastName;
	}

	public void setAccountHolderLastName(String accountHolderLastName) {
		this.accountHolderLastName = accountHolderLastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGovtIdNumber() {
		return govtIdNumber;
	}

	public void setGovtIdNumber(String govtIdNumber) {
		this.govtIdNumber = govtIdNumber;
	}

	public String getOtpdetails() {
		return otpDetails;
	}

	public void setOtpdetails(String otpdetails) {
		this.otpDetails = otpdetails;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "AccountInfo [accountType=" + accountType + ", accountHolderFirstName=" + accountHolderFirstName
				+ ", accountHolderLastName=" + accountHolderLastName + ", accountNumber=" + accountNumber
				+ ", mobileNumber=" + mobileNumber + ", govtIdNumber=" + govtIdNumber + ", otpdetails=" + otpDetails
				+ ", accountBalance=" + accountBalance + ", userPassword=" + userPassword + "]";
	}

}
