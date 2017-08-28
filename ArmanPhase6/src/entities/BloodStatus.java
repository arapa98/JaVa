package entities;

public enum BloodStatus {
	Muggle, Muggleborn, Halfblood, Pureblood, Squib, Halfbreed, Parthuman;

	
	
	
	public String toString(BloodStatus _bloodStatus) {
		String bs= "";
		if( BloodStatus.Halfblood.equals(_bloodStatus))
			bs = "Halfblood";
		else if( BloodStatus.Halfbreed.equals(_bloodStatus))
			bs = "Halfbreed";
		else if( BloodStatus.Muggle.equals(_bloodStatus))
			bs = "Muggle";
		else if( BloodStatus.Muggleborn.equals(_bloodStatus))
			bs = "Muggleborn";
		else if( BloodStatus.Pureblood.equals(_bloodStatus))
			bs = "Pureblood";
		else if( BloodStatus.Squib.equals(_bloodStatus))
			bs = "Squib";
		else if( BloodStatus.Parthuman.equals(_bloodStatus))
			bs= "Parthuman";
		else 
			return "the blood status is invalid!";
		return bs;
		
	}

}

