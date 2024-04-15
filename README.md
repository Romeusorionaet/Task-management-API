<h1 align='center'> API de Gerênciamento de Tarefas </h1>

<p>A aplicação consiste em criar um simples gerenciador de tarefas
com as seguintes funcionalidades:</p>

- Criar uma tarefa
- Atualizar a tarefa
- Remover a tarefa
- Listar tarefas

<br>
<p> Esta aplicação foi desenvolvida utilizando as seguintes tecnologias: </p>

- Java
- Spring Boot
- Spring Data JPA
- PostgreSql

<hr>
<p>Você pode visualizar por meio de uma interface, um caso de uso de um gerenciamento de tarefa, que consome esta aplicação. Clique em <a href="https://github.com/Romeusorionaet/Task-management-WEB" target="_blank">Gestão de Tarefa</a>.</p>

<hr>

<h2>Aplicação pública</h2>

<p>Para execultar esta API em ambiente de desenvolvimento, clone este repositório:</p>

> https://github.com/Romeusorionaet/Task-management-API.git

<p>Execute o comando abaixo no terminal da sua IDE. Para isso, será preciso que tenha o Docker instalado e aberto na sua máquina. Caso não tenha o Docker, <a href="https://docs.docker.com/config/daemon/start/" target="_blank">clique aqui</a>.</p>

> docker-compose up

<h2> EndPoints para Tarefa </h2>

<p>Existem algumas precauções que devem ser observadas, e eu vou destacar cada uma delas como erros imediatamente após cada Endpoint:</p>

<h3>Criação:</h3>

<p>POST("http://localhost:8080/task/create")</p>

<p>JSON de exemplo para criar uma tarefa:</p>

<div>
<pre>
{
	"title": "Título de exemplo",
	"description": "Descrição para a tarefa",
	"responsibleUser": "Romeu",
	"priority": "MEDIUM",
	"deadline": "2024-04-10T12:00:00"
}
</pre>
</div>
<h3>(POST) - Possíveis erros de status 400:</h3>
<code>[
{
"message": "O título deve conter no mínimo 3 caracteres.",
"field": "title"
}
]</code>
<p>/</p>
<code>[
{
"message": "O título deve conter no máximo 100 caracteres.",
"field": "title"
}
]</code>
<p>/</p>
<code>[
{
"message": "A descrição da tarefa deve conter no mínimo 10 caracteres para fornecer detalhes adequados sobre a tarefa.",
"field": "description"
}
]</code>
<p>/</p>
<code>[
{
"message": "A descrição da tarefa pode conter no máximo 2000 caracteres.",
"field": "description"
}
]</code>
<p>/</p>
<code>[
{
"message": "É obrigatório indentificar o responsável pela tarefa.",
"field": "responsibleUser"
}
]</code>
<p>/</p>
<p>Priority só pode receber um desses 3 valores: "LOW", "MEDIUM", "HIGH", caso contrário terá o erro:</p>
<code>
"message": "JSON parse error: Cannot deserialize value of type `esig.tarefas.gestaodetarefas.modules.entities.PriorityTask` from String \"valor aleatório\": not one of the values accepted for Enum class: [HIGH, LOW, MEDIUM]",</code>
<p>/</p>

<p>O prazo de conclusão (deadline) deve ser de pelo menos 1 dia. Se não atender a esse requisito, ou se nenhum valor for passado, o seguinte erro será retornado:</p>

<code>
A data de vencimento deve ser de no mínimo 1 dia futuro de diferença da data atual.
</code>
<hr>

<h3>Acessar todas as tarefas:</h3>
<p>GET("http://localhost:8080/task/get-tasks")</p>

<pre>
[
	{
		"id": "add9dd2a-6c91-4f90-8fdc-a6881fa3b835",
		"title": "Tarefa exemplo 1",
		"description": "descrição da tarefa",
		"responsibleUser": "Romeu",
		"priority": "HIGH",
		"deadline": "2024-05-10T12:00:00",
		"status": "DONE",
		"createdAt": "2024-04-14T13:55:09.138649"
	},
	{
		"id": "56137257-af9a-4dd2-86f4-acef3e7daced",
		"title": "Tarefa exemplo 2",
		"description": "descrição da taref",
		"responsibleUser": "Romeu",
		"priority": "LOW",
		"deadline": "2024-05-10T12:00:00",
		"status": "PROGRESS",
		"createdAt": "2024-04-14T14:45:14.476799"
	}
]
</pre>
<hr>

<h3>Filtargem de tarefas:</h3>

<p>É possível filtrar tarefas por título, descrição, responsável, situação ou prioridade. Se nenhum valor for especificado durante a filtragem, todas as tarefas serão retornadas.</p>

<p>Se a maioria dos campos corresponderem a valores de determinadas tarefas no banco de dados, mas apenas um desses campos não corresponder corretamente, a filtragem retornará um array vazio.</p>

<p>GET("http://localhost:8080/task/search")</p>

<hr>

<h3>Atualizar:</h3>

<p>PUT("http://localhost:8080/task/update")</p>

<p>Os critérios para atualizar os valores de uma tarefa devem ser os mesmos utilizados ao criar uma tarefa.</p>
<hr>

<h3>Concluir uma tarefa:</h3>
<p>PATCH("http://localhost:8080/task/done/taskId")</p>

<p>No caso em que concluír uma tarefa, deverá ser passado o id correto dessa tarefa.</p>

<h3>(PATCH) - Possíveis erros de status 400:</h3>

<code>
Tarefa não encontrada.
</code>
<hr>

<h3>Remover uma tarefa:</h3>

<p>No caso em que remover uma tarefa, deverá ser passado o id dessa tarefa.</p>

<p>DELETE("http://localhost:8080/task/remove/taskId")</p>

<h3>(DELETE) - Possíveis erros de status 400:</h3>

<code>
Tarefa não encontrada.
</code>

<hr>
