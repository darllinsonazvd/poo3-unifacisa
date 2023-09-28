// Usando a base de dados
use('BdPOO');

// CREATE: Criando uma Instância para a base de dados
db.Aluno.insertOne({nome: "Cleito", matricula : "123456", curso : "Sistemas de Informação"})

// CREATE: Criando múltiplos dados para a base
db.Aluno.insertMany([{nome : "Seu Macedo", matricula : 2345678, curso : "Sistemas de Informação"}, {nome : "Alex", matricula : 123525, curso : "Sistemas de Informação"}])


// READ: Buscar todos os documentos
db.Aluno.find();
db.Aluno.find().pretty();

// READ : Buscar todos os documentos a partir de um critério
db.Aluno.find({nome : "Cleito"}) // Pelo nome
db.Aluno.find({nome : "Cleito"}, {curso : 1}) // Pelo nome com critério de inclusão exclusiva para o curso
db.Aluno.find({nome : "Cleito"}, {curso : 0}) // Pelo nome com critério de exclusão para o curso
db.Aluno.find({$and:[{matricula : {$gte : 123457}}, {curso : "Sistemas de Informação"}]}) // critério composto


// UPDATE : Atualizar dados dentro da base
db.Aluno.updateOne({_id : ObjectId("65159e8c0df946504ab95f88")}, {$set:{disciplinas : ["Banco de Dados com POO", "Web Rest", "Projeto Integrador"]}});
db.Aluno.updateOne({_id : ObjectId("65159f1330d67da49ce6915c")}, {$set:{disciplinas : ["Web Rest", "Projeto Integrador"]}});

db.Aluno.updateOne({_id : ObjectId("65159f1330d67da49ce6915c")}, {$unset:{disciplinas : ""}}); // Remoção de um atributo

// DELETE: Deletar um registro da base
db.Aluno.deleteOne({nome : "Seu Macedo"})

// AGREGAÇÃO
db.Itens.insertMany(
    [
        {_id : 1, produto : "caneta bic", quantidade : 5, preco : 2.4},
        {_id : 2, produto : "lapis de cor", quantidade : 3, preco : 10},
        {_id : 3, produto : "borracha", quantidade : 12, preco : 2},
        {_id : 4, produto : "grampeador", quantidade : 7, preco : 12.4}
    ]
)

db.Itens.aggregate(
    {
        $group: {
            _id : "$produto",
            receita_total : {
                $sum : {
                    $multiply : ["$quantidade", "$preco"]
                }
            }
        }    
    }
)