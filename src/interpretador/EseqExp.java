package interpretador;

//executa um Stm e depois realiza uma express�o
public class EseqExp extends Exp {
	public Stm stm;
	public Exp exp;
	public EseqExp( Stm s, Exp e ){
		stm = s;
		exp = e;
	}
}
