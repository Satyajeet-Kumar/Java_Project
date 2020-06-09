
public class Display {
	public void walletGreetingMessage() {
		System.out.println();
		System.out.println("\t\t******************************************");
		System.out.println("\t\tDigital Wallet - A Contactless Payment App");
		System.out.println("\t\t******************************************");
	}

	public void walletMainMenu() {
		walletGreetingMessage();
		System.out.println();
		System.out.println("\t**********************************************************");
		System.out.println("\t\tDigital Wallet - Sign Up/Sign In");
		System.out.println("\t**********************************************************");
		System.out.println();
		System.out.println("\t1. New User, Sign Up");
		System.out.println("\t2. Existing User, Sign In");
		System.out.println("\t0. To Exit Application");
		System.out.println();
		System.out.print("\tEnter Your Choice : ");
	}

	public void walletSignInMenu(String accountType, String accountHolderFirstName, String accountHolderLastName,
			double accountBalance) {
		System.out.println();
		System.out.println("\t**********************************************************");
		System.out.println("\t\t\tDigital Wallet - Logged In");
		System.out.println("\t**********************************************************");
		walletBasicAccountInfo(accountType, accountHolderFirstName, accountHolderLastName, accountBalance);
		System.out.println();
		System.out.println("\t1. Detailed Account Information");
		System.out.println("\t2. Add Money to Digital Balance");
		System.out.println("\t3. Pay to Person/Merchant");
		System.out.println("\t4. Logout");
		System.out.println("\t0. To Exit Application");
		System.out.println();
		System.out.print("\tEnter Your Choice : ");
	}

	public void walletPayMenu(double accountBalance) {
		walletGreetingMessage();
		System.out.println();
		System.out.println("\t**********************************************************");
		System.out.println("\t\t\tDigital Wallet - Payment");
		System.out.println("\t**********************************************************");
		System.out.println();
		System.out.println("\tAvailable Wallet Balance : " + accountBalance + " INR.");
		System.out.println();
		System.out.print("\tEnter Payee Mobile Number : ");
	}

	public void walletSignedUpSuccess() {
		System.out.println();
		System.out.println("\tWallet Registered Successfully. Please Sign In to Use Wallet.");
		System.out.println("\n\tPress Return...");
	}

	public void walletSignedUpFail() {
		System.out.println();
		System.out.println("\tWallet Registration Failed.");
	}

	public void walletSignedInSuccess() {
		System.out.println();
		System.out.println("\tAuthentication Successful!!!. Enjoy Using Digital Wallet Service.");
		System.out.println("\n\tPress Return...");
	}

	public void walletSignedOutMessage() {
		System.out.println();
		System.out.println("\tYou Have Logout Successfully.\n\n\tThanks For Using Digital Wallet. See You Next Time.");
		System.out.println("\n\tPress Return...");
	}

	public void walletExitMessage() {
		System.out.println();
		System.out.println("\tThanks For Using Digital Wallet. See You Next Time.");
	}

	public void walletAccountType() {
		System.out.println();
		System.out.print("\tAre You a Merchant(Y/N) : ");
	}

	public void walletUserFirstName() {
		System.out.println();
		System.out.print("\tEnter Your First Name :");
	}

	public void walletUserLastName() {
		System.out.println();
		System.out.print("\tEnter Your Last Name : ");
	}

	public void walletAccountNumber() {
		System.out.println();
		System.out.print("\tEnter Your Bank Account Number : ");
	}

	public void walletMobileNumber() {
		System.out.println();
		System.out.print("\tEnter Your 10 Digits Mobile Number : ");
	}

	public void walletGovtIdNumber() {
		System.out.println();
		System.out.print("\tEnter Govt.Id Number : ");
	}

	public void walletUserPassword() {
		System.out.println();
		System.out.print("\tPlease Enter Your Password : ");
	}

	public void walletUserConfirmPassword() {
		System.out.println();
		System.out.print("\tPlease Confirm Your Password : ");
	}

	public void walletOtpMessage() {
		System.out.println();
		System.out.print("\tPlease Enter The Recieved OTP : ");
	}

	public void walletAccountInfo(String accountType, String accountHolderFirstName, String accountHolderLastName,
			String accountNumber, String mobileNumber, String govtIdNumber, double accountBalance,
			String userPassword) {
		System.out.println();
		System.out.println("\tAccount Info : ");
		System.out.println("\t***************");
		System.out.println("\n\tAccount Type : " + accountType + "\t\tFirst Name : " + accountHolderFirstName
				+ "\t\tLast Name : " + accountHolderLastName + "\n\tAccount Number : " + accountNumber
				+ "\n\tMobile Number : " + mobileNumber + "\n\tGovt. Id Number : " + govtIdNumber
				+ "\n\tWallet Balance : " + accountBalance + "\n\tPassword : XXXXXXXX");
		System.out.println("\n\tPress Return...");
	}

