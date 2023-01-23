# APP - Upload XML - Backend

Backend para comunicação junto ao [frontend de upload de xml](https://github.com/jefersonalmeida/app-upload-xml)

## Author

- **Jeferson Almeida**
  - Github - [jefersonalmeida](https://github.com/jefersonalmeida)
  - Linkedin - [jefersonalmeida](https://www.linkedin.com/in/jefersonalmeida/)
  - Twitter - [____jeferson](https://twitter.com/____jeferson)
  - Email - [me@jeferson.net.br](mailto://me@jeferson.net.br)

### Objetivo

Criar um sistema Web composto de um Front-end SPA (Single Page Application)
Angular e um Back-end Java Spring Boot para envio de arquivos XML e posterior
processamento deles.

### API - Links

- [Repositório - Frontend](https://github.com/jefersonalmeida/app-upload-xml)
- [Repositório - Backend](https://github.com/jefersonalmeida/api-upload-xml)

### Tecnologia

- Spring Boot 2+
- Maven 3
- JPA
- Hibernate
- Swagger

**Requisitor**;

* Criar uma interface Web para upload de um ou mais arquivos com extensão `.xml`.
* Para o desenvolvimento da interface, deve ser utilizado o tema Indigo do Angular Material.
* Durante o envio do(s) arquivo(s) mostrar um loader para informar ao usuário que
  estão sendo processados, e ao final esse loader deve desaparecer (utilizar
  componentes do Angular Material).
* Os arquivos contêm uma lista de agentes com código e data em formato ISO, e uma
  lista com quatro regiões (SE, S, NE, N) com sete valores numéricos de geração, compra
  e preço médio.
* Não é necessário validar os dados dos arquivos, considere que eles estarão sempre
  corretos e no formato especificado acima.
* Os arquivos devem ser lidos e enviados um a um, sequencialmente.

**Sugestões de Melhorias**;

* Aplicar testes
* Criar recurso para listagem dos dados por região
* Implementar recursos de segurança
*
  * Refatorar utilizando padrão DDD com arquitetura limpa

---

### USO

```shell
docker-compose -f docker-compose.yml up -d
```

```shell
mvn clean package spring-boot:run
```