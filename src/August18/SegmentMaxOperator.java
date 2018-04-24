package August18;

public class SegmentMaxOperator implements ISegmentOperator {

	@Override
	public int operation(int lsc, int rsc) {
		// TODO Auto-generated method stub
		return Math.max(lsc, rsc);
	}

	@Override
	public int defaultValue() {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE;
	}

}
