package exam;

public class ExpandedCalc extends Calculator{
	
	public ExpandedCalc() {
		System.out.println("Calculator�� ��ӹ��� expandedCalc��ü ����");
	}

	public int RShift(int x) {
		int result;		
		result = getOp1()>>x;	
		return result;
	}
	
}
