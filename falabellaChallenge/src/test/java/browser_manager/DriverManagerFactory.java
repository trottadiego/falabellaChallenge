package browser_manager;


public class DriverManagerFactory {
	
	public static DriverManager getManager(DriverType type) {
		
		DriverManager driverManager = null;
		
		switch (type) {
		
		case CHROME: 
			driverManager = new ChromeDriverManager();
			break;
			
		case IE: 
			driverManager = new IEDriverManager();
			break;
			
			default:
				System.out.println("navegador invalido");
				break;
		}
		
		return driverManager;
		
	}

}
