# Plano de Teste

## 1. Ferramentas
Liste as ferramentas utilizadas para realizar os testes:
- [ ] **Git**: Controle de versão e gerenciamento de commits.
- [ ]  Testes unitários.
- [ ]  Testes de Integração.
- [ ] **Postman**: Testes de API.

## 2. Procedimentos
Descreva os passos necessários para realizar os testes:

1. **Commit**:
   - Verifique se todas as alterações foram salvas.
   - Execute os testes unitários localmente.
   - Faça o commit seguindo o padrão de nomenclatura estabelecido:
     ```bash
     git add .
     git commit -m "feat: descrição clara da funcionalidade ou correção"
     ```

2. **Pull Request (PR)**:
   - Crie um pull request para a branch principal.
   - Preencha o template de PR com informações sobre as alterações e testes realizados.
   - Espere a aprovação da equipe.

3. **Revisão de Código**:
   - Revise o código enviado no PR.
   - Verifique se o código segue os padrões estabelecidos (linting, formatação, etc.).
   - Teste a funcionalidade implementada no ambiente de staging.

4. **Teste de Integração**:
   - Execute os testes automatizados no pipeline de CI/CD.
   - Verifique se todos os testes passaram e não houve regressões.

5. **Aceite ou Rejeite o PR**:
   - Se todos os testes forem aprovados e o código estiver conforme os padrões, aceite o PR.
   - Caso contrário, solicite alterações e repita os testes.

## 3. Requisitos, Restrições e Configurações
Descreva os requisitos e restrições para realizar os testes:

- **Requisitos**:
  - A branch deve estar sincronizada com a principal antes de iniciar os testes.
  - O ambiente de testes deve estar configurado (ex.: bancos de dados locais ou serviços em containers).

- **Restrições**:
  - Não fazer merge em branches principais sem aprovação.
  - Evitar commits diretos na branch principal.

- **Configurações**:
  - Use Java e quarkus em versões atualizadas (acima da 18) para executar os testes.
  - Configurar variáveis de ambiente (ex.: `.env` para testes locais).

## 4. Matriz de Funcionalidades vs. Testes
Organize as funcionalidades testadas com os respectivos casos de teste:

| Funcionalidade         | Caso de Teste                              | Tipo de Teste        | Resultado Esperado                   |
|-------------------------|--------------------------------------------|----------------------|--------------------------------------|
| Login                  | Usuário válido realiza login               | Teste de Integração  | Retorna token de autenticação       |
| Login                  | Usuário inválido tenta fazer login         | Teste de Integração  | Retorna erro 400                    |
| Cadastro de Produto    | Adicionar novo produto à base de dados     | Teste de Integração  | Produto cadastrado com sucesso      |
| Listagem de Produtos   | Retornar lista de produtos                 | Teste de API         | Retorna JSON com produtos           |
| Interface do Usuário   | Botão de "Salvar" está funcional           | Teste Manual         | Ação de salvar concluída            |
| Filmes                 | Buscar filmes por query                   | Teste de Integração  | Retorna lista contendo o filme      |
| Filmes                 | Carregar lista de filmes                  | Teste de Integração  | Retorna status 200                  |
| Filmes                 | Listar os filmes mais bem avaliados       | Teste de Integração  | Retorna status 200                  |
| Filmes                 | Avaliar um filme                          | Teste de Integração  | Retorna status 201                  |
| Filmes                 | Avaliar filme sem token                   | Teste de Integração  | Retorna erro 401                    |
| Filmes                 | Avaliar filme com "watched" como `false`  | Teste de Integração  | Retorna erro 400                    |
| Filmes                 | Avaliar filme sem nota                    | Teste de Integração  | Retorna erro 400                    |
| Filmes                 | Avaliar filme com IMDB inválido           | Teste de Integração  | Retorna erro 400                    |
| Movie (Classe)         | Construtor com DescriptionIMDB            | Teste Unitário       | Instância criada com valores corretos |
| Movie (Classe)         | Getters e Setters                         | Teste Unitário       | Valores atribuídos e retornados corretamente |
| Usuários               | Criar um usuário                          | Teste de Integração  | Retorna status 201                  |
| Usuários               | Criar um usuário duplicado                | Teste de Integração  | Retorna erro 400                    |
| Usuários               | Criar um usuário sem nome                 | Teste de Integração  | Retorna erro 400                    |
| Usuários               | Criar um usuário sem senha                | Teste de Integração  | Retorna erro 400                    |
| User (Classe)          | Getters e Setters                         | Teste Unitário       | Valores atribuídos e retornados corretamente |




