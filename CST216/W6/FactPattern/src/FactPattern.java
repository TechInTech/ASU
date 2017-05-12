
public class FactPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpeakFactory speakFactory = new SpeakFactory();
		Speaking saying1 = speakFactory.GetStyle("COMPLAINING");
		saying1.Saying();
		
		Speaking saying2 = speakFactory.GetStyle("WISHING");
		saying2.Saying();
		
		Speaking saying3 = speakFactory.GetStyle("SWEARING");
		saying3.Saying();

	}

}
