package interpretador;

//Atribui��o
//atribui a uma vari�vel o resultado de uma express�o
public class AssignStm extends Stm {
	public String i;
	public Exp exp;
	public AssignStm( String b, Exp e ) {
		i = b;
		exp = e;
	}
}
