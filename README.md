# 🧩 Data Structure
Afinal, como as listas funcionam? É como um array mas muito melhor quando precisamos que seja dinâmico, ou seja, remover, adicionar e buscar dados. Apesar de usar muito, nunca parei para pensar em como funcionam até criar este projeto de estudos.

## 📖 Bio

Esse é um dos projetos que aprendi no curso da plataforma ADA, onde adquiri muito conhecimento sobre a linguagem Java e programação no geral.

Por meio deste README, tentarei explicar como funcionam as listas.

## 🌱 Básico 

Existem vários tipos de listas, cada uma com uma finalidade diferente, porém, todas têm uma estrutura semelhante. Nesta explicação, irei abordar a lista vinculada conhecida como "LinkedList". Para armazenar uma quantidade N de dados, é preciso criar uma classe "Node", onde ele mesmo armazena a mesma classe e um valor que vamos chamar de "data".

Segue a estrutura:

``````java
class Node<T> {
    T data;
    Node next;

    Node(T data) {
        this.data = data;
    }
}
``````

- **T**: é o tipo de dado que se deseja armazenar (ex: `int`, `float`, `String`).

- **data**: é a variável que armazena o valor desejado.

- **next**: é a variável que armazena uma referência a outro objeto `Node`.

A ideia é ter uma variável que armazena um `Node` com um valor, e, caso precise armazenar mais valores, é só criar uma nova instância de `Node` (`new Node`) e armazená-la no campo `next`.

Vamos estruturar melhor nossa lista: 

``````java
public class LinkedList<T> {
    private Node head;
    private Node tail;
    private int length;
    
    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }
}
``````

- **head**: vai armazenar a raiz da nossa estrutura de dados.

- **tail**: vai armazenar o último dado adicionado.

- **length**: armazena a quantidade de dados na lista, como em um array.

Observe a imagem para compreensão:

``````tex
// 1 dado armazenado
[data] head tail

// 2 dados armazenados
[data] head
[data] tail

// 3 dados armazenados
[data] head
[data]
[data] tail
``````

Observe que `tail` sempre vai estar armazenando o dado mais recente. Para adicionar mais dados, é necessário apenas criar um novo `Node` no campo `next` do `tail` e fazer o `tail` apontar para o novo `Node` que foi criado.

Exemplo:

``````java
// Método que adiciona um novo dado na lista
void append(T data) {
    // Cria um novo Node com o dado desejado
    Node newNode = new Node(data);
    if (length != 0) {
        // Define o próximo do tail como o novo Node
        tail.next = newNode;
    } else {
        // Se a lista estava vazia, o head também será o novo Node
        head = newNode;
    }
    // Atualiza o tail para ser o novo Node
    tail = newNode;
    // Incrementa o tamanho da lista
    length++;
}
``````

Esse é o funcionamento básico de adicionar um elemento a uma lista. Existem algumas considerações adicionais nesse método para lidar com casos como lista vazia, mas essa é a ideia principal.

### ✔️ Conclusão

Agora acredito que você tenha uma noção melhor de como a estrutura de uma lista funciona. Apesar de eu não ter abordado como cada método funciona, imagino que agora você consiga compreender os métodos que estão no código.
