package usj.lp2.pessoas;

import java.util.ArrayList;
import java.util.List;

public class ListaPessoas {
	List<Pessoa>turma;
	public ListaPessoas() {
		turma = new ArrayList<Pessoa>();
		Pessoa p1 = new Pessoa();
		p1.setName("Rafael");
		p1.setEmail("rafaelstalin@hotmail.com");
		turma.add(p1);
		
	}
	
	public List<Pessoa> getListaPessoas(){
		return turma;
	}
}
