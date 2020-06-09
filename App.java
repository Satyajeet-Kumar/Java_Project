public class App {

	public static void main(String[] args) {

		Display display = new Display();
		AccountInfo accountInfo = new AccountInfo();
		Controller controller = new Controller(accountInfo, display);
		controller.initController();
	}

}
