<h1 align="center">Projeto MongoDB com Spring Boot</h1>

###

<h3 align="left">📑 Sobre</h3>

###

<p align="left">
  Este projeto visa compreender as principais diferenças entre paradigma orientado a documentos e relacional, implementar operações de CRUD, realizar consultas com MongoRepository e Spring Data,
  utilizar padrões DTO e implementar associações entre objetos (aninhados e referências).
</p>

###

<h3 align="left">⚙ Linguagens e ferramentas</h3>

###

<div align="left">
  <img src="https://img.shields.io/badge/MongoDB-47A248?logo=mongodb&logoColor=white&style=for-the-badge" height="30" alt="mongodb logo"  />
  <img width="12" />
  <img src="https://img.shields.io/badge/Spring-6DB33F?logo=spring&logoColor=black&style=for-the-badge" height="30" alt="spring logo"  />
  <img width="12" />
  <img src="https://img.shields.io/badge/Postman-FF6C37?logo=postman&logoColor=black&style=for-the-badge" height="30" alt="postman logo"  />
</div>

###

<h3 align="left">💻 Funcionamento | Exemplo de uso</h3>
## Instalação

1. Clone o repositorio:

```bash
git clone https://github.com/lucasds-tech/workshop-mongodb.git
```

2. Instale e configure o MongoDB / Compass
3. Inicialize-o e connect com o localhost.

## Uso

1. Utilize a aplicação com MongoDB Compass / Postman em http://localhost:8080

## Endpoints da API 
A API fornece os seguintes terminais:

**GET USERS**
```markdown
GET /users - Apresenta uma lista de todos os usuários.
```
```json
    {
        "id": "67aa---------b20",
        "name": "Carlos Silva",
        "email": "carlos@gmail.com"
    }
    {
        "id": "67aa---------b21",
        "name": "Lucas Silva",
        "email": "lucas@gmail.com"
    }
    {
        "id": "67aa---------b22",
        "name": "Diogenes Azevedo",
        "email": "diogenes@gmail.com"
    }
```

**GET POSTS**
```markdown
GET /posts/fullsearch - Apresenta todos os posts listados existentes.
```
```json
{
        "id": "67aa6cdd56812f369e0da204",
        "date": "2025-01-21T00:00:00.000+00:00",
        "tittle": "Partiu viagem",
        "body": "Vou viajar para São Paulo. Abraços!",
        "author": {
            "id": "67aa6cdd56812f369e0da201",
            "name": "Carlos Silva"
        },
        "comments": [
            {
                "text": "Boa viagem cara!",
                "date": "2025-01-21T00:00:00.000+00:00",
                "author": {
                    "id": "67aa6cdd56812f369e0da202",
                    "name": "Lucas Silva"
                }
            },
            {
                "text": "Aproveite bem!",
                "date": "2025-01-22T00:00:00.000+00:00",
                "author": {
                    "id": "67aa6cdd56812f369e0da203",
                    "name": "Diogenes Azevedo"
                }
            }
        ]
}

```

**GET SEARCH POSTS**
```markdown
GET /posts/fullsearch?text=dia - Busca por palavra/frase em um post ou comentario existentes.
```
```json
{
        "id": "67aa6cdd56812f369e0da205",
        "date": "2025-01-23T00:00:00.000+00:00",
        "tittle": "Bom dia",
        "body": "Acordei feliz hoje!",
        "author": {
            "id": "67aa6cdd56812f369e0da201",
            "name": "Carlos Silva"
        },
        "comments": [
            {
                "text": "Tenha um ótimo dia!",
                "date": "2025-01-23T00:00:00.000+00:00",
                "author": {
                    "id": "67aa6cdd56812f369e0da202",
                    "name": "Lucas Silva"
                }
            }
        ]
    }


```

###
<p align="left">
  ┌── Aplicação do cliente <br>
  │  ├── Controller REST<br>
  │  │   ├── Camada de serviços <br>
  │  │   └── Camada de acesso a dados <br>
  │  └── Camada de domínio 
</p>
###

<h3 align="left">◽ Modelo de Domínio</h3>

###

<div align="left">
  <a href="https://ibb.co/RT5qRKhS"><img src="https://i.ibb.co/LdG3VyQP/diag.png" alt="diag" border="0" /></a>
</div>

###
