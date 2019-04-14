import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/** Esta classe � a classe respons�vel pela implementa��o do algoritmo, que tem uma ineer classe Node, depois ter� as fun��es
 * de inser��o de Nodes com palavras do dicion�rio, e a fun��o de procura das sequ�ncias de palavras */
public class algoritmo {
		private Queue<Node> queue;
		private Node head;
		private int sz;
		/** Esta fun��o � o construtor desta classe, que ir� inicializar a vari�vel queue*/
		public algoritmo()
		{
			queue = new LinkedList<Node>();
		}
		/**Esta fun��o � respons�vel pela cria��o da classe interna, que ser�o os Nodes */
		public static class Node {
				String word;
				boolean visited;
				int dist;
				List<Node> vizinhos;
				Node next;
				Node father;
				/** Esta fun��o � o construtor da classe interna Node*/
				Node(String a){
					this.word=a;
					this.vizinhos=new ArrayList<>();
					next=null;
					father=null;
				}
				/** Esta fun��o serve para adcionar vizinhos � vari�vel de lista de Nodes da classe Node*/
						public void addvizinhos(Node vizinhoNode)
						{
							this.vizinhos.add(vizinhoNode);
						}
						/** Esta fun��o retorna a vari�vel de lista de Nodes da classe Node*/
						public List<Node> getvizinhos() {
							return vizinhos;
						}
						/** Esta fun��o verifica se a palavra de um node � vizinha da palavra doutro node*/
						public boolean isvizinho(Node a) {
							String palavra = word;
							String palavra2 = a.word;
							boolean is = false;
							if(palavra.length()==palavra2.length()) {
								int i=0;
								int diferenca=0;
								while(i<palavra.length()) {
									if(palavra.charAt(i)!=palavra2.charAt(i)) {
										diferenca++;
									}
									i++;
								}
								if(diferenca==1) {
									is=true;
								}
							}
							return is;
						}
						public String toString() {
							return word;
						}
					}
		/** Esta fun��o adciona os Nodes � LinkedList, percorrendo tamb�m verifica com cada node existente se s�o vizinhos ou n�o */
		public void addnodes(String novo) {
			Node a = new Node(novo);
			if(sz==0) {
				head=a;
				sz++;
			}
			else {
				Node current=head;
				while(current.next!=null) {
					if(current.isvizinho(a)) {
						current.addvizinhos(a);
						a.addvizinhos(current);
					}
					current=current.next;
				}
				if(current.isvizinho(a)) {
					current.addvizinhos(a);
					a.addvizinhos(current);
				}
				current.next=a;
				sz++;
			}
		}
		/** Esta fun��o encontra os nodes atrav�s da palavra que eles cont�m*/ 
		public Node findnode(String a) {
			Node current=head;
			Node find=null;
			while(!current.word.equals(a)&&current.next!=null) {
				current=current.next;
			}
			if(current.word.equals(a)) {
				find=current;
			}
			return find;
		}
		 /** A responsabilidade desta fun��o ser� de realizar o BFS(Breadth-First Search), e ir� relizar essa busca
		  * at� encontrar-mos a palavra destino, depois ir� retornar o tamanho se existir e e caso n�o exista a palavra ou
		  * a sequ�ncia ir� retornar a mensagem respetiva*/
					public String bfs(String palavra,String palavra2)
					{
						ArrayList<String> F = new ArrayList<String>();
						Node node=findnode(palavra);
						if(findnode(palavra)==null ||findnode(palavra2)==null ) {
							return palavra + "->" + palavra2 + ": palavra inexistente";
						}
						setinicial();
						queue.add(node);
						node.visited=true;
						node.dist=1;
						int finaldist=0;
						String end ="";
						while (!queue.isEmpty())
						{
							end =palavra + "->" + palavra2 + ": sequencia inexistente";
							Node element=queue.remove();
							if(element.word.equals(palavra2)) {
								finaldist=element.dist;
								end= palavra + "->" + palavra2 + ": " + finaldist;
								while(element.father!=null) {
									F.add(element.word);
									element=element.father;
								}
								F.add(element.word);
								for(int i=F.size()-1;i>=0;i--) {
									end+= " " + F.get(i);
								}
								break;
							}
							int dist=element.dist;
							List<Node> vizinhos=element.getvizinhos();
							for (int i = 0; i < vizinhos.size(); i++) {
								Node n=vizinhos.get(i);
								if(n!=null && !n.visited)
								{
									queue.add(n);
									n.visited=true;
									n.dist=dist+1;
									n.father=element;
								}
							}
				 
						}
						queue.clear();
						return end;
					}
					/** Esta fun��o serve para repor todos os nodes no seu estado inicial para depois podermos voltar a executar uma busca*/
					public void setinicial() {
						Node current=head;
						while(current.next!=null) {
							current.visited=false;
							current.dist=0;
							current.father=null;
							current=current.next;
						}
						current.visited=false;
						current.dist=0;
						current.father=null;
					}
		
		}  