**Sistema de Biblioteca Acadêmica**

**INTRODUÇÃO**

Esta aplicação é um sistema de gerenciamento de biblioteca acadêmica, desenvolvido como parte da disciplina MATA62 – Engenharia de Software I, lecionada em 2024.1 pelo professor Cláudio Sant’Anna para o curso Bacharelado em Sistemas de Informação. O sistema permite que três tipos de usuários (alunos de graduação, alunos de pós-graduação e professores) realizem empréstimos, devoluções e reservas de livros.


Equipe: Matheus Quevedo; Leonardo Veloso.

**FUNCIONALIDADES**

Empréstimo de Livros: Usuários podem emprestar livros disponíveis na biblioteca, seguindo regras específicas para cada tipo de usuário.

Devolução de Livros: Usuários podem devolver livros emprestados, com confirmação de sucesso ou insucesso.

Reserva de Livros: Usuários podem reservar livros, garantindo prioridade no empréstimo.

Observação de Reservas: Professores podem se registrar para serem notificados quando um livro tiver mais de duas reservas simultâneas.

Consultas: O sistema permite consultas sobre informações de livros, empréstimos e reservas de usuários, e notificações de professores.

**CARACTERÍSTICAS**

Persistência de Dados: O sistema não utiliza banco de dados; todos os dados são mantidos em memória.

Interface de Usuário: O sistema opera via linha de comando, sem interface gráfica.

Padrões de Projeto: Utiliza o padrão Singleton para a classe de interação com o usuário e o padrão Command para a comunicação entre classes.

**COMO EXECUTAR
**
Clone o repositório:
git clone https://github.com/matheusquevedodev/trabalho-eng-software.git

Compile e execute o programa “main.java”, que se encontra no diretório do projeto.

**COMANDOS**

A aplicação utiliza o terminal como interface para interação e prevê o uso de comandos para navegar em suas funcionalidades. Os comandos seguem o padrão <comando> <argumento1> <argumento2>, com a ressalva de que alguns comandos requerem os dois argumentos, um ou mesmo apenas o comando. Segue a tabela:

![image](https://github.com/user-attachments/assets/9a90b124-83e8-4ecc-bea8-433f7d509c03)


**PADRÕES UTILIZADOS**

**Singleton:**
O padrão Singleton garante que uma classe tenha apenas uma única instância durante toda a execução do programa, fornecendo um ponto de acesso global a essa instância.

**Command:**
Implementado na classe Entrada, que analisa a entrada do usuário e aciona as classes cmd<comando> (exemplo cmdConsultaLivro e cmdDevolver), que por sua vez acionam a instâncias desejadas e realizam as operações. Esse design possibilita um maior desacoplamento e modularidade ao código elaborado;

**Observer:** 
A classe Livro implementa a interface Subject, que possui o método registrarObservador(Observer). Isso permite que Livro mantenha uma lista de observadores interessados em suas atualizações. Um Professor, pode se cadastrar na lista de observadores.

**Strategy:**
O padrão Strategy é um padrão de design comportamental que permite definir uma família de algoritmos, encapsulá-los em classes separadas, e torná-los intercambiáveis. Isso permite que o comportamento de um objeto seja alterado em tempo de execução sem modificar seu código.
