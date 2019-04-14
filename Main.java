import java.util.ArrayList;
import java.util.Scanner;
/**A responsabilade desta classe é ler os inputs do utilizador e executar o algoritmo, esta classe irá receber  as palavras
 * que pertencem ao nosso dicionário, e depois os pares de palavras que pretendemos a sequência se existir e depois imprime
 * todos os resultados das procuras por meio de um arraylist de string */
public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		algoritmo T = new algoritmo();
		ArrayList<String> F = new ArrayList<String>();
			int j=sc.nextInt();
			for(int i=0;i<j;i++) {
				T.addnodes(sc.next());
			}
			int k = sc.nextInt();
			for(int i =0;i<k;i++) {
				F.add(T.bfs(sc.next(),sc.next()));
			}
			sc.close();
			for(String element:F) {
				System.out.println(element);
			}
}
}