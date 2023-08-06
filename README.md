
# JoinCommand

Este é o meu primeiro plugin, e ele é bastante simples. Criei-o para um servidor de fastbridge, onde precisava que os jogadores executasse um comando assim que entrassem no servidor. Coloquei a mão na massa e desenvolvi esse plugin de forma básica, mas funcional. (Funciona apenas na 1.8)


## Instalação

Para utilizar o plugin, siga estes passos simples:

```bash
1. Faça o download do plugin nos "releases".
2. Coloque-o na pasta "plugins" do seu servidor.
3. Reinicie o servidor.
```

Agora, o plugin estará funcionando corretamente em seu servidor. Aproveite!"
    
## Demonstração

aqui está o arquivo "config.yml"

```bash
commands:
  - "/simulated: say Olá, %player%! Bem-vindo ao servidor!"
  - "/simulated: give %player% diamond 64"
  - "/simulated: say Seja bem-vindo, %player%!"
  - "/simulated: give %player% iron_sword"
```
Essas linhas de comando usam o "simulated" para garantir que o jogador seja o executor do comando. Dessa forma, parecerá que o jogador deu os comandos diretamente, recebendo uma saudação calorosa e alguns itens para começar sua jornada no servidor. Aproveite a experiência!

