use('Empresa');
db.createCollection("Pessoa")

db.Pessoa.insertMany(
    [
        { nome :"Ralina", idade : 20, cargo : "Professor", cidade : "Agassiz"},
        { nome :"Neille", idade : 7, cargo : "Quality Engineer", cidade : "Caigangan"},
        { nome :"Catharina", idade : 26, cargo : "Actuary", cidade : "Yanjiao"},
        { nome :"Almeda", idade : 14, cargo : "Senior Quality Engineer", cidade : "Varna"},
        { nome :"Felicle", idade : 19, cargo : "Biostatistician II", cidade : "Tall Tamr"},
        { nome :"Adolphus", idade : 9, cargo : "Accountant II", cidade : "Jiaxing"},
        { nome :"Lindsey", idade : 11, cargo : "Librarian", cidade : "Ketapang"},
        { nome :"Corty", idade : 25, cargo : "Compensation Analyst", cidade : "Shazi"},
        { nome :"Juli", idade : 28, cargo : "Electrical Engineer", cidade : "Krzynowłoga Mała"},
        { nome :"Thoma", idade : 12, cargo : "Office Assistant III", cidade : "Afonsoeiro"}
    ]
)


db.Pessoa.updateOne(
    {_id : ObjectId('6515bde80f29fa6963845323')} , 
    {
        $set: {nome : "Neille Cleito"}
        
    }

)

db.Pessoa.updateOne(
    {_id : ObjectId('6515bde80f29fa6963845323')} , 
    {
        $set: {endereco : {rua : "Rua do Pé de Moleque", numero : 865}}

    }

)

db.Pessoa.find(
    {idade : {$gte : 25}}, {_id : 0}
)

db.Pessoa.aggregate([
    {
        $group: {
            _id: "$cidade", // Agrupa por cidade
            mediaIdade: { $avg: "$idade" } // Calcula a média de idade
        }
    },
    {
        $project: {
            _id: 0, // Exclui o campo _id
            cidade: "$_id", // Renomeia _id para cidade
            mediaIdade: 1 // Mantém o campo mediaIdade
        }
    }
])