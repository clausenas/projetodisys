# Projeto para avaliação de conhecimento.
O projeto foi desenvolvido utilizando Spring Boot, Java 11 e banco de dados H2.

links <br>
Swagger http://localhost:8080/swagger-ui.html <br>
H2 http://localhost:8080/h2

Exemplos <br>

Para adicionar um funcionário, basta preencher as informações, para cargo e departamento basta preencher o nome se casa não existir os mesmos serão criados.<br>
Ex:<br>


    "funcionario":{
        "funcionarioNome": "Joa da Silva",
        "funcionarioAge": 35,
        "funcionarioBirthday": "1986-05-07",
        "funcionarioDucument": "01572019611",
        "cargo": {
            "cargoNome": "Desenvolvedor JR"
        }
    },
    
    "departamento": {
        "departamentoName": "CPD"
    }