	public void walletBasicAccountInfo(String accountType, String accountHolderFirstName, String accountHolderLastName,
			double accountBalance) {
		System.out.println();
		System.out.println("\tProfile Info : ");
		System.out.println("\t***************");
		System.out.println("\n\tAccount Type : " + accountType + "\t\tFirst Name : " + accountHolderFirstName
				+ "\t\tLast Name : " + accountHolderLastName + "\n\tWallet Balance : " + accountBalance);
	}

	public void walletPayeeAccountInfo(String accountType, String accountHolderFirstName,
			String accountHolderLastName) {
		System.out.println();
		System.out.println("\tPayee Basic Info : ");
		System.out.println("\t***************");
		System.out.println("\n\tAccount Type : " + accountType + "\t\tFirst Name : " + accountHolderFirstName
				+ "\t\tLast Name : " + accountHolderLastName);
	}

	public void walletRegMobileNumber() {
		System.out.println();
		System.out.print("\tPlease Enter 10 Digits Registered Mobile number : ");
	}

	public void walletInvalidRegMobileNumber() {
		System.out.println();
		System.out.println("\tDigital Wallet is Not Registered!!!!");
		System.out.println("\n\tPlease Register as Person/Merchant Before Sign In. Thanks.");
	}

	public void walletBalanceAddShow(double accountBalance) {
		System.out.println();
		System.out.println("\tAvailable Wallet Balance : " + accountBalance + " INR.");
		System.out.println();
		System.out.println("\tDigital Wallet Limit : 20000 INR.");
		System.out.print("\n\tAmount to be Added : ");
	}

	public void walletUpdatedBalance(double accountBalance) {
		System.out.println();
		System.out.println("\tUpdated Wallet Balance : " + accountBalance + " INR.");
		System.out.println("\n\tPress Return...");
	}

	public void walletBalanceLimit(double accountBalance) {
		System.out.println();
		System.out.println(
				"\tWallet Limit Can't Exceed 20000 INR. You Can Add upto " + (20000 - accountBalance) + " INR.");
	}

	public void walletInvalidAccountTxn() {
		System.out.println();
		System.out.println("\tYou Can't Transfer Money to Your Own Account.");
	}

	public void walletTxnAmount() {
		System.out.println();
		System.out.print("\tAmount to be Paid : ");
	}

	public void walletTrfAmount(double payAmount) {
		System.out.println();
		System.out.println("\tMoney Paid : " + payAmount + " INR.");
	}

	public void walletInsufficientAmount() {
		System.out.println();
		System.out.println("\tYou Have Insufficient Balance to Transfer!!!");
	}

	public void walletMaxAttempt() {
		System.out.println();
		System.out.println("\tYou Have Reached the Maximum Invalid Attempts!!! Redirecting to Previous Menu...");
		System.out.println();
	}

	public void walletIncorrectPwd() {
		System.out.println();
		System.out.println("\tYou Have Entered Incorrect Password!!! Please Sign In Again.");
		System.out.println("\n\tPress Return...");
	}

	public void walletInvalidMobNumber() {
		System.out.println();
		System.out.print("\tInvalid Mobile Number!!! Please Enter a 10 Digits Valid Mobile Number : ");
	}

	public void walletInvalidAmt() {
		System.out.println();
		System.out.print("\tInvalid Amount. Please Enter a Valid Amount : ");
	}

	public void walletInvalidAccType() {
		System.out.println();
		System.out.print("\tInvalid Option!!! Please Enter Y or N : ");
	}

	public void walletInvalidFirstName() {
		System.out.println();
		System.out.print("\tInvalid First Name!!! Please Enter a Valid First Name : ");
	}

	public void walletInvalidLastName() {
		System.out.println();
		System.out.print("\tInvalid Last Name!!! Please Enter a Valid Last Name : ");
	}

	public void walletInvalidAccNumber() {
		System.out.println();
		System.out.print(
				"\tInvalid Account Number!!! Please Enter a Valid Account Number(Greater or Equal to 10 digits) : ");
	}

	public void walletInvalidGovtId() {
		System.out.println();
		System.out.print("\tInvalid Govt. Id!!! Please Enter a Valid Id :  ");
	}

	public void walletInvalidPassword() {
		System.out.println();
		System.out.print("\tInvalid Password!!! Please Enter a Valid Password : ");
	}

	public void walletPwdMismatch() {
		System.out.println();
		System.out.print("\tPassword Not Matched!!! Please Confirm Your Password : ");
	}

	public void walletInvalidOtp() {
		System.out.println();
		System.out.print("\tInvalid OTP!!! Please Enter a Valid 6 Digits OTP : ");
	}

	public void walletAlreadyExist() {
		System.out.println();
		System.out.println("\tMobile Number Already Registered. Sign Up With Other Number");
	}

	public void walletNonZeroAccNum() {
		System.out.println();
		System.out.println("\tAccount Number Can't be All '0's.");
	}
	public void walletNonZeroOtp() {
		System.out.println();
		System.out.println("\tOTP Can't be All '0's.");
	}
}