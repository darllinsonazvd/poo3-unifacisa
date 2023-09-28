use('Empresa');
db.createCollection("Setores")

db.Setores.insertMany(
    [
        {
            "sigla": "TI",
            "descricao": "Tecnologia da Informação",
            "salario": 6000.50
        },
        {
            "sigla": "RH",
            "descricao": "Recursos Humanos",
            "salario": 4500.75
        },
        {
            "sigla": "VEND",
            "descricao": "Vendas",
            "salario": 5500.25
        },
        {
            "sigla": "ENG",
            "descricao": "Engenharia",
            "salario": 7000.00
        }
    ]
)

db.Setores.find().sort({ "salario": -1 }).limit(1)
db.Setores.find().sort({ "salario": 1 }).limit(1)

db.Setores.aggregate([
    {
        $group: {
            _id: "$sigla", // Agrupa os documentos pelo campo "sigla"
            mediaSalario: { $avg: "$salario" } // Calcula a média dos salários
        }
    }
])
