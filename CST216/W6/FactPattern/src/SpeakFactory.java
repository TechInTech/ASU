
public class SpeakFactory {
	public Speaking GetStyle(String Style) {
		if(Style == null) {
			return(null);
		}
		
		if(Style.equalsIgnoreCase("SWEARING")) {
			return(new Swearing());
		}
		else
		if(Style.equalsIgnoreCase("WISHING")) {
			return(new Wishing());
		}
		else
		if(Style.equalsIgnoreCase("COMPLAINING")) {
			return(new Complaining());
		}
		return(null); //This is the characteristic of the factory
	}
}
