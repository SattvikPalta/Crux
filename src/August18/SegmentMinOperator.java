package August18;

public class SegmentMinOperator implements ISegmentOperator {

	@Override
	public int operation(int lsc, int rsc) {
		// TODO Auto-generated method stub
		return Math.min(lsc, rsc);
	}

	@Override
	public int defaultValue() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

}
