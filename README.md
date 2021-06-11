# redis-crud
Teste de integração com redis e Spring usando CrudRepository

## Criar imagem redis:

docker run -d -e "ALLOW_EMPTY_PASSWORD=YES" -p 6379:6379 --name spring_redis redis:latest
