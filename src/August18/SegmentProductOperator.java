package August18;

public class SegmentProductOperator implements ISegmentOperator{

	@Override
	public int operation(int lsc, int rsc) {
		// TODO Auto-generated method stub
		return lsc * rsc;
	}

	@Override
	public int defaultValue() {
		// TODO Auto-generated method stub
		return 1;
	}

}
