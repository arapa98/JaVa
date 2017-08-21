package entities;

public enum BloodStatus {
	Muggle, Muggleborn, Halfblood, Pureblood, Squib, Halfbreed, Parthuman;

	/*public String _toString( BloodStatus bs) {
		if( "Muggle".equals(bs)) 
			return "Muggle";
		else if( "Muggle_born".equals(bs))
			return "Muggle_born";
		else if( "Half_blood".equals(bs))
			return "Half_blood";
		else if( "Pure_blodd".equals(bs))
			return "Pure_blood";
		else if( "Squib".equals(bs))
			return "Squib";
		else if( "Half_bread".equals(bs))
			return "Half_bread";
		return "";
	}*/
	
	
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

