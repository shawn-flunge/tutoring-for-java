package exam;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Calculator calc = new Calculator();
//		//calc = new Calculator();				
//		calc.setOperand(10, 2);
//		System.out.println(calc.getOp1() + "," + calc.getOp2());
//		//calc.operand1=10;
//		//calc.operand2=2;
		
		
//		calc.operator="���ϱ�";
//		
//		if(calc.operator == "���ϱ�") {
//			System.out.println(calc.add());
//		}
//		
//		calc.operator="����";
//		if(calc.operator == "����") {
//			System.out.println(calc.subtract());
//		}
//		
//		calc.operator="���ϱ�";
//		if(calc.operator == "���ϱ�") {
//			System.out.println(calc.multiply());
//		}
//		
//		calc.operator="������";
//		if(calc.operator == "������") {
//			System.out.println(calc.divide());
//		}
		
		
		ExpandedCalc eCalc = new ExpandedCalc();
		
		eCalc.setOperand(8, 2);
		
		System.out.println(eCalc.add());
		System.out.println(eCalc.RShift(1));
		
		firstapp fa = new firstapp();

	}

}


