package chapter1_interpreter;

//Composto Stm
//uma afirma��o composta de duas afirma��es
public class CompoundStm extends Stm {
	public Stm stm1, stm2;
	public CompoundStm( Stm s1, Stm s2 ) {
		stm1 = s1;
		stm2 = s2;
	}
}
