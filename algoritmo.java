import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/** Esta classe é a classe responsável pela implementação do algoritmo, que tem uma ineer classe Node, depois terá as funções
 * de inserção de Nodes com palavras do dicionário, e a função de procura das sequências de palavras */
public class algoritmo {
		private Queue<Node> queue;
		private Node head;
		private int sz;
		/** Esta função é o construtor desta classe, que irá inicializar a variável queue*/
		public algoritmo()
		{
			queue = new LinkedList<Node>();
		}
		/**Esta função é responsável pela criação da classe interna, que serão os Nodes */
		public static class Node {
				String word;
				boolean visited;
				int dist;
				List<Node> vizinhos;
				Node next;
				Node father;
				/** Esta função é o construtor da classe interna Node*/
				Node(String a){
					this.word=a;
					this.vizinhos=new ArrayList<>();
					next=null;
					father=null;
				}
				/** Esta função serve para adcionar vizinhos á variável de lista de Nodes da classe Node*/
						public void addvizinhos(Node vizinhoNode)
						{
							this.vizinhos.add(vizinhoNode);
						}
						/** Esta função retorna a variável de lista de Nodes da classe Node*/
						public List<Node> getvizinhos() {
							return vizinhos;
						}
						/** Esta função verifica se a palavra de um node é vizinha da palavra doutro node*/
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
		/** Esta função adciona os Nodes á LinkedList, percorrendo também verifica com cada node existente se são vizinhos ou não */
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
		/** Esta função encontra os nodes através da palavra que eles contêm*/ 
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
		 /** A responsabilidade desta função será de realizar o BFS(Breadth-First Search), e irá relizar essa busca
		  * até encontrar-mos a palavra destino, depois irá retornar o tamanho se existir e e caso não exista a palavra ou
		  * a sequência irá retornar a mensagem respetiva*/
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
					/** Esta função serve para repor todos os nodes no seu estado inicial para depois podermos voltar a executar uma busca*/
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