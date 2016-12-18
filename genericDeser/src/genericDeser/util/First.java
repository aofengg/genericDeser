package genericDeser.util;

public class First extends Object {
	private int IntValue;
	private String StringValue;
	private float FloatValue;
	private short ShortValue;

	public First() {

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof First) {
			First f = (First) obj;
			if (IntValue == f.IntValue && StringValue == f.StringValue && FloatValue == f.FloatValue
					&& ShortValue == f.ShortValue) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		if (StringValue != null) {
			char val[] = StringValue.toCharArray();
			for (int i = 1; i <= val.length; i++) {
				hash += val[i - 1] * i;
			}
		}
		hash += IntValue * 31;
		hash += FloatValue * 30;
		hash += ShortValue * 29;
		return hash;
	}

	public void setIntValue(int iIn) {
		IntValue = iIn;
	}

	public void setStringValue(String sIn) {
		StringValue = sIn;
	}

	public void setFloatValue(float fIn) {
		FloatValue = fIn;
	}

	public void setShortValue(short sIn) {
		ShortValue = sIn;
	}

}
