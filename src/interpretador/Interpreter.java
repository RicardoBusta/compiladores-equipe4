package interpretador;

/**
 * Trabalho de Compiladores
 * 
 * Equipe:							- Matricula
 * 	Henrique Siqueira Ara�jo 		- XXXXXXX
 * 	Ricardo Bustamante de Queiroz 	- 0301383
 * 	Romulo Gadelha Lima 			- XXXXXXX
 * 	Vanessa Karla da Silva Oliveira - 0315257
 */

// Classe do interpretador. 
// A partir de uma �rvore de Statement, interpreta seu significado.

public class Interpreter {
	
	public static void main(String args[]){
		// Stm prog = (instancia do programa);
		// interpstp(prog);
		
		System.out.println("Yo mon");
	}
	
	// Adiciona o elemento novo como cabe�a da lista anterior.
	// Inser��o feita na cabe�a da lista.
	public Table update ( Table t, String i, int v ){
		Table t2 = new Table(i, v, t);
		return t2;
	}
	
	// Procura valor atribu�do a um identificador especificado.
	// Caso n�o encontre um valor para aquele identificador, assume o valor 0.
	public int lookup(Table t, String key){
		// Se chegou no fim da lista, n�o encontrou o identificador.
		// Vamos assumir que seu valor � zero.
		if(t==null){
			//TODO "erro"
			return 0;
		}
		
		// Se o identificador procurado ocorre na cabe�a da lista, retorna seu valor.
		// Caso contr�rio continua a busca recursivamente.
		if(t.id == key){
			return t.val;
		}else{
			return lookup(t.tail, key);
		}
	}

	// Recebe uma tabela no estado t1 como entrada
	// Interpreta o Statement "s", e retorna uma tabela t2 ap�s a execu��o.
	public Table interpStm (Stm s, Table t){
		Table tt = t;
		
		// CompoundStm composto de 2 Stm.
		// Chamada recursiva para os dois, alterando a tabela tt em sequencia.
		if( s instanceof CompoundStm ){
			tt = interpStm(((CompoundStm) s).stm1, tt);
			tt = interpStm(((CompoundStm) s).stm2, tt);
		}
		
		// AssignStm atribui valor num�rico da express�o ao identificador especificado.
		// Calcula o valor da express�o com interpExp e atualiza a tabela.
		else if( s instanceof AssignStm ){
			IntAndTable ret = interpExp( ((AssignStm) s).exp, t );
			tt = update(ret.t, ((AssignStm) s).i, ret.i);
		}
		
		// Imprime uma lista de express�es.
		else if( s instanceof PrintStm ){
			//fazer depois, imprime statement.
		}
		
		// Retorna tabela depois das altera��es de estados causados pelo Statement.
		return tt;
	}
	public IntAndTable interpExp( Exp e, Table t ){
		IntAndTable res;
		
		// A partir de um identificador, encontrar seu valor na tabela t.
		if( e instanceof IdExp ) {
			
		}
		
		// Um n�mero. Seu valor j� � o retorno.
		else if( e instanceof NumExp ){
			res = new IntAndTable(((NumExp) e).num, t);
		}
		
		// Opera��o matem�tica. *,+,-,/
		// Retorna o valor resultado da express�o.
		else if( e instanceof OpExp){
			//completar
		}
		
		// Executa um statement antes de calcular a express�o interna.
		// Retorna o valor da express�o interna ap�s o statement.
		else if( e instanceof EseqExp){
			//completar
		}		
		
		return res; //provis�rio
	}
}