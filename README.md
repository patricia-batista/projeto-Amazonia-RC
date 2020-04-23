<h1 id="case---amazônia-r.c.-inc.">Case - Amazônia R.C. Inc.</h1>
<p>Inicialmente, fiquei honrada pela missão a mim designada. No momento em que recebi a proposta, me questionei: qual seria a melhor abordagem para começar? Sim, começar. Na minha experiência profissional atual, eu dou suporte a um sistema legado, melhorando pontos específicos por demanda. Não necessariamente construo/penso na arquitetura dele (apesar de viver explorando esse universo em forma de código). Agora ter a chance de ser criativa e implementar uma nova visão organizacional de um sistema desde o início do seu desenvolvimento… Difícil descrever quão animada fiquei com a ideia.<br>
Após uma leitura aprofundada da solicitação, busquei compreender da melhor maneira possível o que estava sendo pedido. Comecei a desenhar (literalmente, com lápis e borracha) o fluxo do momento em que o usuário adiciona o produto no carrinho até a confirmação da compra por e-mail. Com diversas abstrações em mente, montei o esqueleto das especificações (me baseando não só no que foi descrito, mas em pontos que identifiquei que poderiam agregar ao projeto). Já peço perdão de antemão pela a explicação extensa, mas acabei me empolgando verdadeiramente com o case.</p>
<h2 id="especificação-de-requisitos"><strong>1. Especificação de requisitos</strong></h2>
<ul>
<li>
<p><strong>Definição de requisitos do Checkout</strong><br>
R1. Carrinho de compras;<br>
R2. Checkout;<br>
R3. Confirmação de pedido por e-mail;<br>
R4. Cotação do frete.</p>
</li>
<li>
<p><strong>Definição de requisitos do sistema</strong><br>
Organizado por acessos:<br>
Visitante – qualquer usuário pode acessar ao sistema e adicionar produtos no carrinho de compras;<br>
Cliente – visitante cadastrado no banco. Quando o cliente encerra sua sessão, volta a ser considerado visitante;<br>
Administrador;<br>
Banco de dados – onde é armazenado todas as informações do sistema, incluindo cadastro, produtos, informações etc. Também é onde as informações são recuperadas para a interação do usuário com o sistema.</p>
</li>
<li>
<p><strong>Requisitos de Usuário e Requisitos de Sistema</strong><br>
R1 - <em>Carrinho de compras</em><br>
R1.1 - O carrinho de compras é uma analogia ao carrinho de compras físico, onde coloca-se no seu interior o conteúdo desejado pelo usuário. Podendo-se devolver o produto a qualquer momento;<br>
R1.2 - A tela com os produtos do carrinho do usuário pode ser mostrada a ele a qualquer momento;<br>
R1.3 - Na página do carrinho são mostrados todos os produtos adicionados pelo usuário;<br>
R1.4 - Antes do cliente adicionar a compra, ele deve escolher se o produto é no formato *mídia digital ou físico;<br>
R1.5 - Se a compra do pedido for finalizada/confirmada, todos os produtos serão excluídos do carrinho e o número de itens de cada item específico será removido do banco de dados.<br>
R2 - <em>Checkout</em><br>
R2.1 - Para finalizar o pedido, é necessário estar logado. Se caso o usuário não estiver, na tela do carrinho ao selecionar a opção “Fechar pedido”, “visitante” seria redirecionado para a tela de Login.<br>
R2.2 - <em>Produtos do carrinho “visitante” devem ser somados ao carrinho do “usuário”</em>. Obs.: Em uma empresa com o nome muito parecido com o Amâzonia R.C. Inc., não é somado os produtos adicionados como “visitante” aos produtos já existentes no carrinho do “cliente” (o que eu enxergo como uma perda de oportunidade).<br>
R2.3 - Confirmação de endereço do cliente. a) Se caso o cliente não tiver um endereço, a página automaticamente irá redirecionar para a tela de “Cadastro de endereço”. b) Se caso o cliente não estiver de acordo com o endereço que está cadastrado, terá a opção de “Alterar” o endereço;<br>
R2.4 - Escolha da forma de entrega do cliente – validações: a) Caso o cliente escolha receber o produto no formato de *mídia digital (filmes/séries, livros ou músicas), não deve ser cobrado o frete. Obs.: Na outra empresa, já é pré definido essa informação (usuário antes de adicionar o produto no carrinho, decide se é formato digital ou não, se caso selecionar opção “mídia digital”, é automaticamente direcionado para finalização da compra – ou seja, cliente não pode fazer várias compras com formatos diversos de uma vez só, outra funcionalidade que poderia ser melhorada); b) Para produtos físicos (que serão efetivamente entregues), o cálculo do frete deve-se utilizar o WebService dos Correios;<br>
R2.5 - Cupom de desconto: caso o cliente informe um cupom de desconto, deve-se confirmar se o cupom é válido e aplicar somente para os produtos que estão em promoção;<br>
R2.6 - Imposto: Caso os itens sejam livros, jornais, revistas ou eReaders, o sistema deve identificar e aplicar a isenção de imposto conforme disposto na Constituição Art. 150, VI, d.v;<br>
R2.7 - Forma de pagamento;<br>
R2.8 - Ao final do checkout, o cliente deverá receber um e-mail com a confirmação da compra.<br>
R3 - <em>Confirmação de pedido por e-mail</em><br>
R3.1 Após finalizar o processo do checkout, seria apresentada todas as informações para o cliente (todos os produtos com seus respectivos valores, cupom de desconto, frete, impostos, valor total e a forma de pagamento);<br>
R3.2 Cliente seleciona opção de conclusão de compra e assim, seria enviado um e-mail com todas as informações pertinentes a compra;<br>
R4 - <em>Cotação do frete</em><br>
R4.1 – Cálculo do frete baseado em informações solicitadas pelo Web Service do Correio.</p>
</li>
</ul>
<h2 id="diagrama-de-classe"><strong>2. <a href="https://drive.google.com/file/d/1AOV4GbrBiqF46VaSV1Lzte3I6dbk1xlR/view?usp=sharing">Diagrama de classe</a></strong></h2>
<h2 id="padrão-de-arquitetura-de-software"><strong>3. Padrão de arquitetura de software</strong></h2>
<p>MVC – Model, View &amp; Controller (optei por essa modelagem por ser a mais utilizada para plataformas Web)<br>
Model – Modelagem das classes: camada utilizada para atribuição das características e ações do objeto; contém também parte da lógica/regras de negócio;<br>
View – Visualização da interface do usuário: não será abordado (mas podem ser consideradas as classes: “TesteCarrinho” e “TesteCheckout” do pacote “sistema” como se fossem as telas do próprio usuário – somente utilizado para visualizar passo a passo do usuário);<br>
Controller – Controle e integração do sistema (controla a camada de View e Controller – captura os dados da tela/interface do usuário, modelando com a camada Model e repassando para as devidas classes a interação).<br>
Camadas adicionais:<br>
Persistence – Utilizada para o acesso ao banco de dados; classes designadas a essa tarefa seriam denominadas como: “DAO” (Data Access Object) no próprio nome. Exemplo: CupomDAO.<br>
Service – Para acesso à Web Services (internos ou externos). Exemplo: CorreioWebService.<br>
Test – Realização de testes unitários com JUnit.</p>
<h2 id="informações-adicionais"><strong>4. Solução</strong></h2>
<p>Desenvolvimento com a tecnologia: Java 8 e IDE Eclipse 2019-03.</p>
<p>Meus objetivos principais foram:</p>
<ul>
<li>Diminuir a quantidade de estruturas de seleção: if/else e switch/case (organizando melhor as classes e métodos), separando funcionalidades para pontos específicos (regra de negócio em uma parte, acesso ao banco em outra, e por assim vai);</li>
<li>Métodos claros e sucintos (clean code);</li>
<li>Padronização e classificação adequada;</li>
<li>Testes (separei 4 testes unitários que não consegui implementar da forma que gostaria, mas está funcional); as classes “TesteCarrinho” e “TesteCheckout” também podem ser utilizadas para teste.</li>
</ul>
<p>Mais ideias de estruturação e organização para o projeto:</p>
<ul>
<li>Planejei separar também a parte do acesso ao banco de dados como: montagem e estruturação das variáveis e parâmetros para acesso em uma classe e a implementação do acesso em si (o ato de efetivamente acessar ao banco) em outra classe. Exemplo: CupomDAO (dados organizados) e CupomDAOImp (construção da persistência ao banco). Minha ideia sempre foi padronizar utilizações específicas em suas determinadas classes para que cada uma tivesse seu propósito bem definido. Mas como preferi apenas me focar no código do próprio Java, não implementei um banco. Assim o(s) avaliador(es) também teriam total visualização do meu planejamento em apenas um ponto focal, no código;</li>
<li>Pensei na possibilidade de inserir o padrão de projeto “Strategy” (design patterns) para organizar, por exemplo, a classe “Imposto”, assim quanto mais genérico permitisse colocar uma classe (que possivelmente no futuro fosse escalonada), mais fácil de implementar novas funções, filtrá-las etc. Mas infelizmente não consegui inserir essa implementação em tempo hábil.</li>
</ul>
<p>Nota: Mantive alguns comentários no próprio código, mas acredito que esteja bem elegível por si só. Agradeço demasiadamente a oportunidade de me permitir fazer o que eu mais gosto, desenvolver. Foi tão gratificante e construtiva a experiência, que pude adquirir novos conhecimentos que pretendo não só continuar a praticá-los, mas instigá-los e aprimorá-los.<br>
Até o próximo desafio!</p>
