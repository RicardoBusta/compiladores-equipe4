package chapter1_interpreter;

//par
//recebe uma express�o e uma lista de express�es
public class PairExpList extends ExpList {
	public Exp head;
	public ExpList list;
	public PairExpList( Exp e, ExpList l ){
		head = e;
		list = l;
	}
}
