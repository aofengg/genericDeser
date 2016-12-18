package genericDeser.util;

public class Second {
	private int IntValue;
	private double DoubleValue;
	private boolean BooleanValue;
	
	public Second() {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof Second) {
			Second f = (Second)obj;
			if (IntValue == f.IntValue && 
					DoubleValue == f.DoubleValue && 
					BooleanValue == f.BooleanValue) {
				return true;
			} 
		}
		return false;
	}

	@Override 
	public int hashCode(){
		int hash = 0;
		hash += IntValue * 31;
		hash += DoubleValue *30;
		if (BooleanValue == true) {
			hash += 99;
		} else {
			hash += 22;
		}
		return hash;
	}
	
	
	public void setIntValue(int iIn) {
		IntValue = iIn;
	}
	
	public void setDoubleValue(double dIn) {
		DoubleValue = dIn;
	}

	public void setBooleanValue(boolean bIn) {
		BooleanValue = bIn;
	}
	
	
}
