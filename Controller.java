import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller {
	AccountInfo accountInfo;
	Display display;
	Map<String, AccountInfo> accountHolders = new HashMap<String, AccountInfo>();
	Scanner readInput = new Scanner(System.in);

	public Controller(AccountInfo accountInfo, Display display) {
		this.accountInfo = accountInfo;
		this.display = display;
	}

	public void initController() {
		String choice = null;
		while (true) {
			display.walletMainMenu();
			choice = readInput.nextLine().trim();
			switch (choice) {
			case "0":
				display.walletExitMessage();
				System.exit(0);
			case "1":
				setUserRegistrationDetails();
				break;
			case "2":
				getUserAccountInfo();
				break;
			default:
				System.out.println();
				System.out.println("\tInvalid Choice. Please Enter Your Choice Between(0-2). Thanks!!!");
				break;
			}
		}
	}

	public void initUserSignIn(AccountInfo accountInfo) {
		String choice = null;
		while (true) {
			display.walletSignInMenu(accountInfo.getAccountType(), accountInfo.getAccountHolderFirstName(),
					accountInfo.getAccountHolderLastName(), accountInfo.getAccountBalance());
			choice = readInput.nextLine().trim();
			switch (choice) {
			case "0":
				display.walletExitMessage();
				System.exit(0);
			case "1":
				getUserRegistrationDetails(accountInfo);
				break;
			case "2":
				addMoneyToWallet(accountInfo);
				break;
			case "3":
				payToDigitialWallet(accountInfo);
				break;
			case "4":
				display.walletSignedOutMessage();
				return;
			default:
				System.out.println();
				System.out.println("\tInvalid Choice. Please enter your choice between(1-4). Thanks!!!");
				break;
			}
		}
	}

	public void setUserRegistrationDetails() {
		AccountInfo accountInfo = new AccountInfo();

		if (setUserAccountType(accountInfo) && setUserAccountFirstName(accountInfo)
				&& setUserAccountLastName(accountInfo) && setUserAccountNumber(accountInfo)
				&& setUserMobileNumber(accountInfo) && setUserGovtId(accountInfo) && setUserAccountPassword(accountInfo)
				&& setUserOtpDetails(accountInfo)) {

			accountHolders.put(accountInfo.getMobileNumber(), accountInfo);

			display.walletBasicAccountInfo(accountInfo.getAccountType(), accountInfo.getAccountHolderFirstName(),
					accountInfo.getAccountHolderLastName(), accountInfo.getAccountBalance());
			display.walletSignedUpSuccess();
			readInput.nextLine();
			return;
		}
		display.walletSignedUpFail();
		display.walletMaxAttempt();
		return;
	}

	public void getUserAccountInfo() {
		int invalidInput = 0;
		display.walletRegMobileNumber();
		do {
			String mobileNumber = readInput.nextLine().trim();
			if (isValidMobileNumber(mobileNumber)) {
				if (accountHolders.isEmpty() || !accountHolders.containsKey(mobileNumber)) {
					display.walletInvalidRegMobileNumber();
					return;
				}
				accountInfo = (AccountInfo) accountHolders.get(mobileNumber);
				display.walletUserPassword();
				String userPassword = readInput.nextLine();
				if (userPassword.equals(accountInfo.getUserPassword())) {
					display.walletSignedInSuccess();
					readInput.nextLine();
					initUserSignIn(accountInfo);
					readInput.nextLine();
					return;
				}
				display.walletIncorrectPwd();
				readInput.nextLine();
				return;
			}
			invalidInput++;
			if (invalidInput != 3) {
				display.walletInvalidMobNumber();
			}
		} while (invalidInput != 3);
		display.walletMaxAttempt();
		return;
	}

	public void getUserRegistrationDetails(AccountInfo accountInfo) {
		display.walletAccountInfo(accountInfo.getAccountType(), accountInfo.getAccountHolderFirstName(),
				accountInfo.getAccountHolderLastName(), accountInfo.getAccountNumber(), accountInfo.getMobileNumber(),
				accountInfo.getGovtIdNumber(), accountInfo.getAccountBalance(), accountInfo.getUserPassword());
		readInput.nextLine();
	}

	public void addMoneyToWallet(AccountInfo accountInfo) {
		int invalidInput = 0;
		display.walletBalanceAddShow(accountInfo.getAccountBalance());
		while (invalidInput != 3) {
			String addBalance = readInput.nextLine();
			if (isValidAmount(addBalance)) {
				double accountBalance = Double.parseDouble(addBalance);
				accountBalance += accountInfo.getAccountBalance();
				if (accountBalance > 20000) {
					display.walletBalanceLimit(accountInfo.getAccountBalance());
					return;
				}
				accountInfo.setAccountBalance(accountBalance);
				display.walletUpdatedBalance(accountInfo.getAccountBalance());
				readInput.nextLine();
				return;
			}
			invalidInput++;
			if (invalidInput != 3) {
				display.walletInvalidAmt();
			}
		}
		display.walletMaxAttempt();
		return;
	}

	public boolean payToDigitialWallet(AccountInfo accountInfo) {
		int invalidInput = 0;
		AccountInfo payeeInfo = new AccountInfo();
		display.walletPayMenu(accountInfo.getAccountBalance());
		while (invalidInput != 3) {
			String payeeMobileNumber = readInput.nextLine().trim();
			if (isValidMobileNumber(payeeMobileNumber)) {
				if (accountInfo.getMobileNumber().equalsIgnoreCase(payeeMobileNumber)) {
					display.walletInvalidAccountTxn();
					return false;
				}
				if (accountHolders.isEmpty() || !accountHolders.containsKey(payeeMobileNumber)) {
					display.walletInvalidRegMobileNumber();
					return false;
				}
				payeeInfo = (AccountInfo) accountHolders.get(payeeMobileNumber);
				display.walletPayeeAccountInfo(payeeInfo.getAccountType(), payeeInfo.getAccountHolderFirstName(),
						payeeInfo.getAccountHolderLastName());
				invalidInput = 0;
				break;
			}
			invalidInput++;
			if (invalidInput != 3) {
				display.walletInvalidMobNumber();
			} else {
				display.walletMaxAttempt();
				return false;
			}
		}

		display.walletTxnAmount();
		while (invalidInput != 3) {
			String trfAmount = readInput.nextLine().trim();
			if (isValidAmount(trfAmount)) {
				double payAmount = Double.parseDouble(trfAmount);
				double availableBalance = accountInfo.getAccountBalance();
				if (payAmount > 0 && payAmount <= availableBalance) {
					availableBalance -= payAmount;
					accountInfo.setAccountBalance(availableBalance);

					display.walletTrfAmount(payAmount);
					payAmount += payeeInfo.getAccountBalance();
					payeeInfo.setAccountBalance(payAmount);

					display.walletUpdatedBalance(accountInfo.getAccountBalance());
					readInput.nextLine();
					return true;
				}
				display.walletInsufficientAmount();
				return false;
			}
			invalidInput++;
			if (invalidInput != 3) {
				display.walletInvalidAmt();
			}
		}
		display.walletMaxAttempt();
		return false;
	}

	public boolean setUserAccountType(AccountInfo accountInfo) {
		int invalidInput = 0;
		display.walletAccountType();
		do {
			String accountType = readInput.nextLine().trim();
			if (accountType.equalsIgnoreCase("Y")) {
				accountInfo.setAccountType("Merchant");
				return true;
			} else if (accountType.equalsIgnoreCase("N")) {
				accountInfo.setAccountType("Person");
				return true;
			}
			invalidInput++;
			if (invalidInput != 3) {
				display.walletInvalidAccType();
			}
		} while (invalidInput != 3);
		return false;
	}

	public boolean setUserAccountFirstName(AccountInfo accountInfo) {
		int invalidInput = 0;
		display.walletUserFirstName();
		do {
			String accountHolderFirstName = readInput.nextLine().trim();
			if (isStringOnlyAlphabet(accountHolderFirstName)) {
				accountInfo.setAccountHolderFirstName(accountHolderFirstName);
				return true;
			}
			invalidInput++;
			if (invalidInput != 3) {
				display.walletInvalidFirstName();
			}
		} while (invalidInput != 3);
		return false;
	}

	public boolean setUserAccountLastName(AccountInfo accountInfo) {
		int invalidInput = 0;
		display.walletUserLastName();
		do {
			String accountHolderLastName = readInput.nextLine().trim();
			if (isStringOnlyAlphabet(accountHolderLastName)) {
				accountInfo.setAccountHolderLastName(accountHolderLastName);
				return true;
			}
			invalidInput++;
			if (invalidInput != 3) {
				display.walletInvalidLastName();
			}
		} while (invalidInput != 3);
		return false;
	}

	public boolean setUserAccountNumber(AccountInfo accountInfo) {
		int invalidInput = 0;
		display.walletAccountNumber();
		do {
			String accountNumber = readInput.nextLine().trim();
			if (isValidAccountNumber(accountNumber)) {
				accountInfo.setAccountNumber(accountNumber);
				return true;
			}
			invalidInput++;
			if (invalidInput != 3) {
				display.walletInvalidAccNumber();
			}
		} while (invalidInput != 3);
		return false;
	}

	public boolean setUserMobileNumber(AccountInfo accountInfo) {
		int invalidInput = 0;
		int count = 0;
		while (invalidInput != 3 && count != 3) {
			display.walletMobileNumber();
			String mobileNumber = readInput.nextLine().trim();
			if (isValidMobileNumber(mobileNumber) && !accountHolders.containsKey(mobileNumber)) {
				accountInfo.setMobileNumber(mobileNumber);
				return true;
			}
			if (accountHolders.containsKey(mobileNumber) && count != 3) {
				display.walletAlreadyExist();
				count++;
			} else if (invalidInput != 3) {
				System.out.println();
				System.out.println("\tInvalid Mobile Number!!! ");
				invalidInput++;
			}
		}
		return false;
	}

	public boolean setUserGovtId(AccountInfo accountInfo) {
		int invalidInput = 0;
		display.walletGovtIdNumber();
		do {
			String govtIdNumber = readInput.nextLine().trim();
			if (isValidAlphaNumeric(govtIdNumber)) {
				accountInfo.setGovtIdNumber(govtIdNumber.toUpperCase());
				return true;
			}
			invalidInput++;
			if (invalidInput != 3) {
				display.walletInvalidGovtId();
			}
		} while (invalidInput != 3);
		return false;
	}

	public boolean setUserAccountPassword(AccountInfo accountInfo) {
		int invalidInput = 0;
		display.walletUserPassword();
		do {
			String userPassword = readInput.nextLine().trim();
			if (isValidAlphaNumeric(userPassword)) {
				if (confirmUserAccountPassword(userPassword)) {
					accountInfo.setUserPassword(userPassword);
					return true;
				}
				return false;
			}
			invalidInput++;
			if (invalidInput != 3) {

			}
		} while (invalidInput != 3);

		return false;
	}

	public boolean confirmUserAccountPassword(String userPassword) {
		int invalidInput = 0;
		display.walletUserConfirmPassword();
		while (invalidInput != 3) {
			String confirmUserPassword = readInput.nextLine().trim();
			if (isValidAlphaNumeric(confirmUserPassword) && confirmUserPassword.equals(userPassword)) {
				return true;
			}
			invalidInput++;
			if (invalidInput != 3) {
				display.walletPwdMismatch();
			}
		}
		return false;
	}

	public boolean setUserOtpDetails(AccountInfo accountInfo) {
		int invalidInput = 0;
		display.walletOtpMessage();
		do {
			String otpdetails = readInput.nextLine().trim();
			if (isValidOtpDetails(otpdetails)) {
				accountInfo.setOtpdetails(otpdetails);
				return true;
			}
			invalidInput++;
			if (invalidInput != 3) {
				display.walletInvalidOtp();
			}
		} while (invalidInput != 3);
		return false;
	}

	public boolean isStringOnlyAlphabet(String str) {
		return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$")));
	}

	public boolean isValidMobileNumber(String mobileNumber) {
		return ((mobileNumber != null) && (!mobileNumber.equals("")) && (mobileNumber.matches("^[7-9][0-9]{9}$")));
	}

	public boolean isValidAccountNumber(String accountNumber) {
		int i = 0;
		while (i < accountNumber.length() && accountNumber.charAt(i) == '0')
			i++;
		StringBuffer sb = new StringBuffer(accountNumber);
		sb.replace(0, i, "");
		if (i > 0 && sb.length() == 0) {
			display.walletNonZeroAccNum();
			return false;
		}
		return ((accountNumber != null) && (!accountNumber.equals("")) && (accountNumber.matches("^[0-9]{10,}$")));
	}

	public boolean isValidOtpDetails(String otpdetails) {
		int i = 0;
		while (i < otpdetails.length() && otpdetails.charAt(i) == '0')
			i++;
		StringBuffer sb = new StringBuffer(otpdetails);
		sb.replace(0, i, "");
		if (i > 0 && sb.length() == 0) {
			display.walletNonZeroOtp();
			return false;
		}
		return ((otpdetails != null) && (!otpdetails.equals("")) && (otpdetails.matches("^[0-9]{6}$")));
	}

	public boolean isValidAlphaNumeric(String str) {
		return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z0-9]*$")));
	}

	public boolean isValidAmount(String str) {
		return ((str != null) && (!str.equals("")) && (str.matches("(\\d{1,})(((\\.)(\\d{1,2})){0,1})")));
		// return ((str != null) && (!str.equals("")) &&
		// (str.matches("[0-9]{1,}[\\.]?[0-9]{0,2}")));
	}
}
